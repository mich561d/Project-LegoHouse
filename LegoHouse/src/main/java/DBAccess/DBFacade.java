package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.User;
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
    
    public static List<Order> getAllOrders(int id) throws OrderException {
        return OrderMapper.getAllOrders(id);
    }
}
