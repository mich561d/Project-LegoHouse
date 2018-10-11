<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style/LegoHouseStyle.css" rel="stylesheet" type="text/css"/>
        <title>Welcome page</title>
    </head>
    <body>
        <h1>Welcome to the Lego Club!</h1>
        <h2>To continue either log in or register!</h2>
        <table>
            <tr>
                <td rowspan="2" style="text-align:left;vertical-align:top;padding:0">
                    <h3>Login</h3>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">
                        Email:<br>
                        <input type="text" name="email" value="someone@nowhere.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password" value="sesam">
                        <br><br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
                <td rowspan="2" style="text-align:left;vertical-align:top;padding:0 0 0 50px">
                    <h3>Register</h3>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Email:<br>
                        <input type="text" name="email" value="someone@nowhere.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password1" value="sesam">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2" value="sesam">
                        <br><br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
            </tr>
        </table>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<H2>Error!!</h2>");
                out.println(error);
            }
        %>
    </body>
</html>
