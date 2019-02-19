package LeetCode_day07;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution56 {

    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     * <p>
     * 示例 1:
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * <p>
     * 示例 2:
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */

//    *
//     * Definition for an interval.
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> lists = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return lists;
        //对intervals按start排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                Integer i1 = o1.start;
                Integer i2 = o2.start;
                return i1.compareTo(i2);
            }
        });
        lists.add(intervals.get(0));
        for (int i=1;i<intervals.size();i++){
            Interval last=lists.get(lists.size()-1);
            Interval tmp=intervals.get(i);
            if (tmp.start>last.end){
                lists.add(tmp);
            }else {
                last.end=Math.max(tmp.end,last.end);
            }
        }
        return lists;
    }

    @Test
    public void test(){
        List<Interval> intervals=new ArrayList<>();
        //[1,3],[2,6],[8,10],[15,18]
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(15,18));
        intervals.add(new Interval(8,10));
        //System.out.println(intervals.toString());
        System.out.println(merge(intervals).toString());
    }

}
