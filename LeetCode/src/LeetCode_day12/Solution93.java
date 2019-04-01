package LeetCode_day12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution93 {

    /**
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     *
     * 示例:
     * 输入: "25525511135"
     * 输出: ["255.255.11.135", "255.255.111.35"]
     */

    @Test
    public void test(){
        System.out.println(restoreIpAddresses("010010").toString());
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<>();
        getIpAddresses(s,res,new String[4],0);
        return res;
    }

    private void getIpAddresses(String s, List<String> res, String[] strs, int index){
        if (index>3) return;
        if ((s.length()>((4-index)*3))||((s.length()==(4-index)*3))&&(s.charAt(0)>'2')) return;
        if (index==3){
            if (Integer.parseInt(s)<=255){
                if (s.length()>1&&s.charAt(0)=='0') return;
                strs[3]=s;
                StringBuilder sb=new StringBuilder();
                for (int i=0;i<4;i++){
                    if (i!=3) sb.append(strs[i]).append(".");
                    else sb.append(strs[i]);
                }
                res.add(sb.toString());
            }
            return;
        }
        for(int i=0;i<3&&i<=(s.length()-(4-index));i++){
            String subStr=s.substring(0,i+1);
            int num=Integer.parseInt(subStr);
            if (num<=255){
                if (subStr.length()>1&&subStr.charAt(0)=='0') continue;
                strs[index]=subStr;
                getIpAddresses(s.substring(i+1),res,strs,index+1);
            }
        }
    }

}
