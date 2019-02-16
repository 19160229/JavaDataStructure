package LeetCode_day02;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution17_1 {
    //求全排列，不考虑重复的问题
    //例如求"abc"的全排列，先将指针定位到第一个位置，将a,b,c分别放到这个位置，
    //如将b放到这个位置，则将指针定位到第二个位置，将剩下两个元素a，c分别放到这个位置
    //当定位到最后一个位置时，就得到了一个排列
    //最后要将交换还原

    //当有重复元素时会产生重复的排列情况
    //例如求"aab"的全排列，结果如下：
    //[aab, aba, aab, aba, baa, baa]
    @Test
    public void test(){
        System.out.println(allPermutation("aab").toString());
    }

    public List<String> allPermutation(String str) {
        List<String> resList = new LinkedList<>();
        if (str == null || str.length() == 0) {
            return resList;
        }
        getAllPermutation(resList, str.toCharArray(), 0);
        return resList;
    }

    public void getAllPermutation(List<String> resList, char[] chars, int start) {
        //定位到最后一个位置时，说明得到了一个排列
        if (start == chars.length - 1) {
            resList.add(String.valueOf(chars));
        } else {
            //将每一个可能的元素交换到定位的位置
            for (int i = start; i < chars.length; i++) {
                //先定位一个位置
                swap(chars, start, i);
                //定位下一个位置
                getAllPermutation(resList, chars, start + 1);
                //还原交换
                swap(chars, i, start);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

}
