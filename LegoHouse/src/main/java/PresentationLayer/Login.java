package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.User;
import FunctionLayer.UserException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException, UserException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LogicFacade.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        if ("customer".equals(user.getRole())) {
            setupForCustomer(session, user);
        } else if ("employee".equals(user.getRole())) {
            setupForEmployee(session);
        }
        return user.getRole() + "page";
    }

    private void setupForCustomer(HttpSession session, User user) throws OrderException {
        int count = LogicFacade.getOrderCount(user.getId());
        session.setAttribute("orderCount", count);
        List<Order> orders = LogicFacade.getAllOrdersByUser(user.getId());
        session.setAttribute("orders", orders);
    }

    private void setupForEmployee(HttpSession session) throws OrderException, UserException {
        int orderCount = LogicFacade.getAllOrderCount();
        session.setAttribute("orderCount", orderCount);
        List<Order> orders = LogicFacade.getAllOrders();
        session.setAttribute("orders", orders);
        int userCount = LogicFacade.getAllUserCount();
        session.setAttribute("userCount", userCount);
        List<User> users = LogicFacade.getAllUsers();
        session.setAttribute("users", users);
    }

}
