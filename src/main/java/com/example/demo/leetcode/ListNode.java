package com.example.demo.leetcode;

/**
 * Created by Jimmy on 2017/9/4.
 */
public class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data){
        this.data = data;
    }

    public ListNode addToNext(int num){
        ListNode node = new ListNode(num);
        this.next = node;
        return node;
    }

    public static ListNode convert(int [] nums) {
        ListNode head = new ListNode(-1);
        ListNode point = head;
        for (int i = 0; i < nums.length; i++) {
            point.next = new ListNode(nums[i]);
            point = point.next;
        }
        return head.next;
    }


    public void print(){
        ListNode node = this;
        while(node != null){
            System.out.print(node.data + ",");
            node = node.next;
        }
    }
}
