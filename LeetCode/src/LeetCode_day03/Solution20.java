package LeetCode_day03;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution20 {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     *     左括号必须用相同类型的右括号闭合。
     *     左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     * 输入: "()"
     * 输出: true
     *
     * 示例 2:
     * 输入: "()[]{}"
     * 输出: true
     *
     * 示例 3:
     * 输入: "(]"
     * 输出: false
     *
     * 示例 4:
     * 输入: "([)]"
     * 输出: false
     *
     * 示例 5:
     * 输入: "{[]}"
     * 输出: true
     */

    @Test
    public void test(){
        System.out.println(isValid("([)]"));
    }

    public boolean isValid(String s) {
        if (s==null||s.length()==0) return true;
        if (s.length()%2==1) return false;
        Stack<Integer> stack=new Stack<>();
        Map<Character,Integer> map=new HashMap<>();
        map.put('(',-1);
        map.put('[',-2);
        map.put('{',-3);
        map.put('}',3);
        map.put(']',2);
        map.put(')',1);
        for (int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            Integer value=map.get(c);
            if (value<0){
                stack.push(value);
            }else {
                if (stack.empty()) return false;
                Integer tmp=stack.pop();
                if (tmp+value!=0){
                    return false;
                }
            }
        }
        return stack.empty();
    }

}
