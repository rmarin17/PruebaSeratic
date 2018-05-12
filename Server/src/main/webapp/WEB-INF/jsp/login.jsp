<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
        <nav class="white" role="navigation"><!--Barra Principal-->
            <div class="nav-wrapper container">
            <a id="logo-container" href="login.htm" class="brand-logo">Seratic</a><!--lOGO-->                            
            </div>
        </nav>

          <div class="section"></div>
          <main id="container">
            <center>                       
                <br/>
                <br/>
                <div class="container" >
                <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 30px 68px 0px 68px; border: 1px solid #EEE;">
                    <h5 class="indigo-text">Ingrese a su cuenta</h5>
                    <form:form method="post" modelAttribute="usuario">
                  
                        <div class='row'>
                          <div class='col s12'>
                          </div>
                        </div>
                        <div class='row'>
                          <div class='input-field col s12'>
                              <i class="material-icons prefix" Style="margin-top: 10px">account_circle</i>
                              <form:label for="icon_prefix" path="usuario">Usuario</form:label>
                              <form:input id="icon_prefix" type="text" class="validate" required="true" aria-required="true" path="usuario" />
                              
                          </div>
                        </div>
                        <div class='row'>
                          <div class='input-field col s12'>
                            <i class="material-icons prefix" Style="margin-top: 10px">lock_outline</i>
                            <form:label for="icon_prefix1" path="clave">Contraseña</form:label>
                            <form:input type="password" id="icon_prefix1"  class="validate" required="true" aria-required="true" path="clave" />
                            
                          </div>
                        </div>
                        <br/>
                        <center>
                          <div class='row'>
                            <button type="submit" value="Enviar" name="submit" class='col s12 btn btn-large waves-effect indigo'>Login</button> 
                          </div>
                        </center>
                        <form:errors path="*" element="div" cssClass="alert alert-danger"></form:errors>
                   </form:form>    
                </div>
              </div>
              <br/>             
            </center>



          </main>

            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
            <!--  Scripts-->
            <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
            <script src="<c:url value='/js/materialize.js'/>"></script>
            <script src="<c:url value='/js/init.js'/>"></script>          
  </body>
</html>



