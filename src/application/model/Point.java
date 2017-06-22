package application.model;

/**
 * Created by Killian Lts on 22/06/2017.
 */
public class Point {

    private double x, y; // coordonnées GPS
    private double x1, y1; // coordonnées GPS

    /**
     * @param x latitude
     * @param y longitude
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(String x, String y) {
        this.x1 = x1;
        this.y1 = y1;
    }

    /**
     * @return la latitude
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return la longitude
     */
    public double getY() {
        return this.y;
    }

    /**
     * @return les coordonnées sous la forme (latitude, longitude)
     */
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
