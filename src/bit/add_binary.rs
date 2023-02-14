use crate::Solution;

impl Solution {
    pub fn add_binary(a: String, b: String) -> String {
        use std::iter;
        let mut carry = 0;
        let mut cur_sum = 0;
        let mut char_vec = a
            .as_bytes()
            .iter()
            .rev()
            .chain(iter::repeat(&b'0'))
            .zip(b.as_bytes().iter().rev().chain(iter::repeat(&b'0')))
            .take(a.len().max(b.len()))
            .map(|(ac, bc)| {
                cur_sum = (*ac - b'0') + (*bc - b'0') + carry;
                carry = cur_sum / 2;
                match cur_sum % 2 {
                    1 => '1',
                    _ => '0',
                }
            })
            .collect::<Vec<_>>();

        if carry == 1 {
            char_vec.push('1');
        }

        char_vec.iter().rev().collect()
    }

    pub fn _add_binary(a: String, b: String) -> String {
        format!(
            "{:b}",
            u128::from_str_radix(&a, 2).unwrap() + u128::from_str_radix(&b, 2).unwrap()
        )
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        println!(
            "{}",
            Solution::add_binary("101".to_owned(), "11".to_owned())
        );
    }
}
