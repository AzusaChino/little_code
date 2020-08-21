# little-code

这是一个学习leet code的仓库, 其中包含java, python和go, 兴起的时候还会尝试js&ts的implementation

## 一些规则(定理)

### 使用二分查找时

- when you want to find an specific target element you use lo <= hi.
- When you want to find an element which is not specific element you use lo <hi. 
- mid = lo + (hi - lo) / 2 rather than mid = (hi + lo) / 2 => 防止lo+hi 大于Integer.MAX_VALUE导致overflow

### 利用快慢指针, 找到ListNode的middle

```cpp
ListNode *p1 = head, *p2 = head;
while(p2 && p2->next){
     p1 = p1->next;
     p2 = p2->next->next;
}
```