<%-- 
    Document   : MuralUFMS
    Created on : 15/03/2017, 11:32:52
    Author     : wandermar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mural UFMS</title>
    </head>
    <body>
        <h1>Mural UFMS!</h1>
        
        <p>Status do servidor </p>
        <c:if test="${not empty usercount}">
                
                <p>Usuários conectados: ${usercount}</p>
                
        </c:if>
    
    </body>
</html>
