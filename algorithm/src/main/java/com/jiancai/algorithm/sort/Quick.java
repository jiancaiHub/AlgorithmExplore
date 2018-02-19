package com.jiancai.algorithm.sort;

/**
 * 快速排序（分治）
 * 与归并排序算法不同是切分的位置取决于数组的内容，关键在于切分的算法
 * 特点：
 * 1. 原地排序
 * 2. 时间复杂度为NlgN
 */
public class Quick extends Sorting {

  public void sort(Comparable[] a) {

  }

  private void sort(Comparable[] a, int lo, int hi){
    if (hi <= lo) return;
    int j = partition(a, lo, hi);
    sort(a, lo, j-1);
    sort(a, j+1, hi);
  }

  private int partition(Comparable[] a, int lo, int hi) {
    int i = lo, j = hi +1;
    Comparable v= a[lo];
    while (true){
      while (less(a[++i], v)) if (i == hi) break;
      while (less(v, a[--j])) if (j == lo) break;
      if (i >= j) break;
      exch(a, i, j);
    }
    exch(a, lo, j);
    return j;
  }
}
