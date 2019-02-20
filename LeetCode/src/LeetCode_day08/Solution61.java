package LeetCode_day08;

import Utils.DS.ListNode;
import Utils.DS.ListNodes;
import org.junit.Test;

public class Solution61 {

    /**
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 示例 1:
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     * <p>
     * 示例 2:
     * 输入: 0->1->2->NULL, k = 4
     * 输出: 2->0->1->NULL
     * 解释:
     * 向右旋转 1 步: 2->0->1->NULL
     * 向右旋转 2 步: 1->2->0->NULL
     * 向右旋转 3 步: 0->1->2->NULL
     * 向右旋转 4 步: 2->0->1->NULL
     */

    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        //遍历链表，求链表的长度
        int len=0;
        ListNode p=dummyHead.next;
        while (p!=null){
            len++;
            p=p.next;
        }
        if (len<=1) return dummyHead.next;
        k=k%len;
        if (k==0) return dummyHead.next;
        ListNode rear=dummyHead.next,preP=dummyHead;
        p=dummyHead.next;
        for (int i=0;i<k-1;i++) rear=rear.next;
        //将rear指向最后一个节点，则p指向了倒数第k个节点
        while (rear.next!=null){
            rear=rear.next;
            p=p.next;
            preP=preP.next;
        }
        preP.next= null;
        rear.next=dummyHead.next;
        dummyHead.next=p;
        return dummyHead.next;
    }

    @Test
    public void test(){
        //1->2->3->4->5->NULL
        ListNode head=ListNodes.initListNodes(new int[]{1,2,3,4,5});
        ListNode p=rotateRight(head,2);
        ListNodes.print(p);
    }

}
