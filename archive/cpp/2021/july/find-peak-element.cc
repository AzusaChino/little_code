#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    int findPeakElement1(const vector<int> &num) {
        return Helper(num, 0, num.size() - 1);
    }
    int Helper(const vector<int> &num, int low, int high) {
        if (low == high)
            return low;
        else {
            int mid1 = (low + high) / 2;
            int mid2 = mid1 + 1;
            if (num[mid1] > num[mid2])
                return Helper(num, low, mid1);
            else
                return Helper(num, mid2, high);
        }
    }
    int findPeakElement2(const vector<int> &num) {
        int low  = 0;
        int high = num.size() - 1;

        while (low < high) {
            int mid1 = (low + high) / 2;
            int mid2 = mid1 + 1;
            if (num[mid1] < num[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }
    int findPeakElement3(const vector<int> &num) {
        for (int i = 1; i < num.size(); i++) {
            if (num[i] < num[i - 1]) {  // <
                return i - 1;
            }
        }
        return num.size() - 1;
    }
};
