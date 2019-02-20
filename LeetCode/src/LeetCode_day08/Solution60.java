package LeetCode_day08;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution60 {

    /**
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * <p>
     * 给定 n 和 k，返回第 k 个排列。
     * 说明：
     * 给定 n 的范围是 [1, 9]。
     * 给定 k 的范围是[1,  n!]。
     * <p>
     * 示例 1:
     * 输入: n = 3, k = 3
     * 输出: "213"
     * <p>
     * 示例 2:
     * 输入: n = 4, k = 9
     * 输出: "2314"
     */

    public String getPermutation(int n, int k) {
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(i + 1);
        }
        Map<Integer, Integer> facMap = new HashMap<>();
        int fac = 1;
        facMap.put(0, fac);
        for (int i = 1; i < n; i++) {
            fac = i * fac;
            facMap.put(i, fac);
        }
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = n; i >= 1; i--) {
            int tmp = facMap.get(i - 1);
            int index = k / tmp;
            k = k % tmp;
            sb.append(lists.get(index));
            lists.remove(index);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(getPermutation(4, 9));
    }

}
