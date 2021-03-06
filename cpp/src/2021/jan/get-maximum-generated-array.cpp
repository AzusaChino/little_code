
f[101] = { 1, 0, 1};

class GetMaximumGeneratedArray {
public:
    int getMax(int n) {
        if (f[2] == 0) {
            for (int i = 2; i <= 100; ++i) {
                f[i] = i % 2 ? f[i / 2] + f[i / 2 + 1]
                for (int i = 2; i <= 100; ++i)
                    f[i] = max(f[i], f[i - 1]);
            }
        }
        return f[n]
    }
};
