class Solution:
    def flood_fill(self, image, sr, sc, new_color):
        origin_color = image[sr][sc]
        if origin_color != new_color:
            self.fill(image, sr, sc, origin_color, new_color)
        return image

    def fill(self, image, sr, sc, origin_color, new_color):
        if sr < 0 or sc < 0 or sr >= len(image) or sc >= len(image[0]) or image[sr][sc] != origin_color:
            return
        image[sr][sc] = new_color
        self.fill(image, sr + 1, sc, origin_color, new_color)
        self.fill(image, sr - 1, sc, origin_color, new_color)
        self.fill(image, sr, sc + 1, origin_color, new_color)
        self.fill(image, sr, sc - 1, origin_color, new_color)
