package LeetCode_day01;

import org.junit.Test;

public class Solution14 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * <p>
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * <p>
     * 说明:
     * 所有输入只包含小写字母 a-z 。
     */

    public class TreeNode {
        TreeNode[] nextC = new TreeNode[26];
        Boolean isEnd = false;
        int size = 0;
    }

    public class keyTree {

        private TreeNode root;

        public keyTree(String[] strs) {
            root = new TreeNode();
            for (String s : strs) {
                insert(s);
            }
        }

        public void insert(String s) {
            TreeNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int k = s.charAt(i) - 'a';
                if (p.nextC[k] == null) {
                    p.nextC[k] = new TreeNode();
                    p.size++;
                }
                p = p.nextC[k];
            }
            p.isEnd=true;
        }

        public String searchLongestCommonPrefix() {
            StringBuilder stringBuilder = new StringBuilder();
            TreeNode p=root;
            while (p!=null){
                if (p.size==1&&!p.isEnd){
                    for (int i=0;i<26;i++){
                        if (p.nextC[i]!=null){
                            p=p.nextC[i];
                            char tmpC= (char) (i+'a');
                            stringBuilder.append(tmpC);
                            break;
                        }
                    }
                }else {
                    return stringBuilder.toString();
                }
            }
            return stringBuilder.toString();
        }
    }

    //键树(字典树)实现
    public String longestCommonPrefix(String[] strs) {
        if (strs==null||strs.length==0){
            return "";
        }
        keyTree tree=new keyTree(strs);
        return tree.searchLongestCommonPrefix();
    }

    @Test
    public void test(){
        String[] strs={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

}
