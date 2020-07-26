<%-- 
    Document   : ingresarRequerimiento
    Created on : 21-jul-2020, 15:10:05
    Author     : DellPC
--%>

<%@page import="modelos.Requerimiento"%>
<%@page import="dao.RequerimientoDAO"%>
<%@page import="dao.EncargadoDAO"%>
<%@page import="modelos.Encargado"%>
<%@page import="dao.DepartamentoDAO"%>
<%@page import="modelos.Departamento"%>
<%@page import="dao.AsignarDAO"%>
<%@page import="modelos.Asignar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.GerenciaDAO"%>
<%@page import="modelos.Gerencia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        
        <title>Ingreso Requerimiento</title>
    </head>
    <body class="Body">
            <div class="container col-lg-3">
        <form action="ControladorRequerimiento" method="post">
             <div class="form-group text-center">
                    <p><strong>INGRESAR REQUERIMIENTO</strong></p>
                </div>
            <br>
                    <label>Codigo:</label>
                    <input class="form-control" type="number" name="codigo" placeholder="Ingrese el Codigo Unico">
            <label>Gerencia:</label>
                        <select name="generencia" class="form-control">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Gerencia> gerencias = new GerenciaDAO().obtenerGerencias(); 
                            for(Gerencia e:gerencias){%>
                            <option value="<%= e.getId() %>"><%= e %></option>
                            <% } %>
                        </select>
                    
                    <label>Requerimiento:</label>
                    <textarea class="form-control" cols="20" rows="5" name="requerimiento"></textarea>
                    <br>
            <input  type="submit" value="registrar">
            <input type="hidden" name="accion" value="1"/>
            <br>
            <center>
        <% if(request.getParameter("msj")!= null){%>
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>
            </center>
        </form>
            <a href="menuPrincipal.jsp"><input  type="submit" value="Volver al Menu"></a>
            </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>



