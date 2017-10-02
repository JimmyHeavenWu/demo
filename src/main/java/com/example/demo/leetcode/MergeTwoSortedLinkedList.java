package com.example.demo.leetcode;

/**
 * Created by Jimmy on 2017/9/4.
 */
public class MergeTwoSortedLinkedList {

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode result_head = new ListNode(-1);

        ListNode point = result_head;
        ListNode point1 = head1;
        ListNode point2 = head2;

        while(point1 != null || point2 != null){

            if(point1 == null){
                point.next = new ListNode(point2.data);
                point2 = point2.next;
                point = point.next;
            }else if(point2 == null){
                point.next = new ListNode(point1.data);
                point1 = point1.next;
                point = point.next;
            }else {
                if (point1.data < point2.data) {
                    point.next = new ListNode(point1.data);
                    point1 = point1.next;
                    point = point.next;
                } else if(point1.data > point2.data){
                    point.next = new ListNode(point2.data);
                    point2 = point2.next;
                    point = point.next;
                }else {
                    point.next = new ListNode(point1.data);
                    point.next.next = new ListNode(point2.data);
                    point1 = point1.next;
                    point2 = point2.next;
                    point = point.next.next;
                }
            }

        }

        return result_head.next;
    }

    public static void main(String[] args){
        MergeTwoSortedLinkedList util = new MergeTwoSortedLinkedList();

        int[] nums1 = {1,2,3,6,7,9};
        int[] nums2 = {4,5,8};
        ListNode head1 = ListNode.convert(nums1);
        ListNode head2 = ListNode.convert(nums2);

        ListNode merged = util.merge(head1,head2);
        merged.print();

    }


}
