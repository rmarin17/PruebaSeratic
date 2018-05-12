package com.seratic.controller.web.player;

import com.seratic.models.Conexion;
import com.seratic.models.Jugador;
import com.seratic.models.Usuario;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@RequestMapping("addplayer.htm")
public class AddPlayerController {
    private JdbcTemplate jdbcTemplate;

    public AddPlayerController() {
        Conexion con = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    @GetMapping
    public ModelAndView addplayer(HttpServletRequest hsr){   
        HttpSession session = hsr.getSession();
        String sesion = (String)session.getAttribute("session");
        
        if (sesion == "si"){
            ModelAndView mav = new ModelAndView();
            mav.setViewName("jugador/addplayer");
            mav.addObject("jugador", new Jugador());       
            return mav;   
       } else {
            return new ModelAndView("redirect:/login.htm");  
       }   
        
    }
    
    @PostMapping
    public ModelAndView addplayer (@ModelAttribute("usuario") Jugador j,
                                BindingResult result,
                                SessionStatus status){       
            this.jdbcTemplate.update(
                        "INSERT INTO jugador (nombre,apellido,club) VALUES (?,?,?)",
                        j.getNombre(),j.getApellido(),j.getClub());
            return new ModelAndView("redirect:/player.htm");        
    }
}
