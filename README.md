# little-code

LeetCode Daily in 2023. Mainly using Rust.

## Note

`'a'` is 97 in ascii.

```rust
// convert char to u8
fn utf() {
    let ch: char = 'a';
    let mut bytes: [u8; 1] = [0; 1];
    ch.encode_utf8(&mut bytes);
    println!("{:?}", bytes); // [97]
}
```

How to operate hashmap in rust.

```rust
let mut mp: HashMap<String, Vec<i32>> = HashMap::new();
if mp.contains_key(&v) {
    mp.entry(v).and_modify(|vec| vec.push(v));
} else {
    mp.insert(v, vec![v]);
}
```
