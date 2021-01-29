package com.leetcode;

import java.util.List;

/**
 * 二分查找也称为折半查找，每次都能将查找区间减半，这种折半特性的算法时间复杂度为 O(logN)。
 */
public class Alibaba01 {
    public static int findIndex(int[] nums, int l, int r, int t) {
        int m = (l + r) / 2;
        int v = nums[m];

        if (v == t) {
            return m;
        }

        System.out.print("[l=" + l + ",r=" + r + ", m = " + m + "; v = " + v + "]\t ");
        if (t < v) {
            if (m <= 0) {
                return -1;
            } else {
                return findIndex(nums, l, m, t);
            }
        } else {
            if (m >= (nums.length - 1) || m == (r - 1)) {
                return -1;
            } else {
                return findIndex(nums, m, r, t);
            }
        }
    }

    public static void main(String[] args) {
        int[] arrays = {2, 3, 7, 9, 22, 42, 57, 78};
        for (int j = 0; j < arrays.length; j++) {
            System.out.print(arrays[j] + "\t");
        }

        System.out.println((1 + 0) / 2);
        System.out.println();

        int length = arrays.length;
        System.out.println("1->" + findIndex(arrays, 0, length, 1));
        System.out.println("4->" + findIndex(arrays, 0, length, 4));
        System.out.println("7->" + findIndex(arrays, 0, length, 7));
        System.out.println("57->" + findIndex(arrays, 0, length, 57));
        System.out.println("90->" + findIndex(arrays, 0, length, 90));
    }
}
