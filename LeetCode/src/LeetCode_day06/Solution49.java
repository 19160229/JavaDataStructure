package LeetCode_day06;

import org.junit.Test;

import java.util.*;

public class Solution49 {

    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     *
     * 说明：
     *     所有输入均为小写字母。
     *     不考虑答案输出的顺序。
     */

    @Test
    public void test(){
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).toString());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //维护一个map<String,List<String>>其中键存放字符串的排序字符串(及字符串字符的字典排序),
        // 值存放对应的字符串
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String key=String.valueOf(chars);
            if (!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(str);
        }
        List<List<String>> lists=new ArrayList<>();
        for (String key : map.keySet()) {
            lists.add(map.get(key));
        }
        return lists;
    }

}
