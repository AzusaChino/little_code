#![allow(unused)]

use std::collections::BTreeSet;

struct SummaryRanges {
    ranges: BTreeSet<(i32, i32)>,
}

impl SummaryRanges {
    pub fn new() -> Self {
        Self {
            ranges: BTreeSet::new(),
        }
    }

    pub fn add_num(&mut self, value: i32) {
        let mut new_range = (value, value);
        let &left = self
            .ranges
            .range(..(value, value))
            .last()
            .unwrap_or(&new_range);
        let &right = self
            .ranges
            .range((value, value)..)
            .next()
            .unwrap_or(&new_range);

        if left.1 >= value - 1 {
            new_range = (left.0, std::cmp::max(left.1, value));
            self.ranges.remove(&left);
        }
        if right.0 <= value + 1 && new_range.1 < right.1 {
            new_range = (std::cmp::min(new_range.0, right.0), right.1);
            self.ranges.remove(&right);
        }

        self.ranges.insert(new_range);
    }

    fn get_intervals(&self) -> Vec<Vec<i32>> {
        self.ranges.iter().map(|(l, r)| vec![*l, *r]).collect()
    }
}
