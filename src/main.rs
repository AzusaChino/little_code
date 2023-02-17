use anyhow::bail;
use clap::Parser;

#[derive(Parser)]
#[command(author, version, about, long_about=None)]
struct Args {
    #[arg(short, long)]
    question: Option<String>,
}

#[tokio::main]
async fn main() -> anyhow::Result<()> {
    let args = Args::parse();
    match args.question {
        Some(q) => {
            println!("{}", q.replace("-", "_"));
            Ok(())
        }
        None => bail!("please input a question name"),
    }
}
