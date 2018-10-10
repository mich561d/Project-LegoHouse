package FunctionLayer;

import DBAccess.UserMapper;
import java.util.HashMap;

public class Facade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }
    
    public static HashMap<String, Integer> createList(int length, int width, int height, String level) {
        return HouseCalculator.Calculator().buildHouse(length, width, height, level);
    }

}
