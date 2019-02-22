package LeetCode_day09;

import org.junit.Test;

public class Solution76 {

    /**
     * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
     *
     * 示例：
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     *
     * 说明：
     *     如果 S 中不存这样的子串，则返回空字符串 ""。
     *     如果 S 中存在这样的子串，我们保证它是唯一的答案。
     */

    @Test
    public void test(){
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    public String minWindow(String s, String t) {
        //滑动窗口
        //letter数组存放t串中字符的出现次数,
        //因为Ascll码共有256个字符，所以可以代表所有字符
        int[] letter=new int[256];
        for (char c : t.toCharArray()) {
            letter[c]++;
        }
        String res="";
        int left=0,minLen= Integer.MAX_VALUE,cnt=0;
        for (int i=0;i<s.length();i++){
            //如果s[i]字符-->=0说明这个字符在t串中出现过，那么说明找到了一个字符，计数器++
            if ((--letter[s.charAt(i)])>=0) cnt++;
            //每找到一个字符计数器++，那么当找到的字符个数和t长度一样时，
            // 说明此时的串s[left...i]就是一个包含了t中所有字符的子串
            while (cnt==t.length()){
                int len=i-left+1;
                if (len<minLen) {
                    minLen=len;
                    res=s.substring(left,i+1);
                }
                //窗口左窗口向左移动
                //当前左窗口所代表的值++，即将此字符移出窗口，
                // 若此时letter数组中>0则说明此值在t串中存在，则说明移出了一个目标字符，计数器--
                if (++letter[s.charAt(left)]>0) cnt--;
                left++;
            }
        }
        return res;
    }

}
