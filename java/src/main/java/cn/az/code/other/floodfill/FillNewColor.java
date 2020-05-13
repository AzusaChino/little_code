package cn.az.code.other.floodfill;

/**
 * @author az
 * @date 5/13/2020
 */
public class FillNewColor {

    int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        if (originColor != newColor) {
            fill(image, sr, sc, originColor, newColor);
        }
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int originColor, int newColor) {
        // exit condition
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != originColor) {
            return;
        }
        // fill
        image[sr][sc] = newColor;
        // DFS (four direction)
        fill(image, sr + 1, sc, originColor, newColor);
        fill(image, sr - 1, sc, originColor, newColor);
        fill(image, sr, sc + 1, originColor, newColor);
        fill(image, sr, sc - 1, originColor, newColor);
    }
}
