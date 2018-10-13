package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.User;
import FunctionLayer.UserException;
import java.util.List;

public class DBFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(User user) throws LoginSampleException {
        UserMapper.createUser(user);
        return user;
    }

    public static void createOrder(Order order) throws OrderException {
        OrderMapper.createOrder(order);
    }

    public static int getOrderCount(int id) throws OrderException {
        return OrderMapper.countOrders(id);
    }

    public static List<Order> getAllOrdersByUser(int id) throws OrderException {
        return OrderMapper.getAllOrdersByUser(id);
    }

    public static int getAllOrderCount() throws OrderException {
        return OrderMapper.countAllOrders();
    }

    public static List<Order> getAllOrders() throws OrderException {
        return OrderMapper.getAllOrders();
    }

    public static int getAllUserCount() throws UserException {
        return UserMapper.countAllUsers();
    }

    public static List<User> getAllUsers() throws UserException {
        return UserMapper.getAllUsers();
    }

    public static void makeAdmin(int id) throws UserException {
        UserMapper.makeAdmin(id);
    }

    public static void sendOrder(int id) throws OrderException {
        OrderMapper.shipOrder(id);
    }
}
