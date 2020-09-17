package cn.az.code.year2020.sept;

/**
 * @author az
 * @since 2020.09.17
 */
public class RobotBoundedCircle {

    public boolean isRobotBounded1(String ins) {
        int x = 0, y = 0, i = 0, d[][] = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};
        for (int j = 0; j < ins.length(); ++j)
            if (ins.charAt(j) == 'R')
                i = (i + 1) % 4;
            else if (ins.charAt(j) == 'L')
                i = (i + 3) % 4;
            else {
                x += d[i][0]; y += d[i][1];
            }
        return x == 0 && y == 0 || i > 0;
    }

    public boolean isRobotBounded(String instructions) {
        int[][] directions = {
            {0,1},
            {-1,0},
            {0,-1},
            {1,0}
        };
        String[] ins = instructions.split("");
        int[] point = {0,0};
        int d = 0;
        int[] currentDirection = directions[d];
        for (String i : ins) {
            currentDirection = directions[d];
            if ("L".equals(i)) {
                d = (d+3)%4;
            } else if("R".equals(i)) {
                d = (d+1)%4;
            } else {
                point[0] += currentDirection[0];
                point[1] += currentDirection[1];
            }
        }
        return point[0] == 0 && point[1] ==0 || d > 0;
    }
}