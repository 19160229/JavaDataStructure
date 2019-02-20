package Utils.DS;

public class ListNodes {

    //private ListNode root;

    public static ListNode initListNodes(int[] nums){
        ListNode root =new ListNode(nums[0]);
        ListNode p=root;
        for (int i=1;i<nums.length;i++){
            ListNode q=new ListNode(nums[i]);
            p.next=q;
            p=p.next;
        }
        return root;
    }

    public static void print(ListNode root){
        ListNode p=root;
        while (p!=null){
            if (p.next!=null)   System.out.print(p.val+"->");
            else System.out.println(p.val);
            p=p.next;
        }
    }

}
