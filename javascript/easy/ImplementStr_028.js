const strStr = function (haystack, needle) {
  let m = haystack.length, n = needle.length;
  if (!n) return 0;
  let lps = kmpProcess(needle);
  for (let i = 0, j = 0; i < m;) {
    if (haystack[i] === needle[j]) {
      i++
      j++
    }
    if (j === n) return i - j;
    if (i < m && haystack[i] !== needle[j]) {
      if (j) j = lps[j - 1];
      else i++;
    }

  }
  return -1;
};

const kmpProcess = function (needle) {
  let n = needle.length;
  let lps = new Array(n).fill(0);
  for (let i = 1, length = 0; i < n;) {
    if (needle[i] === needle[length]) {
      length++;
      lps[i] = length;
      i++;
    } else if (length) length = lps[length - 1];
    else {
      lps[i] = 0;
      i++;
    }
  }
  return lps;
}

console.log(strStr('hahaha', 'h2a'))
