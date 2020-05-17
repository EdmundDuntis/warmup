package com.edmund.duntis.warmup;

public class Main {

	public static int bs(int[] nums, int target) {

		int begin = 0;
		int end = nums.length - 1;
		if (target < nums[0] || target > nums[end]) {
			return -1;
		}

		while (begin <= end) {
			int mid = begin + (end - begin) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (target > nums[mid]) {
				begin = mid + 1;
			} else if (target < nums[mid]) {
				end = mid - 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int index = bs(nums, 4);
		System.out.println(index);

	}


}
