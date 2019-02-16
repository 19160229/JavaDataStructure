package LeetCode_day02;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution17_4 {

    //解决组合问题的重复问题

    @Test
    public void test(){
        System.out.println(comb("21223",3).toString());
    }

    public List<String> comb(String str,int n){
        List<String> resList=new LinkedList<>();
        if (str==null||str.length()==0){
            return resList;
        }
        //先排序
        char[] source=str.toCharArray();
        Arrays.sort(source);
        getComb(resList,source,new char[n],0,0);
        return resList;
    }

    private void getComb(List<String> resList, char[] source, char[] target, int sIndex, int tIndex){
        if (tIndex==target.length){
            resList.add(String.valueOf(target));
        }else {
            //exist用于存放前一个元素
            Character exist=null;
            for (int i=sIndex;i<=source.length-target.length+tIndex;i++){
                //当前位置不能放之前已经放过的元素
                //因为已经排过序，所以只要与前一个元素不同，就说明此元素没有在当前位置使用过
                if (exist==null||source[i]!=exist){
                    exist=source[i];
                    target[tIndex]=source[i];
                    getComb(resList,source,target,i+1,tIndex+1);
                }
            }
        }
    }

}
