package LeetCode_day06;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution46 {

    /**
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * <p>
     * 示例:
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     */

    @Test
    public void test(){
        System.out.println(permute(new int[]{1,2,3}).toString());
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resLists = new ArrayList<>();
        dfs(resLists,nums,0);
        return resLists;
    }

    private void dfs(List<List<Integer>> resLists, int[] nums, int index) {
        if (index == nums.length) {
            resLists.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            dfs(resLists, nums, index + 1);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
