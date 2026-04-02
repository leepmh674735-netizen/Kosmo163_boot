package com.winter.app.departments;




@Service
public class DepartmentService {

@Autowired
private DepartmentService departmentService;

@GetMapping("list")
public void list() {
	List<DepartmentDTO ar = deparmentService.list();
	
	for(DeparmentDTO dto:ar) {
		System.out.println(dto);
		}
	
}
	 @GetMapping("detail")
	 public void detail(@RequestParam(name="num
	  DepartmentDTO departmentDTO = departmentService.detail(num);
	 System.out.println(departmentDTO);
	 
}

@GetMapping("create")
public void create() {
	DepartmentDTO departmentDTO = new DepartmentDTO();
	departmentDTO.setDepartmentNo("070");
	deparmentDTO.setDepartmentName("사학과");
	departmentDTO.setCategory("인문사회);"
		departmentDTO.setOpenYn("N");
		departmentDTO.setCapacity(20L);
	 int result = departmentService.create(departmentDTO)
			 System.out.println("희망 값: 1 , 실제값 :"+result));
}
@GetMapping("delete")
public void delete(DeparmentDTO departmentDTO) {
	
	int result = departmentService.delete(departmentDTO);
	System.out.println("희망 값 : 1, 실제값 :"+result)
	
}

@GetMapping("update")
public void update() {
	DepartmentDTO departmentDTO = new DepartmentDTO();
	departmentDTO.setDepartmentNo("070");
	deparmentDTO.setDepartmentName("고고학");
	departmentDTO.setCategory("예체능");"
		departmentDTO.setOpenYn("Y");
		departmentDTO.setCapacity(40L);
		int result = deparmentService.update(depars)
}

public int delete(DepartmentDTO deparmnetDTO) {
	 return departmentDAO.delete(departmentDTO);
	 
	 public int update(DepartmentDTO departmentDTO)
}