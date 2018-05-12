package com.seratic.controller.mobile;

import com.seratic.models.Conexion;
import com.seratic.models.Util;
import com.seratic.vo.UsuarioVO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobileUserController {
    private JdbcTemplate jdbcTemplate;
    
    public MobileUserController(){        
        Conexion con = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody UsuarioVO u){
        String pass = Util.Encriptar(u.getClave());
        String sql="SELECT * FROM usuario WHERE usuario='"+u.getUsuario()+"' AND clave='"+pass+"' AND tipo='basico'";
        List datos = this.jdbcTemplate.queryForList(sql);
        Map<String, Object> obj = new HashMap<>();
        if (datos.size() > 0){                        
            obj.put("success", true);    
            return obj;        
        }else{            
            obj.put("success", false);
            return obj;
        }                   
    }
    @PostMapping("/newUser")
    public Map<String, Object> regisUser(@RequestBody UsuarioVO u){
        Map<String, Object> obj = new HashMap<>();
        try{        
        this.jdbcTemplate.update(
                        "INSERT INTO usuario (cedula,nombre,apellido,usuario,clave,tipo,fecha) values (?,?,?,?,?,?,?)",
                        u.getCedula(),u.getNombre(),u.getApellido(),u.getUsuario(),u.getClave(),u.getTipo(),u.getFecha());        
        obj.put("success", true);
        } catch (Exception e){
            e.printStackTrace();
            obj.put("success", false);
        } 
        return obj;                                
    }        
    
}
