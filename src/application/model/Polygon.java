package application.model;

/**
 * Created by Killian Lts on 22/06/2017.
 */
public class Polygon {

    private Point[] points; // ensemble de points constituant le polygone

    /**
     * @param points un tableau de points
     */
    public Polygon(Point[] points) {
        this.points = points;
    }

    /**
     * @return un tableau des points du polygone
     */
    public Point[] getPoints() {
        return this.points;
    }

    public Point getCenter() {
        double centroidX = 0, centroidY = 0;
        for(Point point : getPoints()) {

            centroidX += point.getX();
            centroidY += point.getY();
        }
        return new Point(centroidX / getPoints().length, centroidY / getPoints().length);
    }

    /**
     * @return l'ensemble des points de la droite
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        result.append(points[0]);

        for (int i = 1; i < points.length; i++) {
            result.append(",");
            result.append(points[i].toString());
        }
        result.append("]");
        return result.toString();
    }

}
