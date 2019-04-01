package LeetCode_day11;

import Utils.DS.ListNode;
import Utils.DS.ListNodes;
import org.junit.Test;

public class Solution83 {

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     *
     * 示例 1:
     * 输入: 1->1->2
     * 输出: 1->2
     *
     * 示例 2:
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     */

    @Test
    public void test(){
        ListNode head = ListNodes.initListNodes(new int[]{});
        ListNodes.print(deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode p=dummyHead.next,cur=dummyHead;
        Integer exist=null;
        while (p!=null){
            if (exist==null||exist!=p.val){
                exist=p.val;
                cur.next=p;
                cur=cur.next;
            }
            p=p.next;
        }
        if (cur.next != null) cur.next=null;
        return dummyHead.next;
    }

}
