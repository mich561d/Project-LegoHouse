package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.User;
import FunctionLayer.UserException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakeAdmin extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("userId"));
            LogicFacade.makeAdmin(id);
            request.getSession().setAttribute("userMsg", "User promoted!!");
            int userCount = LogicFacade.getAllUserCount();
            request.getSession().setAttribute("userCount", userCount);
            List<User> users = LogicFacade.getAllUsers();
            request.getSession().setAttribute("users", users);
        } catch (UserException | NumberFormatException e) {
            request.getSession().setAttribute("userMsg", e.getMessage());
        }
        return "employeepage";
    }

}
