use crate::Solution;

impl Solution {
    pub fn total_fruit(fruits: Vec<i32>) -> i32 {
        let mut map = std::collections::HashMap::<i32, i32>::new();
        let mut ret = 0;
        let mut l = 0;
        for id in 0..fruits.len() {
            map.entry(fruits[id]).and_modify(|v| *v += 1).or_insert(1);
            while map.len() > 2 {
                map.entry(fruits[l]).and_modify(|v| *v -= 1);
                if map[&fruits[l]] == 0 {
                    map.remove(&fruits[l]);
                }
                l += 1;
            }
            ret = ret.max(id - l + 1);
        }
        ret as i32
    }

    pub fn _total_fruit(fruits: Vec<i32>) -> i32 {
        let mut best = 0;
        let mut i = 0;

        let mut num_types = vec![0; fruits.len()];
        let mut distinct_types = 0;

        for j in 0..fruits.len() {
            if num_types[fruits[j] as usize] == 0 {
                distinct_types += 1;
            }
            num_types[fruits[j] as usize] += 1;

            while distinct_types > 2 {
                if num_types[fruits[i] as usize] == 1 {
                    distinct_types -= 1;
                }
                num_types[fruits[i] as usize] -= 1;
                i += 1;
            }

            best = best.max(j - i + 1);
        }

        return best as i32;
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let fruits = vec![1, 2, 1];
        assert_eq!(3, Solution::total_fruit(fruits));
    }
}
