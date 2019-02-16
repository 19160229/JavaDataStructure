package LeetCode_day01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     *
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length<3){
            return null;
        }
        List<Integer> v = new ArrayList<>();
        Arrays.sort(nums);
        int sum=-1;
        for (int i=0;i<nums.length-2;i++){
            if (nums[i]<=0){
                v.add(nums[i]);
                if (sum==0-nums[i]){
                    v.remove(0);
                    continue;
                }
                sum=0-nums[i];
                int leftIndex=i+1;
                int rightIndex=nums.length-1;
                int di=nums[leftIndex]-1;
                while (leftIndex<rightIndex){
                    if (nums[leftIndex]+nums[rightIndex]==sum){
                        if(di!=nums[leftIndex]){
                            v.add(nums[leftIndex]);
                            v.add(nums[rightIndex]);
                            res.add((List<Integer>) ((ArrayList<Integer>) v).clone());
                            di=nums[leftIndex];
                            v.remove(2);
                            v.remove(1);
                        }
                        leftIndex++;
                        rightIndex--;
                    }else if (nums[leftIndex]+nums[rightIndex]>sum){
                        rightIndex--;
                    }else {
                        leftIndex++;
                    }
                }
                v.remove(0);
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums={-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

}
