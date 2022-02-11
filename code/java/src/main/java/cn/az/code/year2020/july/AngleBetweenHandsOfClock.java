package cn.az.code.year2020.july;

/**
 * @author az
 * @since 2020-07-14 21:26
 */
public class AngleBetweenHandsOfClock {

    public double angleClock(int hour, int minutes) {
        // Degree covered by hour hand (hour area + minutes area)
        double h = (hour % 12 * 30) + ((double) minutes / 60 * 30);
        // Degree covered by minute hand (Each minute = 6 degree)
        double m = minutes * 6;
        // Absolute angle between them
        double angle = Math.abs(m - h);
        // If the angle is obtuse (>180), convert it to acute (0<=x<=180)
        return angle > 180 ? 360 - angle : angle;
    }
}
