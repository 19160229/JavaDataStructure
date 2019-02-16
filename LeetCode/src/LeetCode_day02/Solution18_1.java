package LeetCode_day02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18_1 {

    //以头尾指针方式求四数之和
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return resList;
        }
        Arrays.sort(nums);
        Integer existI = null;
        for (int i = 0; i < nums.length - 3; i++) {
            if (existI == null || nums[i] != existI) {
                existI = nums[i];
                Integer existJ = null;
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (existJ == null || existJ != nums[j]) {
                        existJ = nums[j];
                        int left = j + 1;
                        int right = nums.length - 1;
                        while (left < right) {
                            int sum = nums[i] + nums[j] + nums[left] + nums[right];
                            if (sum == target) {
                                resList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                while (left < right && nums[left] == nums[left + 1]) left++;
                                while (left < right && nums[right] == nums[right - 1]) right--;
                                left++;
                                right--;
                            } else if (sum < target) {
                                while (left < right && nums[left] == nums[left + 1]) left++;
                                left++;
                            } else {
                                while (left < right && nums[right] == nums[right - 1]) right--;
                                right--;
                            }
                        }
                    }
                }
            }
        }
        return resList;
    }

    @Test
    public void test() {
        System.out.println(fourSum(new int[]{5,5,3,5,1,-5,1,-2}, 0).toString());
    }

}
