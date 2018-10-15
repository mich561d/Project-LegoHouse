package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.UserException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderException, UserException {
        try {
            int id = Integer.parseInt(request.getParameter("orderId"));
            LogicFacade.sendOrder(id);
            request.getSession().setAttribute("orderMsg", "order shipped!");
            int orderCount = LogicFacade.getAllOrderCount();
            request.getSession().setAttribute("orderCount", orderCount);
            List<Order> orders = LogicFacade.getAllOrders();
            request.getSession().setAttribute("orders", orders);
        } catch (OrderException | NumberFormatException e) {
            request.getSession().setAttribute("orderMsg", e.getMessage());
        }
        return "employeepage";
    }

}
