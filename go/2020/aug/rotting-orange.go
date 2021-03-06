package aug

const (
	empty  = 0
	fresh  = 1
	rotten = 2
	left   = "left"
	right  = "right"
	top    = "top"
	bottom = "bottom"
)

var spreadDirections = [...]string{left, right, top, bottom}

func orangesRotting(grid [][]int) int {
	// slice of possitions of rotten oranges
	rottenPos := [][2]int{}
	// total amount of oranges
	oranges := 0
	// amount of isolated (with no neighbors) rotten oranges
	isolatedRotten := 0

	// go over each element in the grid
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == empty {
				continue
			}
			oranges++ // count found orange
			// check if orange has neighbors
			isolated := isIsolated(i, j, grid)

			// if we found isolated fresh orange (without neighbors)
			// we can say straight away that it will stay safe during
			// c̶o̶r̶o̶n̶a̶v̶i̶r̶u̶s̶ rot will not infect it
			if grid[i][j] == fresh && isolated {
				return -1
			}

			// if we found rotten orange
			// save its position
			if grid[i][j] == rotten {
				if isolated {
					// and count it as isolated
					isolatedRotten++
				}
				rottenPos = append(rottenPos, [2]int{i, j})
			}
		}
	}

	rottenCount := len(rottenPos)
	// some cases when we can say the result
	// before going into calculations
	if oranges == 0 || rottenCount == oranges {
		// box is empty or all oranges are rotten
		return 0
	} else if rottenCount == 0 || rottenCount == isolatedRotten {
		// all oranges are fresh or
		// all rotten oranges are isolated
		// and cannot affect others
		return -1
	}

	// since we might have multiple rotten oranges in the grid
	// and all of them will be infecting others simultaneously
	// (durring the current minute)
	// we can imagine it as a turn-based game
	// where each orange going to infect its neighbors during the same turn
	turn := 0
	newlyRotten := [][2]int{}
	for i := 0; i < len(rottenPos); i++ {
		// infect adjacent oranges and return
		// their positions
		nr := spreadRot(rottenPos[i][0], rottenPos[i][1], grid)

		// save the positions of oranges that were infected
		// durring current turn
		newlyRotten = append(newlyRotten, nr...)

		// checking if all the rotten oranges we had
		// made their infectious move during this turn
		if i == len(rottenPos)-1 {
			if len(newlyRotten) == 0 {
				// no fresh oranges rot during this turn
				// exit the loop
				break
			}

			// we can add newly Rotten Oranges to the list
			rottenPos = append(rottenPos, newlyRotten...)
			// prepare empty list of newly rotten oranges
			newlyRotten = [][2]int{}
			// and proceed to the next turn
			turn++
		}
	}

	// if all oranges are rotten
	// return amount of steps it took
	// to infect all the oranges in the grid
	if len(rottenPos) == oranges {
		return turn
	}

	// rotten oranges couldn't infect others
	return -1
}

func isIsolated(i, j int, grid [][]int) bool {
	res := true

	// check if orange surrounded by empty spaces
	// or grid edges, if it an isolated
	// orange, without any neighbors
	for _, direction := range spreadDirections {
		state, _ := getNeighbor(i, j, grid, direction)
		res = res && (state == nil || *state == empty)
	}

	return res
}

func spreadRot(i, j int, grid [][]int) [][2]int {
	rottenPos := [][2]int{}

	// spread rot into all directions
	for _, direction := range spreadDirections {
		if state, pos := getNeighbor(i, j, grid, direction); state != nil && *state == fresh {
			grid[pos[0]][pos[1]] = rotten
			rottenPos = append(rottenPos, pos)
		}
	}

	return rottenPos
}

func getNeighbor(i, j int, grid [][]int, direction string) (*int, [2]int) {
	switch direction {
	case left:
		if j == 0 {
			// orange already on the most left position
			return nil, [2]int{}
		}
		j-- // do step left
	case right:
		if j == len(grid[i])-1 {
			// orange already on the most right position
			return nil, [2]int{}
		}
		j++ // do step right
	case top:
		if i == 0 {
			// orange already on the most top position
			return nil, [2]int{}
		}
		i-- // do step up
	case bottom:
		if i == len(grid)-1 {
			// orange already on the most bottom position
			return nil, [2]int{}
		}
		i++ // do step down
	}

	return &grid[i][j], [2]int{i, j}
}
