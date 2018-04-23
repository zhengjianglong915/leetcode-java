package cn.zhengjianglong.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author: zhengjianglong
 * @create: 2018-04-23 11:24
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        if (null == nums || nums.length < 3) {
            return resultList;
        }

        // 排序
        quickSort(nums, 0, nums.length - 1); // 或者使用  Arrays.sort(nums);

        // 两边夹逼
        int last = nums.length - 1;
        for (int i = 0; i <= last - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            find(nums, i + 1, last, nums[i], resultList); // 其实有点类似转为 2sum思路。
        }

        return resultList;
    }

    /**
     * 寻找两个数与num[i]的和为0
     *
     * @param nums
     * @param begin
     * @param end
     * @param target
     * @param resultList
     */
    private void find(int[] nums, int begin, int end, int target, List<List<Integer>> resultList) {
        int l = begin, r = end;
        while (l < r) {
            if (nums[l] + nums[r] + target == 0) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(target);
                ans.add(nums[l]);
                ans.add(nums[r]);
                resultList.add(ans); //放入结果集中
                while (l < r && nums[l] == nums[l + 1]) {
                    l++;
                }
                while (l < r && nums[r] == nums[r - 1]) {
                    r--;
                }
                l++;
                r--;
            } else if (nums[l] + nums[r] + target < 0) {
                l++;
            } else {
                r--;
            }
        }
    }

    // 快速排序
    private void quickSort(int[] array, int low, int high) {
        if (high < low) {
            return;
        }
        int lt = low, gt = high, i = low + 1;
        int val = array[low];
        while (i <= gt) {
            if (array[i] < val) {
                swap(array, i++, lt++);
            } else if (array[i] > val) {
                swap(array, i, gt--);
            } else {
                i++;
            }
        }
        array[i - 1] = val;
        quickSort(array, low, lt - 1);
        quickSort(array, gt + 1, high);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[] {-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(array);
        for (List<Integer> list : result) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
