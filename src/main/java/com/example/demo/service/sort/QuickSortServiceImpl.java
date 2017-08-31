package com.example.demo.service.sort;

import org.springframework.stereotype.Service;

/**
 * Created by wuj42 on 7/7/2017.
 */
@Service
public class QuickSortServiceImpl implements SortService {

    private final String type = "quickSort";

    @Override
    public String getSortAlgorithmName() {
        return this.type;
    }

    @Override
    public int[] sortNumbers(int[] unsortedList) {

        partition(unsortedList, 0, unsortedList.length-1);

        return unsortedList;
    }

    public void partition(int[] a, int lo, int hi) {
        if (lo >= hi)
            return;
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

        partition(a, lo, r-1);
        partition(a, r+1, hi);
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }
}
