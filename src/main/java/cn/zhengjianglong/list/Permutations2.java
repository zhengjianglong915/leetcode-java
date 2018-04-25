package cn.zhengjianglong.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ﻿Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * Example:
 * Input: [1,1,2]
 * Output:
 * [
 *  [1,1,2],
 *  [1,2,1],
 *  [2,1,1]
 *  ]
 *  https://leetcode.com/problems/permutations-ii/description/
 * @author: zhengjianglong
 * @create: 2018-04-24 14:12
 */
public class Permutations2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == nums || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums); // 先排序
        permute(nums, 0, result);
        return result;
    }

    private void permute(int[] nums, int idx, List<List<Integer>> result) {
        if (idx >= nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
        }

        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i] == nums[idx] ) continue;

            swap(nums, idx, i);
            permute(nums, idx + 1, result);
            // 交换回来
            swap(nums, idx, i);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2};
        Permutations permutations = new Permutations();
        List<List<Integer>> result =  permutations.permute(array);
        for (List<Integer> list : result) {
            for (Integer val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
