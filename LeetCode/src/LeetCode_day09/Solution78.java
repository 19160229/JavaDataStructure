package LeetCode_day09;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution78 {

    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     *
     * 示例:
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */

    @Test
    public void test(){
//        System.out.println(subsets(new int[]{1,2,3}).toString());
//        List<List<Integer>> lists=new ArrayList<>();
//        getComb(new int[]{1,2,3},new Integer[2],0,0,lists);
//        System.out.println(lists);
        System.out.println(subsets2(new int[]{1,2,3}).toString());
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(new ArrayList<>());
        for (int num : nums) {
            int size=lists.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list=new ArrayList<>(lists.get(i));
                list.add(num);
                lists.add(list);
            }
        }
        return lists;
    }

    public List<List<Integer>> subsets2(int[] nums){
        List<List<Integer>> lists=new ArrayList<>();
        for (int i=0;i<=nums.length;i++){
            getComb(nums,new Integer[i],0,0,lists);
        }
        return lists;
    }

    private void getComb(int[] source,Integer[] target,int sIndex,int tIndex,List<List<Integer>> lists){
        int m=source.length;
        int n=target.length;
        if (tIndex==n){
            lists.add(new ArrayList<>(Arrays.asList(target)));
        }else {
            for (int i=sIndex;i<=m-n+tIndex;i++){
                target[tIndex]=source[i];
                getComb(source,target,i+1,tIndex+1,lists);
            }
        }
    }

}
