package com.seratic.controller.mobile;

import com.seratic.models.Conexion;
import com.seratic.models.Jugador;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobilePlayerController {
    private JdbcTemplate jdbcTemplate;
    
    public MobilePlayerController(){        
        Conexion con = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    @GetMapping("/getPlayers") 
    public List<Jugador> getPlayer(){
        String sql="SELECT * FROM jugador";
        List datos = this.jdbcTemplate.queryForList(sql);
        List<Jugador> list = datos;        
        return list;
    }
}
