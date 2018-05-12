/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seratic.controller.player;

import com.seratic.models.Conexion;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("delplayer.htm")
public class DeletePlayerController {
    private JdbcTemplate jdbcTemplate;

    public DeletePlayerController() {
        Conexion con = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @GetMapping
    public ModelAndView delplayer(HttpServletRequest request){        
        int id = Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update(
                        "DELETE FROM jugador "
                    + "WHERE "
                    + "id=?",                    
                    id);
                
        return new ModelAndView("redirect:/player.htm");
    }
    
}
