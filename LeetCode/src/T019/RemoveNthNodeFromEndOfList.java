package T019;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		ListNode L1 = new ListNode(1);
		ListNode L2 = new ListNode(2);
		ListNode L3 = new ListNode(3);
		ListNode L4 = new ListNode(4);
		ListNode L5 = new ListNode(5);
		L1.next=L2;
		L2.next=L3;
		L3.next=L4;
		L4.next=L5;
		printListNode(removeNthFromEnd(L5,1));
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
	    if(n==0) return head; 
	    if(head.next ==null && n==1) return null;
		ListNode L = head ;
		List<Integer> list = new ArrayList<Integer>();
		while(L!=null){
			list.add(L.val);
			L=L.next;
		}
		int del = list.size()-n;
		list.remove(del);
		if(list.size()<=0) return null;
		if(list.size()==1){
			ListNode LL = new ListNode(list.get(0));
			return LL;
		}
		ListNode L2 = new ListNode(list.get(0));
		ListNode L3 = L2;
		for(int i=1;i<list.size();i++){
			ListNode L4 = new ListNode(list.get(i));
			L3.next = L4;
			L3 = L3 .next;
		}
		return L2;
	}
	public static void printListNode(ListNode list){
		while(list!=null){
			System.out.print(list.val+"->");
			list=list.next;
		}
	}
}
