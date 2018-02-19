package com.jiancai.algorithm.sort;

public abstract class Sorting {

  public abstract void sort(Comparable[] a);

  protected void merge(Comparable[] a, int lo, int mid, int hi) {
    // 将a[lo..mid] 和 a[mid..hi]进行merge
    // i和j是两个游标，比较游标指向的数据进
    int i = lo, j = mid + 1;
    Comparable[] aux = new Comparable[a.length];
    // 将a[lo..hi]复制到aux[lo..hi]
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }
    for (int k = lo; k <= hi; k++) {
      // 前半数组的游标过半，元素取值取后半数组
      if (i > mid) a[k] = aux[j++];
      // 后半数组的游标过数组长度，元素取值取前半数组
      else if (j > hi) a[k] = aux[i++];
      // 比较两个游标的大小
      else if (less(aux[j], aux[i])) a[k] = aux[j++];
      else a[k] = aux[i++];
    }
  }

  protected boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  protected void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public void show(Comparable[] a) {
    for (Comparable c : a) {
      System.out.print(c + " ");
    }
    System.out.println();
  }

  protected boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) return false;
    }
    return true;
  }
}
