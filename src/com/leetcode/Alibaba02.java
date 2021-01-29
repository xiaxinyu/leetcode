package com.leetcode;

import java.math.BigDecimal;

/**
 * 输入：一个有序数组array，一个整数n
 * 输出：如果n在array里，输出n的位置；如果n不在array中输出n可以插入的位置，插入后的数组仍然有序
 * 例如：
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class Alibaba02 {
    public static int findInsertIndex(int[] array, int start, int end, int target) {
        int mediaIndex = BigDecimal.valueOf(Math.floor((start + end) / 2)).intValue();

        int media = array[mediaIndex];
        if (media == target) {
            return mediaIndex;
        }

        if (target < media) {
            int floorIdx = mediaIndex - 1;
            if (floorIdx >= 0) {
                if (target >= array[floorIdx]) {
                    return floorIdx + 1;
                } else {
                    return findInsertIndex(array, start, media - 1, target);
                }
            } else {
                return 0;
            }
        } else {
            if ((media + 1) <= end) {
                int ceilIdx = mediaIndex + 1;
                if (target <= array[ceilIdx]) {
                    return ceilIdx;
                } else {
                    return findInsertIndex(array, media + 1, end, target);
                }
            } else {
                return end + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 6, 9, 10};
        System.out.println(findInsertIndex(array, 0, array.length - 1, 11));
        System.out.println(findInsertIndex(array, 0, array.length - 1, 5));
        System.out.println(findInsertIndex(array, 0, array.length - 1, 3));
        System.out.println(findInsertIndex(array, 0, array.length - 1, 0));
    }
}
