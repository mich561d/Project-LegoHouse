package FunctionLayer;

import java.util.HashMap;
import FunctionLayer.LoginSampleException;

public class HouseCalculator {

    private static HouseCalculator singleton;

    public static HouseCalculator Calculator() {
        if (singleton == null) {
            singleton = new HouseCalculator();
        }
        return singleton;
    }

    HashMap<String, Integer> counter = new HashMap(); // counter to keep track of bricks

    private void resetCounter() {
        counter.clear();
        counter.put("4x2", 0);
        counter.put("2x2", 0);
        counter.put("1x2", 0);
    }

    public HashMap<String, Integer> buildHouse(int length, int width, int height, String level) throws LoginSampleException, BuilderException {
        resetCounter();
        switch (level) {
            case "green":
                counter = GreenCalculator.Calculator().calculateHouse(counter, length, width, height);
                break;
            case "yellow":
                counter = YellowCalculator.Calculator().calculateHouse(counter, length, width, height);
                break;
            case "red":
                counter = RedCalculator.Calculator().calculateHouse(counter, length, width, height);
                break;
            default:
                throw new LoginSampleException("Not valid input");
        }
        return counter;
    }

}
