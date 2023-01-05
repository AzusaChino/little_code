// simple main for no-use
fn main() {
    let args: Vec<String> = std::env::args().collect();
    // convert `-` to `_`
    let title = args.get(1).unwrap();
    println!("{}", title.replace("-", "_"));
}
