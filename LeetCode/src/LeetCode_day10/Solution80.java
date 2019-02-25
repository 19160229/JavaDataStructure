package LeetCode_day10;

import Utils.DS.ListNode;
import Utils.DS.ListNodes;
import org.junit.Test;

public class Solution80 {

    /**
     *
     */

    @Test
    public void test(){
        ListNode listNode = ListNodes.initListNodes(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode head = deleteDuplicates(listNode);
        ListNodes.print(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode preNode=dummyHead;
        ListNode q=dummyHead.next,p=q.next;
        int cnt=1;
        Integer exist=q.val;
        while(p!=null){
            if(exist!=p.val){
                if(cnt>1){
                    preNode.next=p;
                    q=p;
                    //p=p.next;
                }else{
                    preNode=preNode.next;
                    q=q.next;
                }
                exist=p.val;
                cnt=0;
            }
            cnt++;
            p=p.next;
        }
        if(cnt>1){
            preNode.next=null;
        }
        return dummyHead.next;
    }

}
