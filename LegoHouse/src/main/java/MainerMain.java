import FunctionLayer.HouseCalculator;
import java.util.HashMap;

public class MainerMain {

    public static void main(String[] args) {
        HouseCalculator HC = new HouseCalculator();
        HashMap<String, Integer> map = HC.buildHouse(13, 9, 4);
        System.out.println("4x2: " + map.get("4x2"));
        System.out.println("2x2: " + map.get("2x2"));
        System.out.println("1x2: " + map.get("1x2"));
    }
}
