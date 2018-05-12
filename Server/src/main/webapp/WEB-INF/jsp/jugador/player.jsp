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
                <li><a href="user.htm">Usuarios</a></li>
                <li><a href="report.htm">Reportes</a></li>
              </ul>
              <!--MENU LATERAL para movil-->      
              <ul id="nav-mobile" class="side-nav">                        
                <li><a href="user.htm">Usuarios</a></li>
                <li><a href="report.htm">Reportes</a></li>     
              </ul>
              <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
            </div>
        </nav>
        <body>             
            <div class="container">                               
                <center><h3 style="color:teal">Gestión de Jugadores</h3></center>
                <br/>   
                <br/> 
                    <table id="tabla" class="highlight centered responsive-table">  
                        <thead>                          
                            <tr>
                                <th>cedula</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Usuario</th>
                                <th>Clave</th>
                                <th>Tipo</th>  
                                <th>Fecha de Registro</th>  
                                <th></th>
                                <th></th>
                            </tr> 
                        </thead>  
                                              
                        
                        <tbody> 
                            <c:forEach items="${usuarios}" var="usuarios">  
                            <tr>                                                                        
                                <td><c:out value="${usuarios.cedula}" /></td>
                                <td><c:out value="${usuarios.nombre}" /></td>
                                <td><c:out value="${usuarios.apellido}" /></td>
                                <td><c:out value="${usuarios.usuario}" /></td>
                                <td><c:out value="${usuarios.clave}" /></td>
                                <td><c:out value="${usuarios.tipo}" /></td>   
                                <td><c:out value="${usuarios.fecha}" /></td> 
                                <td><a title="Eliminar" href="#modal<c:out value="${usuarios.cedula}" />" class="modal-trigger"><i Style="color:red;" class="material-icons">delete</i></a></td>  
                                <td><a title="Editar" href="<c:url value="edituser.htm?id=${usuarios.cedula}"/>"><i Style="color:#546e7a;" class="material-icons">edit</i></a></td>                                        
                            </tr>
                            <!-- Modal Structure -->                    
                            <div id="modal<c:out value="${usuarios.cedula}" />" class="modal">
                                <div class="modal-content">
                                <h4>Eliminar</h4>
                                <p>Recuerde que se borrara el evento seleccionado y una vez completada la acción no se podrán volver a recuperar, ¿está seguro de eliminar el evento?</p>
                                </div>
                                <div class="modal-footer">
                                <a class="modal-action modal-close waves-effect waves-green btn-flat">No</a>
                                <a href="<c:url value="deluser.htm?id=${usuarios.cedula}" />" class="modal-action modal-close waves-effect waves-green btn-flat">Si</a>                        
                                </div>                        
                            </div>    
                            </c:forEach>
                        <tbody>                                  
                    </table>

                    <br/>    
                    <div class="row">                        
                        <div class="col s12">                    
                            <center><a href="adduser.htm"  class="modal-trigger btn-large waves-effect waves-yellow green"><i class="material-icons left">add_circle</i>Agregar Usuario</a></center>
                        </div>
                    </div>
                                                                   
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

