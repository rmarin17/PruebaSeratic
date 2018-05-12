package com.seratic.controller.web;

import com.seratic.models.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("home.htm")
    public ModelAndView home(HttpServletRequest hsr){
        
       HttpSession session = hsr.getSession();
       String sesion = (String)session.getAttribute("session");
       
       if (sesion == "si"){
            ModelAndView mav = new ModelAndView();
            mav.setViewName("home");
            mav.addObject("usuario", new Usuario());
            return mav; 
       } else {
            return new ModelAndView("redirect:/login.htm");  
       }
    }
}
