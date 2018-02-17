package com.jiancai.algorithm.sort;

/**
 * 选择排序
 * 1. 找到数组中最小的元素
 * 2. 将它和数组的第一个元素交换位置
 * 3. 再剩下的元素中找到最小的元素
 * 4. 将它与数组的第二个元素交换位置
 * 5. 直到将整个数组排序
 * 特点：
 * 1. 运行时间和输入无关
 * 2. 数据移动是最小的，交换次数和数组大小是线性关系
 */
public class Selection extends Sorting {

  public void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) {
        if (less(a[j], a[min])) {
          exch(a, j, min);
          min = j;
        }
      }
    }
  }
}
