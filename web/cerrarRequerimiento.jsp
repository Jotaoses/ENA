<%-- 
    Document   : cerrarRequerimiento
    Created on : 21-jul-2020, 15:10:42
    Author     : DellPC
--%>

<%@page import="dao.DepartamentoDAO"%>
<%@page import="modelos.Departamento"%>
<%@page import="dao.GerenciaDAO"%>
<%@page import="dao.AsignarDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Asignar"%>
<%@page import="modelos.Gerencia"%>
<%@page import="modelos.Gerencia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        
        <title>Cerrar Requerimiento</title>
    </head>
    <body class="Body">
            <div class="container col-lg-4">
        <form action="ControladorRequerimiento" method="post">
             <div class="form-group text-center">
                    <p><strong>CERRAR REQUERIMIENTO</strong></p>
                </div>
            <label>Gerencia:</label>
                        <select name="generencia">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Gerencia> gerencias = new GerenciaDAO().obtenerGerencias(); 
                            for(Gerencia e:gerencias){%>
                            <option value="<%= e.getId() %>"><%= e %></option>
                            <% } %>
                        </select>
                    <br>
                    <label>Dpto:</label>
                        <select name="dpto">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Departamento> departamentos = new DepartamentoDAO().obtenerDepartamentos(); 
                            for(Departamento e:departamentos){%>
                            <option value="<%= e.getId() %>"><%= e %></option>
                            <% } %>
                        </select>
                    <br>
                    <br>
                    <label>Asignado a:</label>
                       <select name="asignado">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Asignar> asignados = new AsignarDAO().obtenerAsignados(); 
                            for(Asignar e:asignados){%>
                            <option value="<%= e.getId() %>"><%= e %></option>
                            <% } %>
                        </select>
                    <br>
            <input type="submit" value="Buscar">
            <input type="hidden" name="accion" value=""/>
            <br>
            <table class="form-group text-center" border="1" style="border-collapse: collapse;">
            <tr>
                <td>Gerencia</td>
                <td>Departamento</td>
                <td>Asignado a</td>
                <td>Requerimiento</td>
            </tr>
            <tr>
                <td><a href="#">
                        <button type="button">Cerrar</button>
                    </a></td>
            </tr>
            </table>
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
