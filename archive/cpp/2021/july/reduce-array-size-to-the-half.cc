#include <algorithm>
#include <map>
#include <vector>

using namespace std;

class Solution {
public:
    int minSetSize(vector<int>& arr) {
        map<int, int> mpp;
        for (int i = 0; i < arr.size(); i++) {
            mpp[arr[i]]++;
        }
        vector<int> ans;
        for (int i = 0; i < 100005; i++) {
            if (mpp[i] > 0) {
                ans.push_back(mpp[i]);
            }
        }
        int n     = arr.size();
        int c     = 0;
        int count = n;
        sort(ans.begin(), ans.end(), greater<int>());
        for (int i = 0; i < ans.size(); i++) {
            if (count <= n / 2) {
                break;
            }
            count -= ans[i];
            c++;
        }
        return c;
    }
};
