<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../Style/LegoHouseStyle.css" rel="stylesheet" type="text/css"/>
        <title>Employee home page</title>
    </head>
    <body>
        <h1>Hello <%=((User) session.getAttribute("user")).getEmail()%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.
    </body>
</html>
