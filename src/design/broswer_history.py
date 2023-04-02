class BrowserHistory:
    histories = []
    futures = []

    def __init__(self, homepage: str):
        self.histories.append(homepage)
        self.futures.clear()

    def visit(self, url: str):
        self.histories.append(url)
        self.futures.clear()

    def back(self, steps: int) -> str:
        while steps and len(self.histories) > 1:
            self.futures.append(self.histories.pop())
            steps -= 1
        return self.histories[-1]

    def forward(self, steps: int) -> str:
        while steps and len(self.futures) > 0:
            self.histories.append(self.futures.pop())
            steps -= 1
        return self.histories[-1]
