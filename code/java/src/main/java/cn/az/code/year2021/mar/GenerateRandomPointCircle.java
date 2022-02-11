package cn.az.code.year2021.mar;

import java.util.Random;

/**
 * @author ycpang
 * @since 2021-03-17 16:08
 */
public class GenerateRandomPointCircle {

    private final double radius;
    private final double x;
    private final double y;

    public GenerateRandomPointCircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {
        double len = Math.sqrt(Math.random()) * radius;
        double deg = Math.random() * 2 * Math.PI;
        double x = this.x + len * Math.cos(deg);
        double y = this.y + len * Math.sin(deg);
        return new double[]{x, y};
    }

    public double[] $randPoint() {
        Random r = new Random();
        double degree = r.nextDouble() * 360;
        double rd = r.nextDouble() * radius;
        double[] ret = new double[2];
        ret[0] = Math.sin(degree) * rd + x;
        ret[1] = Math.cos(degree) * rd + y;
        return ret;
    }
}
