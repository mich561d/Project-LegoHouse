<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <h1>Hello <%=request.getParameter("email")%> </h1>
        You are now logged in as a customer of our wonderful site.
        <br/>
        Go to planner:
        <br/>
        <form name="planner" action="FrontController" method="POST">
            <input type="hidden" name="command" value="planner">
            <input type="submit" value="House planner">
        </form>
    </body>
</html>
