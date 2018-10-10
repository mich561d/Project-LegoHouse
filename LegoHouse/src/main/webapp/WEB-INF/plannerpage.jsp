<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Planner Page</title>
    </head>
    <body>
        <h1>Welcome to the house planner!</h1>
        <p>To generate your list of bricks for your next lego house, we need to know four things:</p>
        <table>
            <tbody>
                <tr>
                    <td style="width: 400px;">
                        <form action="FrontController" method="POST" name="contruct">
                            <input name="command" type="hidden" value="contruct" />
                            Length of house (in dots):<br /> 
                            <input min="12" name="length" type="number" value="13" /> 
                            <br /> <br /> 
                            Width of house (in dots):<br /> 
                            <input min="8" name="width" type="number" value="9" /> 
                            <br /> <br /> 
                            Height of house (in blocks):<br /> 
                            <input min="1" name="height" type="number" value="4" /> 
                            <br /> <br /> 
                            Contruction level:<br />
                            <select name="level">
                                <option value="green">Green</option>
                                <option value="yellow">Yellow</option>
                                <option value="red">Red</option>
                            </select>
                            <br /> <br /> 
                            <input type="submit" value="Generate list" />
                        </form>
                    </td>
                    <% if (request.getSession().getAttribute("hasList") != null) {%>
                    <td>
                        <table>
                            <tbody>
                                <tr>
                                    <td>Bricks</td>
                                    <td>Count</td>
                                </tr>
                                <tr>
                                    <td>4x2</td>
                                    <td><%=request.getSession().getAttribute("4x2Count")%></td>
                                </tr>
                                <tr>
                                    <td>2x2</td>
                                    <td><%=request.getSession().getAttribute("2x2Count")%></td>
                                </tr>
                                <tr>
                                    <td>1x2</td>
                                    <td><%=request.getSession().getAttribute("1x2Count")%></td>
                                </tr>
                            </tbody>
                        </table>
                        <br/>
                        <form name="order" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="order">
                            <input type="submit" value="Save this list">
                        </form>
                    </td>
                    <% }%>
                </tr>
            </tbody>
        </table>
    </body>
</html>
