package com.seratic.controller.mobile;

import com.seratic.models.Conexion;
import com.seratic.models.Jugador;
import com.seratic.models.Voto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
     @PostMapping("/voto")
    public Map<String, Object> voto(@RequestBody Voto v){
        Map<String, Object> obj = new HashMap<>();
        try{        
        this.jdbcTemplate.update(
                        "INSERT INTO voto (idUsuario,idJugador) values (?,?)",
                        v.getIdUsuario(),v.getIdJugador());        
        obj.put("success", true);
        } catch (Exception e){
            e.printStackTrace();
            obj.put("success", false);
        } 
        return obj;                                
    }        
}
