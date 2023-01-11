use crate::Solution;

impl Solution {
    pub fn fib1(n: i32) -> i32 {
        if n == 0 {
            return 0;
        }
        if n == 1 || n == 2 {
            return 1;
        }

        Solution::fib1(n - 1) + Solution::fib1(n - 2)
    }

    pub fn fib2(n: i32) -> i32 {
        let mut v: Vec<i32> = vec![0; (n + 1) as usize];

        fn fib2_helper(v: &mut Vec<i32>, n: i32) -> i32 {
            if n == 0 {
                return 0;
            }
            if n == 1 || n == 2 {
                return 1;
            }
            let id = n as usize;
            if v[id] != 0 {
                return v[n as usize];
            }
            let val = fib2_helper(v, n - 1) + fib2_helper(v, n - 2);

            v[id] = val;
            val
        }

        fib2_helper(&mut v, n)
    }

    pub fn fib3(n: i32) -> i32 {
        if n == 0 {
            return 0;
        }
        if n == 1 || n == 2 {
            return 1;
        }
        let len = n as usize;
        let mut v: Vec<i32> = vec![0; len + 1];
        // base case
        v[1] = 1;
        v[2] = 1;

        for i in 3..n + 1 {
            let id = i as usize;
            v[id] = v[id - 1] + v[id - 2];
        }

        v[len]
    }

    pub fn fib4(n: i32) -> i32 {
        if n == 0 {
            return 0;
        }
        if n == 1 || n == 2 {
            return 1;
        }
        let mut prev = 1;
        let mut next = 1;
        for _ in 3..n + 1 {
            let sum = prev + next;
            prev = next;
            next = sum;
        }
        next
    }
}

#[cfg(test)]
mod tests {

    #[test]
    fn test() {
        println!("{}", super::Solution::fib1(20));
        println!("{}", super::Solution::fib2(20));
        println!("{}", super::Solution::fib3(20));
        println!("{}", super::Solution::fib4(20));
    }
}
