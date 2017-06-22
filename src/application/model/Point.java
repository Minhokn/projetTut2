package application.model;

/**
 * Created by Killian Lts on 22/06/2017.
 */
public class Point {
    private static final long serialVersionUID = 1L;
    private double x, y; // coordonnÃ©es GPS

    /**
     * @param x
     * latitude
     * @param y
     * longitude
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point(String x, String y){
        this.x = Double.valueOf(x);
        this.y = Double.valueOf(y);
    }

    /**
     * @return
     * la latitude
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return
     * la longitude
     */
    public double getY() {
        return this.y;
    }

    /**
     * @return
     * les coordonnÃ©es sous la forme (latitude, longitude)
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
