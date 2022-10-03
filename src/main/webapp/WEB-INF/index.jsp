<%-- 
    Document   : index
    Created on : 02-10-2022, 21:33:14
    Author     : Damian Sasia Ybar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro Clientes</h1>
        
        <form name="frmForm1" action="proceso" method="get">
            <label>ID</label><br>
            <input type="text" name="txtId" size="3"/>
            <br><br>

            <label>Nombres</label><br>
            <input type="text" name="txtNombres" />
            <br><br>
                
            <label>Apellido1</label><br>
            <input type="text" name="txtApellido1" />
            <br>
            <br><br>
            
            <label>Apellido2</label><br>
            <input type="text" name="txtApellido2" />
            <br>
            <br><br> 
            
             <label>Fecha Nacimiento</label><br>
            <input type="text" name="txtFecha" />
            <br>
            <br><br> 
            
            <input type="submit" value="Registrar">
        </form>
        
        
        
    </body>
</html>
