package com.example.demo.leetcode;

import java.util.Stack;

/**
 * Created by Jimmy on 2017/9/4.
 */
public class InvertListNode {


    public static ListNode invert(ListNode node){
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode point = node;
        while(point != null){
            ListNode n = point;
            n.next = null;
            stack.push(n);
            point = point.next;
        }
        ListNode head = new ListNode(-1);

        point = head;

        while(!stack.empty()){
            point.next = stack.pop();
            point = point.next;
        }
        return head.next;
    }


    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        ListNode node = ListNode.convert(nums);
//        node.print();
        invert(node).print();

    }

}
