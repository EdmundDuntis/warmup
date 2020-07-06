package com.edmund.duntis.warmup.binarysearch;

public class Main {

	public static void main(String[] args) {
		int[] nums = { 2, 3, 4, 5, 7, 9 };
		int idx = binarySearch(nums, 4);
		System.out.println(idx);
		idx = binarySearch(nums, 7);
		System.out.println(idx);
		idx = binarySearch(nums, 6);
		System.out.println(idx);
		idx = binarySearch(nums, 1);
		System.out.println(idx);
		idx = binarySearch(nums, 10);
		System.out.println(idx);
	}

	public static int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		// 直接退出
		if (target > nums[right] || target < nums[left]) {
			return -1;
		}

		while (true) {
			// 终止条件
			if (left == right) {
				if (target == nums[left]) {
					return left;
				} else {
					return -1;
				}
			}

			// 递推
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) { // 终止条件
				return mid;
			} else if (target > nums[mid]) {
				left = mid + 1;
			} else if (target < nums[mid]) {
				right = mid - 1;
			}
		}
	}
}
