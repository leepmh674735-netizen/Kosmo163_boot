package com.winter.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/department/*")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("list")
    public ModelAndView list(ModelAndView mv) throws Exception {
        List<DepartmentDTO> ar = departmentService.list();

        // request와 비슷한 역할, Spring이 제공

        mv.addObject("list", ar);
        mv.setViewName("department/list");

        return mv;
    }

    @GetMapping("detail")
    public void detail(DepartmentDTO departmentDTO, Model model) throws Exception {
        departmentDTO = departmentService.detail(departmentDTO);
        model.addAttribute("d", departmentDTO);

    }

    @GetMapping("create") // URL정보와 JSP의 경로가 같다면 void로 리턴
    public void create() throws Exception {
    }

    @PostMapping("create")
    public String create(DepartmentDTO departmentDTO) throws Exception {

        int result = departmentService.create(departmentDTO);

        // redirect
        return "redirect:./list";

    }

    @PostMapping("delete")
    public String delete(DepartmentDTO departmentDTO) throws Exception {

        int result = departmentService.delete(departmentDTO);

        return "redirect:./list";
    }

    @GetMapping("update")
    public void update(DepartmentDTO departmentDTO, Model model) throws Exception {
        departmentDTO = departmentService.detail(departmentDTO);
        model.addAttribute("d", departmentDTO);

    }

    @PostMapping("update")
    public String update(DepartmentDTO departmentDTO) throws Exception {
        System.out.println(departmentDTO);

        int result = departmentService.update(departmentDTO);
        System.out.println(result);

        return "redirect:./list";

    }

}