use crate::Solution;

impl Solution {
    pub fn can_place_flowers(flowerbed: Vec<i32>, n: i32) -> bool {
        let mut flowers = flowerbed.clone();
        flowers.insert(0, 0);
        flowers.push(0);

        let mut n = n;
        let mut i = 1;
        while i < flowers.len() - 1 {
            if flowers[i - 1] + flowers[i] + flowers[i + 1] == 0 {
                n -= 1;
                i += 1;
            }
            i += 1;
        }
        n <= 0
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let v = vec![1,0,0,0,1];
        println!("{}", Solution::can_place_flowers(v, 2));
    }
}
