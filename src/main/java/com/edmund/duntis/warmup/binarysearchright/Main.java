package com.edmund.duntis.warmup.binarysearchright;

public class Main {

	public static void main(String[] args) {
		// 返回小于等于key的最右下标
		int[] nums = new int[] { 1, 2 };
		int target = 1;

		int idx1 = searchRight1(target, nums);
		int idx2 = searchRight2(target, nums);
		System.out.println(idx1);
		System.out.println(idx2);

	}

	public static int searchRight1(int target, int[] nums) {
		if (nums[0] > target) {
			return -1;
		}

		// 初始值
		int left = 0;
		int right = nums.length - 1;

		while (true) {
			if (left == right) {
				if (nums[left] <= target) {
					return left;
				} else {
					return -1;
				}
			}

			// 递推转移
			int mid = left + (right - left) / 2;
			if (nums[mid] <= target && nums[mid + 1] > target) { // 最终答案终止条件
				return mid;
			}
			// 递推
			if (nums[mid] == target) {
				left = mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			}
		}
	}

	public static int searchRight2(int target, int[] nums) {
		if (nums.length == 0 || nums[0] > target) {
			return -1;
		}
		return searchRightIdx(target, nums, 0, nums.length - 1); // 初始条件
	}

	public static int searchRightIdx(int target, int[] nums, int left, int right) {
		// 简单情况的处理
		if (left == right) {
			if (nums[left] <= target) {
				return left;
			} else {
				return -1;
			}
		}
		// 递推
		int mid = left + (right - left) / 2;
		if (nums[mid] <= target && nums[mid + 1] > target) { // 最终答案终止条件
			return mid;
		}
		if (nums[mid] == target) {
			return searchRightIdx(target, nums, mid, right);
		} else if (nums[mid] < target) {
			return searchRightIdx(target, nums, mid + 1, right);
		} else if (nums[mid] < target) {
			return searchRightIdx(target, nums, left, mid - 1);
		}
		return -1;
	}

}
