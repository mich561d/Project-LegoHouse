<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../Style/LegoHouseStyle.css" rel="stylesheet" type="text/css"/>
        <title>Customer home page</title>
    </head>
    <body>
        <h1>Hello <%=((User) request.getSession().getAttribute("user")).getEmail()%> </h1>
        You are now logged in as a customer of our wonderful site.
        <br/>
        Go to planner:
        <br/>
        <form name="planner" action="FrontController" method="POST">
            <input type="hidden" name="command" value="planner">
            <input type="submit" value="House planner">
        </form>
        <hr>
        <h2> Your orders: </h2>
        <table border="1" style="border-collapse: collapse; width: 100%;">
            <tbody>
                <tr>
                    <td style="width: 1%;">Id</td>
                    <td style="width: 1%;">Length</td>
                    <td style="width: 1%;">Width</td>
                    <td style="width: 1%;">Height</td>
                    <td style="width: 1%;">Shipped</td>
                </tr>
                <%  List<Order> orders = (List<Order>)request.getSession().getAttribute("orders");
                    for (int i = 0; i < (Integer)request.getSession().getAttribute("orderCount"); i++) { 
                    Order order = orders.get(i); %>
                <tr>
                    <td style="width: 1%;"><%= order.getId()%></td>
                    <td style="width: 1%;"><%= order.getLength()%></td>
                    <td style="width: 1%;"><%= order.getWidth()%></td>
                    <td style="width: 1%;"><%= order.getHeight()%></td>
                    <td style="width: 1%;"><%= order.isShipped()%></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
