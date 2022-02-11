package may

func FloodFill(image [][]int, sr int, sc int, newColor int) [][]int {
	color := image[sr][sc]
	if color != newColor {
		dfs(image, sr, sc, color, newColor)
	}
	return image
}

func dfs(image [][]int, sr int, sc int, color int, newColor int) {
	if sr < 0 || sr >= len(image) || sc < 0 || sc >= len(image[0]) || image[sr][sc] != color {
		return
	}
	image[sr][sc] = newColor
	dfs(image, sr-1, sc, color, newColor)
	dfs(image, sr+1, sc, color, newColor)
	dfs(image, sr, sc-1, color, newColor)
	dfs(image, sr, sc+1, color, newColor)

}
