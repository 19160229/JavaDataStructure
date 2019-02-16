package LeetCode_day04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用一次。
     *
     * 说明：
     *     所有数字（包括目标数）都是正整数。
     *     解集不能包含重复的组合。
     *
     * 示例 1:
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     *
     * 示例 2:
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 所求解集为:
     * [
     *   [1,2,2],
     *   [5]
     * ]
     */
    @Test
    public void test(){
        System.out.println(combinationSum2(new int[]{2,5,2,1,2},5).toString());
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resLists=new ArrayList<>();
        if (candidates.length==0) return resLists;
        List<Integer> res=new ArrayList<>();
        Arrays.sort(candidates);
        getCombinationSum(resLists,res,candidates,target,0);
        return resLists;
    }

    private void getCombinationSum(List<List<Integer>> resLists,List<Integer> res,
                                   int[] candidates,int target,int index){
        if (target==0) {
            resLists.add(res);
            return;
        }
        if (target<candidates[0]) return;
        Integer exist=null;
        for (int i=index;i<candidates.length&&candidates[i]<=target;i++){
            if (exist==null||candidates[i]!=exist) {
                exist=candidates[i];
                List<Integer> tmpRes = new ArrayList<>(res);
                tmpRes.add(candidates[i]);
                getCombinationSum(resLists, tmpRes, candidates, target - candidates[i], i + 1);
            }
        }
    }

}
