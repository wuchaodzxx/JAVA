package T025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ReverseNodesInKGroup {

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
		printListNode(L1);
		System.out.println("");
		printListNode(reverseKGroup(L1,2));
	}
	public static ListNode reverseKGroup(ListNode head, int k) {
		if(k==0) return head;
		if(head==null || head.next ==null) return head;
		List<Integer> list = new ArrayList<Integer>();//存放节点
		List<Integer> list2 = new ArrayList<Integer>();//存放排序后的节点
		ListNode node = head;
		while(node!=null){
			list.add(node.val);
			node = node.next;
		}
		for(int i=0;i<list.size();){
			if(i+k-1<list.size()){
				List<Integer> list3 = new ArrayList<Integer>();
				for(int j=i;j<=i+k-1;j++){
					list3.add(list.get(j));
				}
				Collections.reverse(list3);
				list2.addAll(list3);
				i=i+k;
			}else{
				
				list2.add(list.get(i));
				i++;
			}
		}
		
		//重新构造ListNode
		 ListNode res;
		 ListNode r1;
		 res = new ListNode(list2.get(0));
		 r1 = res;
		 for(int i=1;i<list2.size();i++){
			 r1.next = new ListNode(list2.get(i));
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
