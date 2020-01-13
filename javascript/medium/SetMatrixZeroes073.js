const setZeroes = function (matrix) {
    if (matrix.length === 0) return matrix;
    const m = matrix.length;
    const n = matrix[0].length;

    // 时间复杂度 O(m * n), 空间复杂度 O(1)
    let firstRow = false; // 第一行是否应该全部为0
    let firstCol = false; // 第一列是否应该全部为0

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            const item = matrix[i][j];
            if (item === 0) {
                if (i === 0) {
                    firstRow = true;
                }
                if (j === 0) {
                    firstCol = true;
                }
                matrix[0][j] = 0;
                matrix[i][0] = 0;
            }
        }
    }

    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            let item = matrix[i][j];
            if (matrix[0][j] === 0 || matrix[i][0] === 0) {
                item = 0;
            }
        }
    }
    // 最后处理第一行和第一列
    if (firstRow) {
        for (let i = 0; i < n; i++) {
            matrix[0][i] = 0;
        }
    }

    if (firstCol) {
        for (let i = 0; i < m; i++) {
            matrix[i][0] = 0;
        }
    }

    return matrix;
};

setZeroes(null)
