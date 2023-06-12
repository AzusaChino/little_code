use anyhow::bail;
use clap::Parser;

#[derive(Parser)]
#[command(name = "LittleCode")]
#[command(author = "azusachino <azusachino@duck.com>")]
#[command(version = "0.1.0")]
#[command(about = "Convert hyphen to underline", long_about = None)]
struct Args {
    question: Option<String>,
}

fn main() -> anyhow::Result<()> {
    let args = Args::parse();
    match args.question {
        Some(q) => {
            println!("{}", q.replace('-', "_"));
            Ok(())
        }
        None => bail!("please input a question name"),
    }
}
