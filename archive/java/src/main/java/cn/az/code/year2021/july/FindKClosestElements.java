package cn.az.code.year2021.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author az
 * @since 2021-07-02
 */
public class FindKClosestElements {

    public List<Integer> _findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int len = arr.length;
        if (x < arr[0]) {
            Stream.iterate(0, i -> i++).limit(k).forEach(i -> list.add(arr[i]));
        } else if (x > arr[len - 1]) {
            Stream.iterate(len - k - 1, i -> i++).limit(k).forEach(i -> list.add(i));
        } else {
            // 首先找到最接近的
            // 其次左右循环，优先左边
        }
        return list;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());
    }

}

