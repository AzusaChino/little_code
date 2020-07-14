function handlerClock(hour: number, minutes: number): number {
    let h = hour % 12 * 30 + minutes / 2
    let m = minutes * 6
    let diff = m - h
    return diff > 180 ? 360 - diff : diff
}