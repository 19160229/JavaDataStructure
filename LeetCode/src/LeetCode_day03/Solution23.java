package LeetCode_day03;

import org.junit.Test;

public class Solution23 {

    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     *
     * 示例:
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     */

    /**
     * Definition for singly-linked list.
     */

    @Test
    public void test(){
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(5);

        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);


        ListNode l3=new ListNode(2);
        l3.next=new ListNode(6);

        ListNode res=mergeKLists(new ListNode[]{l1,l2,l3});
        while (res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }
        System.out.println();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0){
            return null;
        }
        return mergeLists(lists,0,lists.length-1);
    }

    public ListNode mergeLists(ListNode[] lists,int left,int right){
        if (left>right){
            return null;
        }
        if (left==right){
            return lists[left];
        }
        int mid=(left+right)/2;
        ListNode l1=mergeLists(lists,left,mid);
        ListNode l2=mergeLists(lists,mid+1,right);
        return mergeTwoLists(l1,l2);
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummyHead=new ListNode(0);
        ListNode p=dummyHead;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next=l1;
                p=p.next;
                l1=l1.next;
            }else{
                p.next=l2;
                p=p.next;
                l2=l2.next;
            }
        }
        if(l1==null){
            p.next=l2;
        }
        if(l2==null){
            p.next=l1;
        }
        return dummyHead.next;
    }
}
