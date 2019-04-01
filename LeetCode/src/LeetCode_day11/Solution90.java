package LeetCode_day11;

import org.junit.Test;

import java.util.*;

public class Solution90 {

    /**
     * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     *
     * 示例:
     * 输入: [1,2,2]
     * 输出:
     * [
     *   [2],
     *   [1],
     *   [1,2,2],
     *   [2,2],
     *   [1,2],
     *   []
     * ]
     */

    @Test
    public void test(){
        System.out.println(subsetsWithDup2(new int[]{1,2,2}).toString());
        System.out.println(subsetsWithDup(new int[]{1,2,2}).toString());
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(new ArrayList<>());
        Integer exist=null;
        int size=1;
        for (int i=0;i<nums.length;i++){
            if (exist==null||exist!=nums[i]){
                exist=nums[i];
                size=lists.size();
            }
            int newSize=lists.size();
            for (int j=newSize-size;j<newSize;j++){
                List<Integer> list=new ArrayList<>(lists.get(j));
                list.add(nums[i]);
                lists.add(list);
            }
        }
        return lists;
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums){
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(new ArrayList<>());
        for (int num : nums) {
            int size=lists.size();
            for (int i=0;i<size;i++){
                List<Integer> list=new ArrayList<>(lists.get(i));
                list.add(num);
                lists.add(list);
            }
        }
        Set<List<Integer>> set=new HashSet<>(lists);
        lists=new ArrayList<>(set);
        return lists;
    }

}
