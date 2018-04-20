package cn.zhengjianglong.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ﻿Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1,
 * 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 *
 * @author: zhengjianglong
 * @create: 2018-04-20 14:15
 */
public class LongestConsecutive {
    /**
     * 解法一：首先将所有的值都存放到set中，每次遍历的时候看连续值是否存在
     * 复杂度 O(n)
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) set.add(num);

        for (int num : nums) {
            if (set.remove(num)) { // 判断是否存在，并且删除
                int pre = num - 1, next = num + 1;
                while (set.remove(pre)) --pre;  // 往前删除
                while (set.remove(next)) ++next; // 往后删除
                res = Math.max(res, next - pre - 1);
            }
        }
        return res;
    }

    /**
     * 解法二：最长序列， 采用动态规划方式
     *
     * @param nums
     *
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        // 某个值附近有连续的几个数字
        Map<Integer, Integer> map = new HashMap<>();
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) continue;  // 已经存在了
            // 左边数连续大小
            int left = map.containsKey(nums[i] - 1)? map.get(nums[i] - 1) : 0;
            // 右边的数连续的大小
            int right = map.containsKey(nums[i] + 1)? map.get(nums[i] + 1) : 0;
            int sum = left + right + 1;

            len = Math.max(len, sum);
            map.put(nums[i] - left, sum);
            map.put(nums[i] + right, sum);
        }
        return len;
    }

    public static void main(String[] args) {
        int[] array = new int[] {100, 4, 200,  1, 3, 2};
        int len = new LongestConsecutive().longestConsecutive(array);
        System.out.println(len);
    }
}
