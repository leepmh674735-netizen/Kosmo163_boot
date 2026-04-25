package com.winter.app.board.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

    @Autowired
    private QnaService qnaService;

    // 답글
    @GetMapping("reply")
    public void replyCreate(QnaDTO qnaDTO, Model model) throws Exception {
        model.addAttribute("qnaDTO", qnaDTO);
    }

    @PostMapping("reply")
    public String replyCreate(QnaDTO qnaDTO) throws Exception {
        int result = qnaService.replyCreate(qnaDTO);
        return "redirect:./list";
    }

}
