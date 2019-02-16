package LeetCode_day01;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串的长度。
     *
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     *
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

    //动态规划
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")){
            return 0;
        }
        Map<Character,Integer> map=new HashMap<>();
        char[] sChar=s.toCharArray();
        int[] len=new int[s.length()];
        int maxLen=1;
        //第一个字符特殊处理
        len[0]=1;
        map.put(sChar[0],0);
        for(int i=1;i<len.length;i++){
            Integer lastIndexOfCharacter=map.get(sChar[i]);
            if (lastIndexOfCharacter==null){
                len[i]=len[i-1]+1;
            }else{
                //取出前一个字符最长不重复子串开始位置
                int pos=i-len[i-1];
                //判断重复字符的前一个位置与前一个字符最长子串的开始位置之间的关系
                //重复字符的上一个位置在前一个字符最长子串开始位置之后
                if (lastIndexOfCharacter>=pos){
                    len[i]=i-lastIndexOfCharacter;
                }else{
                    len[i]=len[i-1]+1;
                }
            }
            map.put(sChar[i],i);
            if(maxLen<len[i]){
                maxLen=len[i];
            }
        }
        return maxLen;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
