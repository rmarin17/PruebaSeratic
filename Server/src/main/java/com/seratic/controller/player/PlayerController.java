package com.seratic.controller.player;

import com.seratic.models.Conexion;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayerController {
    private JdbcTemplate jdbcTemplate;

    public PlayerController() {
        Conexion con = new Conexion();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("player.htm")
    public ModelAndView users(){
        ModelAndView mav = new ModelAndView();
        String sql="select * from jugador";
        List jugadores = this.jdbcTemplate.queryForList(sql);
        mav.addObject("jugadores", jugadores);
        mav.setViewName("jugador/player");
        return mav;      
    }
}
