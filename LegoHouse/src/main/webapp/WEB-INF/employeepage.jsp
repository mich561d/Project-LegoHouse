<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style/LegoHouseStyle.css" rel="stylesheet" type="text/css"/>
        <title>Employee home page</title>
    </head>
    <body>
        <h1>Hello <%=((User) session.getAttribute("user")).getEmail()%> </h1>
        <table style="border-collapse: collapse; width: 100%;">
            <tbody>
                <tr>
                    <td style="width:50%;">
                        <h3 style="text-align:center;">Send order here!</h3>
                        <div style="text-align: center;">
                            <form name="sendOrder" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="sendOrder">
                                Order ID:<br>
                                <input type="number" name="orderId">
                                <br><br>
                                <input type="submit" value="Send Order">
                            </form>
                            <% if (session.getAttribute("orderError") != null) {
                                    session.getAttribute("orderError");
                                } else if (session.getAttribute("orderDone") != null) {
                                    session.getAttribute("orderDone");
                                } else { %>
                            <br>
                            <%}%>
                        </div>
                    </td>
                    <td style="width:50%;"> 
                        <h3 style="text-align:center;">Promote a user to admin here!</h3>
                        <div style="text-align: center;">
                            <form name="makeAdmin" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="makeAdmin">
                                User ID:<br>
                                <input type="number" name="userId">
                                <br><br>
                                <input type="submit" value="Make Admin">
                            </form>
                            <% if (session.getAttribute("userError") != null) {
                                    session.getAttribute("userError");
                                } else if (session.getAttribute("userDone") != null) {
                                    session.getAttribute("userDone");
                                } else { %>
                            <br>
                            <%}%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align:top;">
                        <h3 style="text-align:center;">List of all orders</h3>
                        <table border="1" style="border-collapse:collapse;width:100%;">
                            <tbody>
                                <tr>
                                    <td style="width: 16.667%;">Id</td>
                                    <td style="width: 16.667%;">User id</td>
                                    <td style="width: 16.667%;">Length</td>
                                    <td style="width: 16.667%;">Width</td>
                                    <td style="width: 16.667%;">Height</td>
                                    <td style="width: 16.667%;">Shipped</td>
                                </tr>
                                <%  List<Order> orders = (List<Order>) request.getSession().getAttribute("orders");
                                    for (int i = 0; i < (Integer) request.getSession().getAttribute("orderCount"); i++) {
                                        Order order = orders.get(i);%>
                                <tr>
                                    <td style="width: 16.667%;"><%= order.getId()%></td>
                                    <td style="width: 16.667%;"><%= order.getUser_id()%></td>
                                    <td style="width: 16.667%;"><%= order.getLength()%></td>
                                    <td style="width: 16.667%;"><%= order.getWidth()%></td>
                                    <td style="width: 16.667%;"><%= order.getHeight()%></td>
                                    <td style="width: 16.667%;"><%= order.isShipped()%></td>
                                </tr>
                                <% }%>
                            </tbody>
                        </table>
                    </td>
                    <td style="vertical-align:top;">
                        <h3 style="text-align:center;">List of all users</h3>
                        <table border="1" style="border-collapse:collapse;width:100%;">
                            <tbody>
                                <tr>
                                    <td style="width: 33.333%;">Id</td>
                                    <td style="width: 33.333%;">Email</td>
                                    <td style="width: 33.333%;">Role</td>
                                </tr>
                                <%  List<User> users = (List<User>) request.getSession().getAttribute("users");
                                    for (int i = 0; i < (Integer) request.getSession().getAttribute("userCount"); i++) {
                                        User user = users.get(i);%>
                                <tr>
                                    <td style="width: 33.333%;"><%= user.getId()%></td>
                                    <td style="width: 33.333%;"><%= user.getEmail()%></td>
                                    <td style="width: 33.333%   ;"><%= user.getRole()%></td>
                                </tr>
                                <% }%>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
