package LeetCode_day03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     *
     * 例如，给出 n = 3，生成结果为：
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     */

    @Test
    public void test(){
        System.out.println(generateParenthesis(3).toString());
    }

    public List<String> generateParenthesis(int n) {
        List<String> resList=new ArrayList<>();
        insertParenthesis(resList, "",0,0,n);
        return resList;
    }

    public void insertParenthesis(List<String> resList, String str,
                                  int open, int close, int max){
        if (str.length()==2*max){
            resList.add(str);
        }else {
            if (open<max){
                insertParenthesis(resList,str+"(",open+1,close,max);
            }
            if (close<open){
                insertParenthesis(resList,str+")",open,close+1,max);
            }
        }
    }

}
