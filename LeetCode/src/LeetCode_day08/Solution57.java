package LeetCode_day08;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {

    /**
     * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     *
     * 示例 1:
     * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出: [[1,5],[6,9]]
     *
     * 示例 2:
     * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出: [[1,2],[3,10],[12,16]]
     * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
     */

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

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval==null) return intervals;
        List<Interval> resIntervals=new ArrayList<>();
        //1 先找到在新区间左边且与新区间无交集的，直接插入结果集
        int i=0;
        while (i<intervals.size()&&intervals.get(i).end<newInterval.start){
            resIntervals.add(intervals.get(i));
            i++;
        }
        //2 处理与新区间有交集的区间
        while (i<intervals.size()&&intervals.get(i).start<=newInterval.end){
            newInterval.start=Math.min(intervals.get(i).start,newInterval.start);
            newInterval.end=Math.max(intervals.get(i).end,newInterval.end);
            i++;
        }
        resIntervals.add(newInterval);
        //3 处理新区间右边且与新区间无交集的，直接插入结果集
        while (i<intervals.size()){
            resIntervals.add(intervals.get(i));
            i++;
        }
        return resIntervals;
    }

    @Test
    public void test(){
        List<Interval> intervals=new ArrayList<>();
        //[1,2],[3,5],[6,7],[8,10],[12,16]
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));
        //System.out.println(intervals.toString());
        System.out.println(insert(intervals,new Interval(4,8)).toString());
    }

}
