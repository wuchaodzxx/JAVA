package T023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MergeKSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
				ListNode[] lists = new ListNode[]{L1,L6};
				printListNode(mergeKLists(lists));
	}
	public static ListNode mergeKLists(ListNode[] lists) {
		List<Integer> list = new ArrayList<Integer>();
		if(lists.length==0) return null;
		if(lists.length==1) return lists[0];
		for(int i=0;i<lists.length;i++){
			ListNode node = lists[i];
			if(node==null) continue;
			while(node!=null){
				list.add(node.val);
				node=node.next;
			}
		}
		if(list.size()<=0) return null;
		Collections.sort(list);
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
