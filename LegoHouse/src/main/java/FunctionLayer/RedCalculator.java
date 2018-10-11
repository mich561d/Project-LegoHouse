package FunctionLayer;

import java.util.HashMap;

public class RedCalculator {

    private static RedCalculator singleton;

    public static RedCalculator Calculator() {
        if (singleton == null) {
            singleton = new RedCalculator();
        }
        return singleton;
    }

    HashMap<String, Integer> counter;

    public HashMap<String, Integer> calculateHouse(HashMap<String, Integer> counter, int length, int width, int height) throws BuilderException {
        this.counter = counter;
        makeWalls(height, length, width);
        calculateMirror();
        return this.counter;
    }

    private void makeWalls(int height, int length, int width) throws BuilderException {
        for (int i = 1; i <= height; i++) {
            if (i < 4) {
                makeWindowAndDoor(i, length, width);
            } else {
                if (i % 2 == 0) {
                    calculateLength(length);
                    calculateWidth(width - 4);
                } else {
                    calculateWidth(width);
                    calculateLength(length - 4);
                }
            }
        }
    }

    private void makeWindowAndDoor(int i, int length, int width) throws BuilderException {
        switch (i) {
            case 1:
                calculateLength(length);
                calculateWidth(width - 4);
                calculateLengthWithDoor(length, 0);
                calculateWidth(width - 4);
                break;
            case 2:
                calculateWidth(width);
                calculateLengthWithWindow(length, 2);
                calculateWidth(width);
                calculateLengthWithDoor(length, 2);
                break;
            case 3:
                calculateLengthWithWindow(length, 0);
                calculateWidth(width - 4);
                calculateLengthWithDoor(length, 0);
                calculateWidth(width - 4);
                break;
            default:
                throw new BuilderException("Somthing went wrong trying to build door and window! Contact Support or try agian.");
        }
    }

    private void calculateMirror() {
        int oldfourxtwo = counter.get("4x2");
        int oldtwoxtwo = counter.get("2x2");
        int oldonextwo = counter.get("1x2");
        counter.put("4x2", oldfourxtwo * 2);
        counter.put("2x2", oldtwoxtwo * 2);
        counter.put("1x2", oldonextwo * 2);
    }

    private void calculateWidth(int width) {
        for (int i = 0; i < width;) {
            if (i + 4 <= width) {
                int oldVal = counter.get("4x2");
                counter.put("4x2", ++oldVal);
                i += 4;
            } else if (i + 2 <= width) {
                int oldVal = counter.get("2x2");
                counter.put("2x2", ++oldVal);
                i += 2;
            } else if (i + 1 <= width) {
                int oldVal = counter.get("1x2");
                counter.put("1x2", ++oldVal);
                i += 1;
            }
        }
    }

    private boolean makeRoomForWindow(int i, int number, int minus) {
        return i + number != 5 - minus && i + number != 6 - minus && i != 5 - minus && i != 6 - minus;
    }

    private boolean makeRoomForDoor(int i, int number, int minus) {
        return makeRoomForWindow(i, number, minus) && i + number != 7 - minus && i + number != 8 - minus && i != 7 - minus && i != 8 - minus;
    }

    private void calculateLengthWithWindow(int length, int minus) {
        for (int i = 0; i < length;) {
            if (i + 4 <= length && makeRoomForWindow(i, 4, minus)) {
                int oldVal = counter.get("4x2");
                counter.put("4x2", ++oldVal);
                i += 4;
            } else if (i + 2 <= length && makeRoomForWindow(i, 2, minus)) {
                int oldVal = counter.get("2x2");
                counter.put("2x2", ++oldVal);
                i += 2;
            } else if (i + 1 <= length && makeRoomForWindow(i, 1, minus)) {
                int oldVal = counter.get("1x2");
                counter.put("1x2", ++oldVal);
                i += 1;
            }
        }
    }

    private void calculateLengthWithDoor(int length, int minus) {
        for (int i = 0; i < length;) {
            if (i + 4 <= length && makeRoomForDoor(i, 4, minus)) {
                int oldVal = counter.get("4x2");
                counter.put("4x2", ++oldVal);
                i += 4;
            } else if (i + 2 <= length && makeRoomForDoor(i, 2, minus)) {
                int oldVal = counter.get("2x2");
                counter.put("2x2", ++oldVal);
                i += 2;
            } else if (i + 1 <= length && makeRoomForDoor(i, 1, minus)) {
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
