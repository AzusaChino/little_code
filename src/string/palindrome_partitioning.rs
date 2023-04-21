use crate::Solution;

impl Solution {
    fn partition(s: String) -> Vec<Vec<String>> {
        // backtracking
        // 1. define `ans` to hold `candidates`
        let mut ans = Vec::new();
        // 2. define `candidates` to hold all potential candidates (palindromic substring)
        let mut candidates = Vec::new();
        // 3. start backtrack from index 0
        Solution::backtrack(&s, &mut ans, &mut candidates, 0);
        // 4. return ans
        ans
    }

    fn backtrack(
        s: &String,
        ans: &mut Vec<Vec<String>>,
        candidates: &mut Vec<String>,
        start: usize,
    ) {
        // 1. check if the goal is fulfilled,
        // i.e. reaching the end of string in this problem
        if start == s.len() {
            // if so, we push `candidates` to ans since we've processed all characters
            ans.push(candidates.to_owned());
            return;
        }
        // 2. find all potential candidates
        for i in start..s.len() {
            // we want to test all substrings, each substring is a potential candidate
            // e.g. "aab" -> "a", "a", "b", "ab", "aa", "b", "aab"
            let candidate = &s[start..i + 1];
            // 3. check if the current candidate is palindrome or not
            // if not, then we cannot push to `candidates`
            if Solution::is_palindrome(candidate) {
                // 4. if so, push it to candidates
                candidates.push(candidate.to_string());
                // 5. backtrack with index + 1
                Solution::backtrack(s, ans, candidates, i + 1);
                // 6. remove the current substring from `candidates`
                candidates.pop();
            }
        }
    }

    fn is_palindrome(s: &str) -> bool {
        s.chars().eq(s.chars().rev())
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let s = String::from("aab");
        println!("{:?}", Solution::partition(s));
    }
}
