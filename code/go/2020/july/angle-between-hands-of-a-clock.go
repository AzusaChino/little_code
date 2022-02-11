package july

import "math"

func handleClock(hour int8, minutes int8) float64 {
	// Degree covered by hour hand (hour area + minutes area)
	h := (hour % 12 * 30) + (minutes / 60 * 30)
	// Degree covered by minute hand (Each minute = 6 degree)
	m := minutes * 6
	// Absolute angle between them
	angle := math.Abs(float64(m - h))
	// If the angle is obtuse (>180), convert it to acute (0<=x<=180)
	if angle > (float64(180)) {
		angle = 360 - angle
	}
	return angle
}
