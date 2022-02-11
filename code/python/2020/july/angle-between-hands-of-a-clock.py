def angle_clock(hour, minutes):
    h = (hour % 12) * 30 + minutes * 0.5
    m = minutes * 6
    diff = abs(m - h)
    return min(diff, 360 - diff)
