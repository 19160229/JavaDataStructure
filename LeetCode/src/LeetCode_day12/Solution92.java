package LeetCode_day12;

import Utils.DS.ListNode;
import Utils.DS.ListNodes;
import org.junit.Test;

public class Solution92 {

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     *
     * 示例:
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     */

    @Test
    public void test(){
        ListNode head = ListNodes.initListNodes(new int[]{1, 2, 3, 4, 5});
        ListNodes.print(reverseBetween(head,2,4));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return null;
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode pre=dummyHead;
        for(int i=0;i<m-1;i++){
            pre=pre.next;
        }
        ListNode cur=pre.next;
        for (int i=m;i<n;i++){
            ListNode p=cur.next;
            cur.next=p.next;
            p.next=pre.next;
            pre.next=p;
        }
        return dummyHead.next;
    }

}
