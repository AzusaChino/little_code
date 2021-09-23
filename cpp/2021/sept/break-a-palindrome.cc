#include <vector>
#include <string>

using namespace std;

class Solution
{
public:
    string breakPalindrome(string palindrome)
    {
        size_t sz = palindrome.size();
        for (auto i = 0; i < sz / 2; ++i)
        {
            if (palindrome[i] != 'a')
            {
                palindrome[i] = 'a';
                return palindrome;
            }
        }
        palindrome[sz - 1] = 'b';
        return sz < 2 ? "" : palindrome;
    }
};