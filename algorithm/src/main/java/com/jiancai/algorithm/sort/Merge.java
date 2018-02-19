package com.jiancai.algorithm.sort;

/**
 * 归并排序
 * 1. 将数组平分，进行merge
 * 2. 递归继续平分，知道数组大小为2
 * 特点：
 */
public class Merge extends Sorting {

  public void sort(Comparable[] a) {
    sort(a, 0, a.length);
  }

  private void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return;
    //
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid);
    sort(a, mid, hi);
    merge(a, lo, mid, hi);
  }
}
