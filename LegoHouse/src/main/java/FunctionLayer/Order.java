package FunctionLayer;

public class Order {

    int id, user_id, fours, twos, ones;
    boolean shipped;

    public Order(int user_id, int fours, int twos, int ones, boolean shipped) {
        this.user_id = user_id;
        this.fours = fours;
        this.twos = twos;
        this.ones = ones;
        this.shipped = shipped;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getTwos() {
        return twos;
    }

    public void setTwos(int twos) {
        this.twos = twos;
    }

    public int getOnes() {
        return ones;
    }

    public void setOnes(int ones) {
        this.ones = ones;
    }

    public String isShipped() {
        if (shipped) {
            return "true";
        }
        return "false";
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

}
