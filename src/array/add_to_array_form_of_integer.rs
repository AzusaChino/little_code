use std::ops::{Div, Rem};

use crate::Solution;

const RADIX: i32 = 10;

impl Solution {
    pub fn add_to_array_form(num: Vec<i32>, k: i32) -> Vec<i32> {
        if k == 0 {
            return num;
        }
        let mut nums = num;
        let mut k = k;
        nums.reverse();
        let mut carry = 0;
        for v in nums.iter_mut() {
            if k > 0 || carry > 0 {
                let temp = *v + k.rem(RADIX) + carry;
                if temp > 9 {
                    *v = temp.rem(RADIX);
                    carry = 1;
                } else {
                    *v = temp;
                    carry = 0;
                }
                k = k.div(RADIX);
            }
        }
        while k > 0 {
            let temp = k.rem(RADIX) + carry;
            if temp > 9 {
                nums.push(temp.rem(RADIX));
                carry = 1;
            } else {
                nums.push(temp);
                carry = 0;
            }
            k = k.div(RADIX);
        }

        if carry > 0 {
            nums.push(1);
        }

        nums.reverse();
        nums
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let nums = vec![9, 9, 9, 9, 9, 9, 9, 9, 9, 9];
        println!("{:?}", Solution::add_to_array_form(nums, 1));

        let nums = vec![2, 7, 4];
        println!("{:?}", Solution::add_to_array_form(nums, 181));

        let nums = vec![2, 1, 5];
        println!("{:?}", Solution::add_to_array_form(nums, 806));

        let nums = vec![0];
        println!("{:?}", Solution::add_to_array_form(nums, 806));

        let nums = vec![6];
        println!("{:?}", Solution::add_to_array_form(nums, 809));
    }
}
