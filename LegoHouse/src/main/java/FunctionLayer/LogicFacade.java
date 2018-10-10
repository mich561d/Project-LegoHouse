package FunctionLayer;

import DBAccess.DBFacade;
import java.util.HashMap;

public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return DBFacade.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        DBFacade.createUser(user);
        return user;
    }

    public static HashMap<String, Integer> createList(int length, int width, int height, String level) {
        return HouseCalculator.Calculator().buildHouse(length, width, height, level);
    }

    public static void placeOrder(Order order) throws LoginSampleException {
        DBFacade.createOrder(order);
    }

}
