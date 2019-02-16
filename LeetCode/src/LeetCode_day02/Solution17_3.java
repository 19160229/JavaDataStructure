package LeetCode_day02;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution17_3 {

    //求组合问题，从m个元素中取n个元素的组合，不考虑重复问题

    @Test
    public void test(){
        System.out.println(comb("12345",3).toString());
    }

    public List<String> comb(String str,int n){
        List<String> resList=new LinkedList<>();
        if (str==null||str.length()==0){
            return resList;
        }
        getComb(resList,str.toCharArray(),new char[n],0,0);
        return resList;
    }

    /**
     * @param resList 存放结果集
     * @param sIndex 在source中的索引
     * @param tIndex 在target中的索引
     */
    public void getComb(List<String> resList,char[] source,char[] target,int sIndex,int tIndex){
        //当target中的索引到最后一个时，说明获得了一个组合
        if (tIndex==target.length){
            resList.add(String.valueOf(target));
        }else {
            //当前位置可以插入的元素为：从当前sIndex到m-n
            //例如对1 2 3 4 5取3个元素组合，第一个位置只能有1 2 3三种选择，第二个位置可以取到源数组的倒数
            // 第二个位置
            for (int i=sIndex;i<=source.length-target.length+tIndex;i++){
                target[tIndex]=source[i];
                //确定好当前位置的选择后，
                //求解下一个位置tIndex+1的值，可以从此时的源数组索引i往后选择。
                getComb(resList,source,target,i+1,tIndex+1);
            }
        }
    }

}
