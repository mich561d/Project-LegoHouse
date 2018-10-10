package FunctionLayer;

import java.util.HashMap;

public class YellowCalculator {

    private static YellowCalculator singleton;

    public static YellowCalculator Calculator() {
        if (singleton == null) {
            singleton = new YellowCalculator();
        }
        return singleton;
    }

    HashMap<String, Integer> counter;

    public HashMap<String, Integer> calculateHouse(HashMap<String, Integer> counter, int length, int width, int height) {
        this.counter = counter;
        /*
        Calculate first layer by calc length, then width minus 4
        Calculate second layer by calc width, then length minus 4
        and so on (height times)
        */
        calculateLength(length); 
        calculateWidth(width);
        calculateHeight(height);
        return this.counter;
    }

    private void calculateHeight(int height) {
        int oldfourxtwo = counter.get("4x2");
        int oldtwoxtwo = counter.get("2x2");
        int oldonextwo = counter.get("1x2");
        counter.put("4x2", oldfourxtwo * height * 2);
        counter.put("2x2", oldtwoxtwo * height * 2);
        counter.put("1x2", oldonextwo * height * 2);
    }

    private void calculateWidth(int width) {
        int _width = width - 4;
        for (int i = 0; i < _width;) {
            if (i + 4 <= _width) {
                int oldVal = counter.get("4x2");
                counter.put("4x2", ++oldVal);
                i += 4;
            } else if (i + 2 <= _width) {
                int oldVal = counter.get("2x2");
                counter.put("2x2", ++oldVal);
                i += 2;
            } else if (i + 1 <= _width) {
                int oldVal = counter.get("1x2");
                counter.put("1x2", ++oldVal);
                i += 1;
            }
        }
    }

    private void calculateLength(int length) {
        for (int i = 0; i < length;) {
            if (i + 4 <= length) {
                int oldVal = counter.get("4x2");
                counter.put("4x2", ++oldVal);
                i += 4;
            } else if (i + 2 <= length) {
                int oldVal = counter.get("2x2");
                counter.put("2x2", ++oldVal);
                i += 2;
            } else if (i + 1 <= length) {
                int oldVal = counter.get("1x2");
                counter.put("1x2", ++oldVal);
                i += 1;
            }
        }
    }
}
