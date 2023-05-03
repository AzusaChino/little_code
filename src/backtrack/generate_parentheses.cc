#include <string>
#include <vector>
#include <iostream>

using namespace std;

void backtrack(int l, int r, string &track, vector<string> &ret)
{
    if (l < 0 || r < 0)
    {
        return;
    }
    if (l > r)
    {
        return;
    }
    if (l == 0 && r == 0)
    {
        ret.push_back(track);
        return;
    }
    track.push_back('(');
    backtrack(l - 1, r, track, ret);
    track.pop_back();

    track.push_back(')');
    backtrack(l, r - 1, track, ret);
    track.pop_back();
}

vector<string> generate_parentheses(int n)
{
    if (n <= 0)
    {
        return {};
    }
    vector<string> ret;
    string track;
    backtrack(n, n, track, ret);
    return ret;
}

int main(int argc, char const *argv[])
{
    auto v = generate_parentheses(3);
    for (auto s : v)
    {
        cout << s << endl;
    }
    return 0;
}
