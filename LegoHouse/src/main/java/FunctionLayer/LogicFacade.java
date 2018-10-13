package FunctionLayer;

import DBAccess.DBFacade;
import java.util.HashMap;
import java.util.List;

public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return DBFacade.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        DBFacade.createUser(user);
        return user;
    }

    public static HashMap<String, Integer> createList(int length, int width, int height, String level) throws LoginSampleException, BuilderException {
        return HouseCalculator.Calculator().buildHouse(length, width, height, level);
    }

    public static void placeOrder(Order order) throws OrderException {
        DBFacade.createOrder(order);
    }

    public static int getOrderCount(int id) throws OrderException {
        return DBFacade.getOrderCount(id);
    }

    public static List<Order> getAllOrdersByUser(int id) throws OrderException {
        return DBFacade.getAllOrdersByUser(id);
    }

    public static int getAllOrderCount() throws OrderException {
        return DBFacade.getAllOrderCount();
    }

    public static List<Order> getAllOrders() throws OrderException {
        return DBFacade.getAllOrders();
    }

    public static int getAllUserCount() throws UserException{
        return DBFacade.getAllUserCount();
    }

    public static List<User> getAllUsers() throws UserException{
        return DBFacade.getAllUsers();
    }

    public static void makeAdmin(int id) throws UserException {
        DBFacade.makeAdmin(id);
    }

    public static void sendOrder(int id) throws OrderException {
        DBFacade.sendOrder(id);
    }

}
