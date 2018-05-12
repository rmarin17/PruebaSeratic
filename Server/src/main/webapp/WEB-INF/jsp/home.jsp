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
                <li><a href="report.htm">Reportes</a></li>
              </ul>
              <!--MENU LATERAL para movil-->      
              <ul id="nav-mobile" class="side-nav">        
                <li><a href="user.htm" >Usuarios</a></li>
                <li><a href="player.htm">Jugadores</a></li>
                <li><a href="report.htm">Reportes</a></li>      
              </ul>
              <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
            </div>
        </nav>
        

        <div class="container"> 
            <br/>
            <div class="row" align="center">
                <br/>
                <center><h3 style="color:teal">Seratic Recomendaciones Selección Colombia</h3></center>
                <br/>
                <div class="col s m4">
                  <div class="card hoverable medium"  onclick="location.href='user.htm'">
                    <div class="card-image">
                      <img src="<c:url value='/images/usuarios.jpg'/>">
                    </div>
                    <div class="card-content">
                      <p align="justify">Gestiona los apectos de tus usuarios.</p>
                    </div>
                    <div class="card-action">
                      <center><a href="user.hmt">Usuarios</a></center>
                    </div>
                  </div>
                </div>
                
                <div class="col s m4">
                  <div class="card hoverable medium" onclick="location.href='player.htm'">
                    <div class="card-image">
                      <img src="<c:url value='/images/jugadores.jpg'/>">
                    </div>
                    <div class="card-content">
                      <p align="justify">Gestion los aspectos de tus jugadores</p>
                    </div>
                    <div class="card-action">
                      <center><a href="player.htm">Jugadores</a><center>
                    </div>
                  </div>
                </div>
                    
                <div class="col s m4">
                  <div class="card hoverable medium" onclick="location.href='report.htm'">
                    <div class="card-image">
                      <img src="<c:url value='/images/reportes.png'/>">
                    </div>
                    <div class="card-content">
                      <p align="justify">Lleva el Control de Reportes</p>
                    </div>
                    <div class="card-action">
                      <center><a href="report.htm">Reportes</a><center>
                    </div>
                  </div>
                </div>
                
            </div>
        </div>

            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
            <!--  Scripts-->
            <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
            <script src="<c:url value='/js/materialize.js'/>"></script>
            <script src="<c:url value='/js/init.js'/>"></script>          
  </body>
</html>


