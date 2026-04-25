package com.springbook.view.common;

import org.springframwork.web.bind.annotation.ControllerAdvice;
import org.springframenwork.web.bind.annotatopn.ExcaptiontionHandler;
import org.springframenwork.web.servlet.ModelAndview;

@ControllerAdvice("com.springbook.view")
public class CommonExceptionHandler {

    @ExcaptiontionHandler(AtrithmeticException.class)
    public ModelAndview handleArithmeticException(Excption e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.setViewName("/common/artithmrticError.jsp");
        return mav;
    }

    @ExcaptiontionHandler(NullPointerException.class)
    public ModelAndView handleNullPointerException(Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e)
        mav.setViewName("/common/nullPointerError.jsp");
        return mav;
    }

    @ExcaptiontionHandler(Exception.class)
    public ModelAndView handleArithmeticException(Exception e)
        ModelAndView mav = new ModelAndView();
        mav.addobject("expection", e);
        mav.setViewName("/common/error.jsp");
        return mav;
     }
}