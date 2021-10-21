#include <vector>
#include <map>

using namespace std;

namespace code
{
    class RandomizedSet
    {
    private:
        vector<int> data;
        map<int, int> hash;

    public:
        RandomizedSet()
        {
        }

        bool insert(int val)
        {
            if (hash.count(val))
            {
                return false;
            }
            hash[val] = data.size();
            data.push_back(val);
            return true;
        }

        bool remove(int val)
        {
            using std::swap;
            if (!hash.count(val))
            {
                return false;
            }
            swap(data[hash[val]], data[data.size() - 1]);
            data.pop_back();
            hash[data[hash[val]]] = hash[val];
            hash.erase(val);
            return true;
        }

        int getRandom()
        {
            return data[rand() % data.size()];
        }
    };
}
