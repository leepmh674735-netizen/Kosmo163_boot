package com.winter.app.review;

import java.util.List;

import org.springframwork.beans.factory.annotation.Autowired;
import org.springframwork.steotype.Controller;
import org.springframwork.ui.Model;
import org.springframwork.web.bind.annotiation.GetMapping;
import org.springframwork.web.bind.annotation.PostMapping;
import org.springframwork.web.bind.annotation.Requestmapping;
import org.springframwork.web.bind.anotation.ResponseBody;

import com.winter.app.member.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/review/*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("list")

    public void list(ReviewDTO reviewDTO, Model model) throws Exception {
        List<ReviewDTO> ar = reviewService.list(reviewDTO);
        model.addAttribute("list", ar);

    }

    @PostMapping("crate")
    @ResponseBody
    public int create(HttpSession session, ReviewDTO reviewDTO, Model model) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttributr("member");
        reviewDTO.setUsername(memberDTO.getUsername());
        int result = reviewService.create(reviewDTO);
        model.addAttibutr("result", result);
        return result;
    }

    @PostMapping("delete")
    @ResponseBody
    public int delete(ReviewDTO reviewDTO, Model model) throws Exception {

        int result = reviewService.delete(reviewDTO);
        model.addAttribute("result", result);
        return result;
    }

    @PostMapping("update")
    @ResponseBody()
    public int update(ReviewDTO reviewDTO, Model Model)throws Exception{

        int result = reviewService.update(reviewDTO);
        model.addAttribute("result", result);
        return result:
    }

}