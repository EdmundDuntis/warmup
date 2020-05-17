package com.edmund.duntis.warmup.leetcode.towsum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;

		int[] result = solution.twoSum(nums, target);

		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	/**
	 * 使用Hash表存储数字对应下标
	 * 逐个扫描数组，如果Hash表中有差值对应的数字，则满足条件，如果不满足则维护到Hash表中
	 */
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer,Integer> num2index=new HashMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++) {
    		if(num2index.containsKey(target-nums[i])) {
    			return new int[] {num2index.get(target-nums[i]),i};
    		}else {
    			num2index.put(nums[i], i);
    		}
    	}
    	return new int[2];
    }
}
