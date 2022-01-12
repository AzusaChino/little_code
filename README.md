# little-code

这里是学习`LeetCode`的仓库，由于工作比较忙，现在每天的目标就是完成[Daily](leetcode/README.md)。

主要使用语言：Java，Go，C++，Python

## 一些规则

### 二分查找

- when you want to find an specific target element you use lo <= hi.
- When you want to find an element which is not specific element you use lo <hi.
- mid = lo + (hi - lo) / 2 rather than mid = (hi + lo) / 2 => 防止 lo+hi 大于 Integer.MAX_VALUE 导致 overflow

### 快慢指针找中点

```cpp
ListNode *p1 = head, *p2 = head;
while(p2 && p2->next){
     p1 = p1->next;
     p2 = p2->next->next;
}
```

## Problem Fix

### Please update includePath

After long time searching, figured out the problem was `configurationProvider` wrong. Remove this or use `ms-vscode.cpp-tools` instead.
