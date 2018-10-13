package PresentationLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Planner extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute("user") != null) {
            return "plannerpage";
        }
        return "index";
    }

}
