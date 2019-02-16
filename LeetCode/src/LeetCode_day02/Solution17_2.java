package LeetCode_day02;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution17_2 {

    //解决全排列的重复问题
    //1.使用HashSet来存放结果，因为Set是具有唯一性的，所以不存在重复情况
    //2.修改算法，如果元素在当前定位位置已经使用过，则不再交换至此位置
    //  例如：对"aab"求全排列，先定位第一个位置，先将a放在此位置，求剩下的[a,b]的全排列，如果按照之前的全排列
    //  应该紧接着将第二个a交换至当前定位的位置，此时会产生重复结果。因此我们这里不交换已经使用过的元素，跳过
    //  第二个a，将b交换至此位置

    @Test
    public void test(){
        System.out.println(allPermutation("aab").toString());//结果:[aab, aba, baa]
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
        if (start==chars.length-1){
            resList.add(String.valueOf(chars));
        }else {
            for (int i=start;i<chars.length;i++){
                //当前元素在start-end之间未出现时才交换至索引位置
                //因为每次交换结束之后会还原至初始状态，所以不能只判断当前元素与索引位置的元素是否相同
                //从start-end之间的元素都是之前被交换至过索引位置的元素，所以当前元素要在start-end之间都
                //没有出现过才能保证不重复
                if (!isExist(chars,start,i)){
                    swap(chars,start,i);
                    getAllPermutation(resList,chars,start+1);
                    swap(chars,i,start);
                }
            }
        }
    }

    public boolean isExist(char[] chars,int start,int end){
        for (int i=start;i<end;i++){
            if (chars[i]==chars[end]) return true;
        }
        return false;
    }

    public void swap(char[] chars,int i,int j){
        char tmp=chars[i];
        chars[i]=chars[j];
        chars[j]=tmp;
    }

}
