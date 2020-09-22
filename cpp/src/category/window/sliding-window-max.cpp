#include <deque>
#include <vector>

class MonotonicWindow {
private:
    deque<int> data;
public:
    void push(int n) {
        while (!data.empty() && data.back() < n) {
            data.pop_back();
        }
        data.push_back(n);
    }

    int max() {
        return data.front();
    }

    void pop(int n) {
        while (!data.empty() && data.back() == n) {
            data.pop_front();
        }
    }
};

class SlidingWindowMaximum {
public:
    vector<int> maximum(vector<int> &nums, int k) {
        MonotonicWindow window;
        vector<int> ret;
        for (int i = 0; i < nums.size(); ++i) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                ret.push_back(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        return ret;
    }
};