#include <vector>

using namespace std;

bool threeConsecutiveOdds(vector<int> &arr)
{
    int odds = 0;
    for (auto i = 0; i < arr.size() && odds < 3; ++i)
        odds = arr[i] & 1 ? odds + 1 : 0;
    return odds == 3;
}