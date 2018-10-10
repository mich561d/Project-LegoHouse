package PresentationLayer;

import FunctionLayer.Facade;
import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Contruct extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        String level = request.getParameter("level");
        HashMap<String, Integer> list = Facade.createList(length, width, height, level);
        request.getSession().setAttribute("hasList", true);
        request.getSession().setAttribute("4x2Count", list.get("4x2"));
        request.getSession().setAttribute("2x2Count", list.get("2x2"));
        request.getSession().setAttribute("1x2Count", list.get("1x2"));
        request.getSession().setAttribute("ConLevel", level);
        return "plannerpage";
    }
    
}
