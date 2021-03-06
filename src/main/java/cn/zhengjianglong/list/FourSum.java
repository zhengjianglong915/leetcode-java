package cn.zhengjianglong.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * The solution set must not contain duplicate quadruplets.
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 *  [-1,  0, 0, 1],
 *  [-2, -1, 1, 2],
 *  [-2,  0, 0, 2]
 * ]
 * @author: zhengjianglong
 * @create: 2018-04-23 15:25
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 这边求三位数之和
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int lo = j + 1;
                int hi = nums.length - 1;
                while (lo < hi) { // 夹逼求两位数之和
                    // 四个数之和
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum < target) {
                        lo++;
                    } else if (sum > target) {
                        hi--;
                    } else { // 值相等
                        List<Integer> t = new ArrayList<Integer>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[lo]);
                        t.add(nums[hi]);
                        result.add(t);
                        lo++;
                        hi--;
                        while (lo < hi && nums[hi] == nums[hi + 1]) {
                            hi--;
                        }

                        while (lo < hi && nums[lo] == nums[lo - 1]) {
                            lo++;
                        }
                    }

                }
            }
        }

        return result;
    }
}
