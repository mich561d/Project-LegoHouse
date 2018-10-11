package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LogicFacade.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        if ("customer".equals(user.getRole())) {
            setupForCustomer(session, user);
        }
        return user.getRole() + "page";
    }

    private void setupForCustomer(HttpSession session, User user) throws OrderException {
        int count = LogicFacade.getOrderCount(user.getId());
        session.setAttribute("orderCount", count);
        List<Order> orders = LogicFacade.getAllOrders(user.getId());
        session.setAttribute("orders", orders);
    }

}
