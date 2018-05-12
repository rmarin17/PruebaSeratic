package com.seratic.controller;

import com.seratic.models.Conexion;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController {
     private JdbcTemplate jdbcTemplate;

    public ReportController() {
        Conexion con = new Conexion();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("report.htm")
    public ModelAndView report(){
        ModelAndView mav = new ModelAndView();
        String sql="SELECT j.nombre AS nombre, j.apellido AS apellido, j.club AS club, COUNT(v.id) AS cantidad FROM voto v INNER JOIN jugador j ON j.id= v.idJugador INNER JOIN usuario u ON u.cedula = v.idUsuario GROUP BY j.id ";
        List reportes = this.jdbcTemplate.queryForList(sql);
        mav.addObject("reportes", reportes);
        mav.setViewName("report");
        return mav;      
    }
    
}
