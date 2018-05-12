<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
        <!-- css -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="<c:url value='/css/materialize.css'/>" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="<c:url value='/css/style.css'/>" type="text/css" rel="stylesheet" media="screen,projection"/>
        <title>Seratic</title>
    </head>
    <body>
        <!--Navigation Bar-->
        <nav id="nav1" class="nav-extended white" role="navigation">
            <div class="nav-wrapper container">
              <a id="logo-container" href="login.htm" class="brand-logo">Seratic</a><!--lOGO-->
              <ul class="right hide-on-med-and-down ">                
                <li><a href="user.htm" >Usuarios</a></li>
                <li><a href="player.htm">Jugadores</a></li>
              </ul>
              <!--MENU LATERAL para movil-->      
              <ul id="nav-mobile" class="side-nav">                        
                <li><a href="user.htm" >Usuarios</a></li>
                <li><a href="player.htm">Jugadores</a></li>     
              </ul>
              <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
            </div>
        </nav>
        <body>             
            <div class="container">                               
                <center><h3 style="color:teal">Reportes</h3></center>
                <br/>   
                <br/> 
                    <table id="tabla" class="highlight centered responsive-table">  
                        <thead>                          
                            <tr>
                                <th style="font-size:22px;font-family:Britannic Bold;color:teal">Nombre</th>
                                <th style="font-size:22px;font-family:Britannic Bold;color:teal">Apellido</th>
                                <th style="font-size:22px;font-family:Britannic Bold;color:teal">Club del Jugador</th>
                                <th style="font-size:22px;font-family:Britannic Bold;color:teal">Cantidad de Votos</th>                                
                            </tr> 
                        </thead>  
                                              
                        
                        <tbody> 
                            <c:forEach items="${reportes}" var="reportes">  
                            <tr>
                                <td style="font-size:20px;font-family:Raleway regular;"><c:out value="${reportes.nombre}" /></td>
                                <td style="font-size:20px;font-family:Raleway regular;"><c:out value="${reportes.apellido}" /></td>
                                <td style="font-size:20px;font-family:Raleway regular;"><c:out value="${reportes.club}" /></td>
                                <td Style="color: red;font-size:22px;font-family:Britannic Bold;"><c:out value="${reportes.cantidad}" /></td>                                
                            </tr>                            
                            </c:forEach>
                        <tbody>                                  
                    </table>                                                                   
            </div>
         </body>
        
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
        <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="<c:url value='/js/materialize.js'/>"></script>
        <script src="<c:url value='/js/init.js'/>"></script>    
        
        <script>
        $('.modal').modal();    
    </script> 
  </body>
</html>


