package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlaceOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int user_id = ((User) request.getSession().getAttribute("user")).getId();
        int fours = Integer.parseInt((String) request.getSession().getAttribute("4x2Count"));
        int twos = Integer.parseInt((String) request.getSession().getAttribute("2x2Count"));
        int ones = Integer.parseInt((String) request.getSession().getAttribute("1x2Count"));
        Order order = new Order(user_id, fours, twos, ones, false);
        LogicFacade.placeOrder(order);
        return "customerpage";
    }

}