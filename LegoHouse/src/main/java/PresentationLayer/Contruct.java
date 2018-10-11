package PresentationLayer;

import FunctionLayer.BuilderException;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.User;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Contruct extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, BuilderException, OrderException {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        String level = request.getParameter("level");
        HashMap<String, Integer> list = LogicFacade.createList(length, width, height, level);
        request.getSession().setAttribute("hasList", true);
        request.getSession().setAttribute("length", length);
        request.getSession().setAttribute("width", width);
        request.getSession().setAttribute("height", height);
        request.getSession().setAttribute("4x2Count", list.get("4x2"));
        request.getSession().setAttribute("2x2Count", list.get("2x2"));
        request.getSession().setAttribute("1x2Count", list.get("1x2"));
        request.getSession().setAttribute("ConLevel", level);
        return "plannerpage";
    }

}
