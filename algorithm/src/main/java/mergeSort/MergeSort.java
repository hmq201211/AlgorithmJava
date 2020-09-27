package mergeSort;

import java.util.Arrays;

public class MergeSort {
    private static Comparable[] aux;

    public static void sort(Comparable[] comps) {
        aux = new Comparable[comps.length];
        sort(comps, 0, comps.length - 1);
    }

    private static void sort(Comparable[] comps, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(comps, lo, mid);
        sort(comps, mid + 1, hi);
        merge(comps, lo, mid, hi);
    }

    private static void merge(Comparable[] comps, int lo, int mid, int hi) {
        int left = lo, right = mid + 1;
        if (hi + 1 - lo >= 0) System.arraycopy(comps, lo, aux, lo, hi + 1 - lo);
        for (int i = lo; i <= hi; i++) {
            if (left > mid)
                comps[i] = aux[right++];
            else if (right > hi)
                comps[i] = aux[left++];
            else if (aux[left].compareTo(aux[right]) < 0) {
                comps[i] = aux[left++];
            } else {
                comps[i] = aux[right++];
            }
        }
    }

    public static void main(String[] args) {
        final Integer[] test = {2,5,4,3,3};
        sort(test);
        System.out.println(Arrays.toString(test));
    }
}
