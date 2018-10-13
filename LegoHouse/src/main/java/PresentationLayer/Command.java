package PresentationLayer;

import FunctionLayer.BuilderException;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;
import FunctionLayer.UserException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("planner", new Planner());
        commands.put("contruct", new Contruct());
        commands.put("order", new PlaceOrder());
        commands.put("makeAdmin", new MakeAdmin());
        commands.put("sendOrder", new SendOrder());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException, BuilderException, OrderException, UserException;

}
