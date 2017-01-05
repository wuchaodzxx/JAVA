package T002;

import java.util.ArrayList;

/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class T001_AddTwoNumbers {
	
	public static void main(String[] args) {
		ListNode L11 = new ListNode(2);
		ListNode L12 = new ListNode(4);
		ListNode L13 = new ListNode(3);
		
		ListNode L21 = new ListNode(5);
		ListNode L22 = new ListNode(6);
		ListNode L23 = new ListNode(4);
		
		L11.next=L12;
		L11.next.next=L13;
		
		L21.next=L22;
		L21.next.next=L23;
		
		ListNode L3=addTwoNumbers(L11,  L21);
		while(L3!=null){
			System.out.println(L3.val);
			L3=L3.next;
		}
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null)return (l1 == null)?l2:l1;
        int val = l1.val + l2.val;
        ListNode l3 = new ListNode(val%10);
        l3.next = addTwoNumbers(l1.next, l2.next);
        if(val > 9)l3.next = addTwoNumbers(new ListNode(1), l3.next);
        return l3;
    
	}
}
