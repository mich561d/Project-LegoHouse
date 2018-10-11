package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlaceOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderException {
        int user_id;
        try {
            user_id = ((User) request.getSession().getAttribute("user")).getId();
        } catch (NullPointerException ex) {
            throw new OrderException(ex.getMessage());
        }
        int length = (Integer) request.getSession().getAttribute("length");
        int width = (Integer) request.getSession().getAttribute("width");
        int height = (Integer) request.getSession().getAttribute("height");
        Order order = new Order(user_id, length, width, height, false);
        LogicFacade.placeOrder(order);
        User user = (User) request.getSession().getAttribute("user");
        int count = LogicFacade.getOrderCount(user.getId());
        request.getSession().setAttribute("orderCount", count);
        List<Order> orders = LogicFacade.getAllOrders(user.getId());
        request.getSession().setAttribute("orders", orders);
        return "customerpage";
    }

}
