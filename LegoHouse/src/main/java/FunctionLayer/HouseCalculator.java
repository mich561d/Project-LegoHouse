package FunctionLayer;

import java.util.HashMap;

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

    public HashMap<String, Integer> buildHouse(int length, int width, int height, String level) {
        resetCounter();
        calculateHouse(length, width, height);
        return counter;
    }

    private void calculateHouse(int length, int width, int height) {
        calculateLength(length);
        calculateWidth(width);
        calculateHeight(height);
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
