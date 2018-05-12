
package com.seratic.controller.web.user;

import com.seratic.models.Conexion;
import com.seratic.models.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private JdbcTemplate jdbcTemplate;

    public UserController() {
        Conexion con = new Conexion();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("user.htm")
    public ModelAndView users(HttpServletRequest hsr){
        
        HttpSession session = hsr.getSession();
        String sesion = (String)session.getAttribute("session");
        if (sesion == "si"){
            ModelAndView mav = new ModelAndView();
            String sql="select * from usuario";
            List usuarios = this.jdbcTemplate.queryForList(sql);
            mav.addObject("usuarios", usuarios);
            mav.setViewName("usuario/user");
            return mav;  
       } else {
            return new ModelAndView("redirect:/login.htm");  
       }                             
    }
}
