package LeetCode_day09;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution77 {

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     *
     * 示例:
     * 输入: n = 4, k = 2
     * 输出:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     */

    @Test
    public void test(){
        System.out.println(combine(4,2).toString());
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists=new ArrayList<>();
        if (n<k) return lists;
        getCombine(n,new Integer[k],lists,0,0);
        return lists;
    }

    private void getCombine(int n,Integer[] target,List<List<Integer>> lists,int sIndex,int tIndex){
        int k=target.length;
        if (tIndex==k) {
            lists.add(new ArrayList<>(Arrays.asList(target)));
        }else {
            for (int i=sIndex;i<=n-k+tIndex;i++){
                target[tIndex]=i+1;
                getCombine(n,target,lists,i+1,tIndex+1);
            }
        }
    }

}
