package com.jiancai.algorithm.sort;

/**
 * 插入排序
 * 1. 将元素插入到已经有序序列的正确位置
 * 2. 将插入影响的元素进行移动
 * 特征：
 * 插入排序的时间复杂度依赖于待排序序列的已经有序或是接近有序的程度
 */
public class Insertion extends Sorting {

  public void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      // 将a[i]插入到a[i-1], a[i-2], a[i-3]...中
      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
    }
  }
}
