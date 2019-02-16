package LeetCode_day02;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution17 {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 示例:
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */

    //类似排列组合求解
    public List<String> letterCombinations(String digits) {
        List<String> resList=new LinkedList<>();
        if (digits==null||digits.length()==0) return resList;
        //"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        Map<Integer,String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        dfs(digits,resList,new StringBuilder(),map,0);
        return resList;
    }

    public void dfs(String digits,List<String> resList,StringBuilder stringBuilder,
                    Map<Integer,String> map,int index){
        if (index==digits.length()){
            resList.add(stringBuilder.toString());
        }else {
            int num=digits.charAt(index)-48;
            String str=map.get(num);
            for (int i=0;i<str.length();i++){
                stringBuilder.append(str.charAt(i));
                dfs(digits,resList,stringBuilder,map,index+1);
                stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
            }
        }
    }

    @Test
    public void test(){
        System.out.println(letterCombinations("23").toString());
    }

}
