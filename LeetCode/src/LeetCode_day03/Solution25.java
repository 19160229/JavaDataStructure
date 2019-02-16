package LeetCode_day03;

import org.junit.Test;

public class Solution25 {

    /**
     * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
     *
     * 示例 :
     * 给定这个链表：1->2->3->4->5
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     * 说明 :
     *     你的算法只能使用常数的额外空间。
     *     你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void test(){
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(3);
        l1.next.next.next=new ListNode(4);
        l1.next.next.next.next=new ListNode(5);

        ListNode res=reverseKGroup(l1,3);
        while (res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }
        System.out.println();

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null) return null;
        if (k==1) return head;
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode left=dummyHead;
        ListNode right=dummyHead;
        int cnt=0;
        boolean isReverse=false;
        while (right!=null||isReverse){
            if (isReverse){
                ListNode p=left.next.next;
                ListNode q=left.next;
                for (int i=1;i<k;i++){
                    q.next=p.next;
                    p.next=left.next;
                    left.next=p;
                    p=q.next;
                }
                isReverse=false;
                left=q;
            }
            if (right==null) break;
            cnt++;
            right=right.next;
            if (cnt>k&&cnt%k==1) isReverse=true;
        }
        return dummyHead.next;
    }

}
