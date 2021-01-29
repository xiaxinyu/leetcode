package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组中重复的数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 */
public class Tecent01 {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            int index = num - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            } else {
                list.add(index + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arrays = {4, 3, 2, 7, 8, 2, 3, 1};
        for (int j = 0; j < arrays.length; j++) {
            System.out.print(arrays[j] + "\t");
        }

        System.out.println();

        List<Integer> index = findDuplicates(arrays);
        for (int i = 0; i < index.size(); i++) {
            System.out.print(index.get(i) + "\t");
        }

        System.out.println();

        for (int j = 0; j < arrays.length; j++) {
            System.out.print(arrays[j] + "\t");
        }
    }
}
