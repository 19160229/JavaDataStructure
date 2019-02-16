package LeetCode_day04;

import org.junit.Test;

public class Solution43 {

    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，
     * 它们的乘积也表示为字符串形式。
     *
     * 示例 1:
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     *
     * 示例 2:
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     *
     * 说明：
     *     num1 和 num2 的长度小于110。
     *     num1 和 num2 只包含数字 0-9。
     *     num1 和 num2 均不以零开头，除非是数字 0 本身。
     *     不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String sum="";
        for(int i=num1.length()-1;i>=0;i--){
            int carry=0;
            String tmp="";
            //末尾补零
            for (int k=num1.length()-1;k>i;k--)
                tmp=tmp+"0";
            for (int j=num2.length()-1;j>=0;j--){
                int tmpSum= (num1.charAt(i)-'0')*(num2.charAt(j)-'0')+carry;
                int tmpRes=tmpSum%10;
                tmp = tmpRes + tmp;
                carry=tmpSum/10;
            }
            if (carry!=0) tmp=carry+tmp;
            sum=add(sum,tmp);
        }
        return sum;
    }

    private String add(String num1,String num2){
        String sum="";
        int i=num1.length()-1;
        int j=num2.length()-1;
        int carry=0;
        while (i>=0&&j>=0){
            int tmpSum=(num1.charAt(i)-'0')+(num2.charAt(j)-'0')+carry;
            int tmpRes=tmpSum%10;
            carry=tmpSum/10;
            sum=tmpRes+sum;
            --i;
            --j;
        }
        if (i<0&&j<0){
            if (carry!=0) sum=carry+sum;
            return sum;
        }
        if (i<0){
            while (j>=0){
               int tmpSum=(num2.charAt(j)-'0')+carry;
               int tmpRes=tmpSum%10;
               carry=tmpSum/10;
               sum=tmpRes+sum;
               --j;
            }
            if (carry!=0) sum=carry+sum;
            return sum;
        }else {
            while (i>=0){
                int tmpSum=(num1.charAt(i)-'0')+carry;
                int tmpRes=tmpSum%10;
                carry=tmpSum/10;
                sum=tmpRes+sum;
                --i;
            }
            if (carry!=0) sum=carry+sum;
            return sum;
        }
    }

    @Test
    public void test(){
        System.out.println(multiply("123","456"));
    }

}
