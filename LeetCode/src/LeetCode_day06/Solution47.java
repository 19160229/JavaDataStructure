package LeetCode_day06;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution47 {

    /**
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     * <p>
     * 示例:
     * 输入: [1,1,2]
     * 输出:
     * [
     * [1,1,2],
     * [1,2,1],
     * [2,1,1]
     * ]
     */

    @Test
    public void test() {
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resLists = new ArrayList<>();
        if (nums.length == 0) return resLists;
        getPermuteUnique(nums, resLists, 0);
        return resLists;
    }

    private void getPermuteUnique(int[] nums, List<List<Integer>> resLists, int index) {
        if (index == nums.length - 1) {
            resLists.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        for (int i = index; i < nums.length; i++) {
            if (!isExist(nums, index, i)) {
                swap(nums, index, i);
                getPermuteUnique(nums, resLists, index + 1);
                swap(nums, i, index);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private boolean isExist(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] == nums[end]) {
                return true;
            }
        }
        return false;
    }
}
