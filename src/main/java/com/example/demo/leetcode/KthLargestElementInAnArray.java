package com.example.demo.leetcode;

/**
 * Created by wuj42 on 8/10/2017.
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    public int partition(int[] a, int lo, int hi) {
        int l = lo;
        int r = hi+1;
        int pivot = a[lo];

        while (true){
            while(l<hi && less(a[++l], a[lo]));
            while(r>lo && less(a[lo], a[--r]));
            if(l>=r) break;
            exch(a, l, r);
        }
        exch(a, lo, r);

        return r;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void print(int[] a){
        System.out.print("[");
        for(int i=0; i< a.length; i++) {
            System.out.print(a[i]);
            System.out.print(",");
        }
        System.out.println("]");
    }

    private boolean less(int v, int w) {
        return v < w;
    }

    public static void main(String [] args){
        int[] input = {1,3,4,5,1,5,5};
        print(input);
        KthLargestElementInAnArray kle = new KthLargestElementInAnArray();
        kle.findKthLargest(input, 2);
        print(input);
    }
}
