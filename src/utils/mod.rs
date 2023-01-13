/**
 * Convert [[i32;2]] array to Vec<Vec<i32>
 */
pub fn convert_slice_vec(slc: &[[i32; 2]]) -> Vec<Vec<i32>> {
    let mut v = vec![];
    for s in slc {
        let inner_v = s.to_vec();
        v.push(inner_v);
    }
    v
}

#[cfg(test)]
mod tests {

    #[test]
    fn test() {
        let slc = [[1, 2], [3, 4]];
        let v = crate::convert_slice_vec(&slc);
        println!("{}, {}", v.len(), v.capacity());
    }
}
