package T024;

import java.util.ArrayList;
import java.util.List;


public class SwapNodesInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode L1 = new ListNode(1);
		ListNode L2 = new ListNode(2);
		ListNode L3 = new ListNode(3);
		ListNode L4 = new ListNode(4);
		ListNode L5 = new ListNode(5);
		L1.next=L2;
		L2.next=L3;
		L3.next=L4;
		L4.next=L5;
		printListNode(swapPairs(L1));
	}

	 public static ListNode swapPairs(ListNode head) {
		 if(head==null || head.next==null) return head;
		 List<Integer> list = new ArrayList<Integer>();
		 ListNode node = head;
		 while(node!=null){
				list.add(node.val);
				node=node.next;
		 }
		 //交换顺序
		 for(int i=0;i<list.size();){
			 if(i+1<list.size()){
				 int b = list.get(i);
				 list.set(i, list.get(i+1));
				 list.set(i+1, b);
				 
			 }
			 i=i+2;
		 }
		 //重新构造ListNode
		 ListNode res;
		 ListNode r1;
		 res = new ListNode(list.get(0));
		 r1 = res;
		 for(int i=1;i<list.size();i++){
			 r1.next = new ListNode(list.get(i));
			 r1=r1.next;
			}

		 return res;
	    }
	public static void printListNode(ListNode list){
		while(list!=null){
			System.out.print(list.val+"->");
			list=list.next;
		}
	}
}
