use std::collections::HashSet;

use crate::Solution;

impl Solution {
    pub fn distinct_names(ideas: Vec<String>) -> i64 {
        let mut groups: Vec<HashSet<String>> = vec![HashSet::new(); 26];
        let mut pairs: i64 = 0;

        // ['c': {"offee"}, 't': {"offee"}]
        ideas.into_iter().for_each(|idea| {
            groups[(idea.as_bytes()[0] - b'a') as usize].insert(idea[1..].to_string());
        });

        for i in 0..25 {
            for j in (i + 1)..26 {
                // i -> 'a', j -> 'b' aoffee <-> boffee
                let dup = groups[i].iter().filter(|&s| groups[j].contains(s)).count();
                pairs += ((groups[i].len() - dup) * (groups[j].len() - dup)) as i64;
            }
        }
        pairs * 2
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let ideas = vec![
            "coffee".to_owned(),
            "donuts".to_owned(),
            "time".to_owned(),
            "toffee".to_owned(),
        ];

        println!("{}", Solution::distinct_names(ideas));
    }
}
