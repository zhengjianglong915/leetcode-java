package cn.zhengjianglong.list;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
 * extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Example 1:
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 *
 * https://leetcode.com/problems/remove-element/description/
 *
 * @author: zhengjianglong
 * @create: 2018-04-24 12:48
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[n++] = nums[i];
            }
        }

        return n;
    }

    public static void main(String[] args) {
        int[] array = new int[] {3,2,2,3};

        RemoveElement rm = new RemoveElement();
        int result = rm.removeElement(array, 3);
        System.out.println(result);
    }
}
