package com.leetcode;

/**
 * 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class Tecent02 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(so.search(nums, target));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < nums[r]) {//右侧有序
            if (target > nums[mid] && target <= nums[r]) {//目标值在右侧
                return search(nums, mid + 1, r, target);
            } else {
                return search(nums, l, mid - 1, target);
            }
        } else {
            if (target < nums[mid] && target >= nums[l]) {
                return search(nums, l, mid - 1, target);
            } else {
                return search(nums, mid + 1, r, target);
            }
        }
    }
}
