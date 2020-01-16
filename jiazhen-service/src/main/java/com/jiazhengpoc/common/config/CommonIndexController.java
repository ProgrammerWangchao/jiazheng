package com.jiazhengpoc.common.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CommonIndexController {

  @RequestMapping("/")
  @ResponseBody
  public ModelAndView  indexPage(){
	  ModelAndView mv = new ModelAndView();
      mv.setViewName("index");
      return mv;
  }
}
