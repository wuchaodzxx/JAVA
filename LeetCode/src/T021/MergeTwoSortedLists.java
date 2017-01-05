package T021;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLists {

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
		
		ListNode L6 = new ListNode(1);
		ListNode L7 = new ListNode(3);
		ListNode L8 = new ListNode(4);
		ListNode L9 = new ListNode(7);
		ListNode L10 = new ListNode(9);
		L6.next=L7;
		L7.next=L8;
		L8.next=L9;
		L9.next=L10;
		
		printListNode(mergeTwoLists( L1,  L6));
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode res;
		ListNode r;
		ListNode r1 = null;
		List<ListNode> list = new ArrayList<ListNode>();
		if(!(l1!=null && l2 !=null)){
			return l1==null?l2:l1;
		}
		while(l1!=null || l2 !=null){
			if(l1==null){
				r = new ListNode(l2.val);
				l2=l2.next;
			}else if(l2==null){
				r = new ListNode(l1.val);
				l1=l1.next;
			}else{
				if(l1.val<l2.val){
					r = new ListNode(l1.val);
					l1=l1.next;
				}else{
					r = new ListNode(l2.val);
					l2=l2.next;
				}
			}
			list.add(r);
		}
		res = list.get(0);
		r1 = res;
		for(int i=1;i<list.size();i++){
			r1.next = list.get(i);
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
