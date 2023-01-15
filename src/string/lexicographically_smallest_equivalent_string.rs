use std::collections::HashMap;

use crate::Solution;

impl Solution {
    pub fn smallest_equivalent_string(s1: String, s2: String, base_str: String) -> String {
        let mut base: [u8; 26] = [97; 26];

        for i in 1..26 {
            base[i] += i as u8;
        }

        let mut ret: Vec<u8> = Vec::with_capacity(base_str.len());

        for i in 0..s1.len() {
            let x = s1.as_bytes()[i] - 97;
            let y = s2.as_bytes()[i] - 97;
            let to_replace: u8 = base[x as usize].max(base[y as usize]);
            let replace_with: u8 = base[x as usize].min(base[y as usize]);

            for j in 0..26 {
                if base[j as usize] == to_replace {
                    base[j as usize] = replace_with;
                }
            }
        }
        for i in 0..base_str.len() {
            let id = base_str.as_bytes()[i] - 97;
            ret.push(base[id as usize]);
        }

        String::from_utf8(ret).unwrap()
    }

    pub fn smallest_equivalent_string_undone(s1: String, s2: String, base_str: String) -> String {
        let mut mp: HashMap<u8, Vec<u8>> = HashMap::new();
        let len = s1.len();

        for i in 0..len {
            let x = s1.as_bytes()[i];
            let y = s2.as_bytes()[i];
            // to create key: vec
            if mp.contains_key(&x) || mp.contains_key(&y) {
                // let vec = mp.get(&x).unwrap();
                todo!();
            }
        }

        for (_, v) in mp.iter_mut() {
            v.sort();
        }

        let ret_len = base_str.len();
        let mut ret: Vec<u8> = Vec::with_capacity(ret_len);
        for i in 0..ret_len {
            let c = base_str.as_bytes()[i];
            ret.push(mp[&c][0]);
        }

        String::from_utf8(ret).unwrap()
    }
}

#[cfg(test)]
mod tests {

    use super::Solution;

    #[test]
    fn utf() {
        let ch: char = 'a';
        let mut bytes: [u8; 1] = [0; 1];
        ch.encode_utf8(&mut bytes);
        println!("{:?}", bytes); // [97]
    }

    #[test]
    fn test() {
        let a = String::from("parker");
        let b = String::from("morris");
        let z = String::from("parser");
        println!("{}", Solution::smallest_equivalent_string(a, b, z));
    }
}
