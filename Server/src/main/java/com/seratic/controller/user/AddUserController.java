package com.seratic.controller.user;

import com.seratic.models.Conexion;
import com.seratic.models.Usuario;
import java.util.Date;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("adduser.htm")
public class AddUserController {
    private JdbcTemplate jdbcTemplate;

    public AddUserController() {
        Conexion con = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    @GetMapping
    public ModelAndView addevent(){        
       ModelAndView mav = new ModelAndView();
       mav.setViewName("usuario/adduser");
       mav.addObject("usuario", new Usuario());       
       return mav; 
    }
    
    @PostMapping
    public ModelAndView addevent (@ModelAttribute("usuario") Usuario u,
                                BindingResult result,
                                SessionStatus status){
        Date fecha = new Date();
            this.jdbcTemplate.update(
                        "INSERT INTO usuario (cedula,nombre,apellido,usuario,clave,tipo,fecha) VALUES (?,?,?,?,?,?,?)",
                        u.getCedula(),u.getNombre(),u.getApellido(),u.getUsuario(),u.getClave(),u.getTipo(),fecha);
            return new ModelAndView("redirect:/user.htm");        
    }
    
}
