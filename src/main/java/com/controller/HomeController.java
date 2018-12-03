package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Pontalti X
 *
 */
@Controller
public class HomeController {

   @RequestMapping("/")
   public String index() {
      return "index";
   }
   
}
