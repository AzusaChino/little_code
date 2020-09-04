vector<int> partitionLabels(string S) {
    vector<int> endIndexes(26, 0), results;
    for (int i = 0; i < S.size(); i++) {
        endIndexes[S[i] - 'a'] = i;
    }
    int end = -1, i = 0, start = 0;
    while (i < S.size()) {
        end = max(endIndexes[S[i] - 'a'], end);
        if (i == end) {
            results.push_back(i - start + 1);
            start = i + 1;
        }
        i++;
    }
    return results;
}