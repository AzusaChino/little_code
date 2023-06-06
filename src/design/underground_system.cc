#include <string>
#include <unordered_map>

using namespace std;

class UndergroundSystem
{
public:
    UndergroundSystem()
    {
    }

    void checkIn(int id, string stationName, int t)
    {
        check_in_map_[id] = make_pair(stationName, t);
    }

    void checkOut(int id, string stationName, int t)
    {
        auto check_in_ = check_in_map_[id];
        int total_time = t - check_in_.second;
        auto key = check_in_.first + "_" + stationName;
        auto check_out_ = check_out_map_.find(key);
        if (check_out_ != check_out_map_.end())
        {
            check_out_->second.first += total_time;
            check_out_->second.second++;
        }
        else
        {
            check_out_map_[key] = make_pair(total_time, 1);
        }
    }

    double getAverageTime(string startStation, string endStation)
    {
        auto key = startStation + "_" + endStation;
        auto check_out_ = check_out_map_.find(key);
        if (check_out_ != check_out_map_.end())
        {
            return (double)check_out_->second.first / check_out_->second.second;
        }
        return 0.0;
    }

private:
    // id -> (stationName, t)
    unordered_map<int, pair<string, int>> check_in_map_;
    // (startStation + endStation) -> (total_time, count)
    unordered_map<string, pair<int, int>> check_out_map_;
};
