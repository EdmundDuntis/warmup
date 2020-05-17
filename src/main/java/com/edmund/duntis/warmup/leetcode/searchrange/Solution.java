package com.edmund.duntis.warmup.leetcode.searchrange;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;

		int[] result = solution.searchRange(nums, target);

		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	
	/**
	 * 先查找左边界
	 * 再从左边界开始查找右边界
	 */
	public int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };
		if (nums.length < 1) {
			return result;
		}
		if (target > nums[nums.length - 1] || target < nums[0]) {
			return result;
		}

		// 先找左边界
		int left = searchLeft(nums, target, 0, nums.length - 1);
		if (left == -1) {
			return result;
		}

		// 再找右边界，从左边界开始即可
		int right = searchRight(nums, target, left, nums.length - 1);
		return new int[] { left, right };

	}

	/**
	 * 递归查找左边界
	 */
	public int searchLeft(int[] nums, int target, int left, int right) {
		if (left == right) { // 出口条件
			if (target == nums[left]) { // 如果相等返回下标
				return left;
			}
			return -1; // 如果不等，没有找到，必须
		}

		int mid = left + (right - left) / 2; // 注意写法，左边界右边界统一处理
		if (target > nums[mid]) {
			return searchLeft(nums, target, mid + 1, right);
		}
		if (target < nums[mid]) {
			return searchLeft(nums, target, left, mid - 1);
		}
		if (target == nums[mid]) {
			return searchLeft(nums, target, left, mid);
		}

		return -1;
	}
	
	/**
	 * 递归查找右边界
	 */
	public int searchRight(int[] nums, int target, int left, int right) {
		if (left == right) { // 出口条件
			if (target == nums[right]) {
				return right; // 如果相等返回下标
			}
			return -1; // 如果不等，没有找到，必须
		}

		int mid = right - (right - left) / 2; // 注意写法，左边界右边界统一处理
		if (target > nums[mid]) {
			return searchRight(nums, target, mid + 1, right);
		}
		if (target < nums[mid]) {
			return searchRight(nums, target, left, mid - 1);
		}
		if (target == nums[mid]) {
			return searchRight(nums, target, mid, right);
		}

		return -1;
	}
}
