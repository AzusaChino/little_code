#include <algorithm>
#include <string>

using namespace std;

class Solution
{
public:
    // 151. reverse words in a string
    string reverseWords(string s)
    {
        // reverse the whole sentence
        reverse(s.begin(), s.end());
        int l = 0, r = 0;
        int N = s.size(), last_index = 0;

        while (r < N)
        {
            // skip prefix blank space
            while (r < N && s[r] == ' ')
                r++;
            int cur_start_index = l;

            // save current word
            while (r < N && s[r] != ' ')
            {
                s[l++] = s[r++];
                last_index = l;
            }

            // reverse the current word
            reverse(s.begin() + cur_start_index, s.begin() + last_index);
            s[l++] = ' ';
        }
        // trim suffix blank space
        s.resize(last_index);
        return s;
    }
};
