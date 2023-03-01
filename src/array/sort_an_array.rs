use crate::Solution;

use std::collections::BinaryHeap;

impl Solution {
    pub fn sort_array(nums: Vec<i32>) -> Vec<i32> {
        let maxheap = BinaryHeap::from(nums);
        maxheap.into_sorted_vec()
    }
    fn min_heap(nums: Vec<i32>) -> Vec<i32> {
        let l = nums.len();
        let mut min_heap = std::collections::BinaryHeap::with_capacity(l);
        nums.into_iter()
            .for_each(|n| min_heap.push(std::cmp::Reverse(n)));
        let mut res = Vec::with_capacity(l);
        while !min_heap.is_empty() {
            if let Some(std::cmp::Reverse(max)) = min_heap.pop() {
                res.push(max);
            }
        }
        res
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let nums = vec![1, 2, 3, 4, 5];
        println!("{:?}", Solution::min_heap(nums));
    }
}
