package com.jiancai.algorithm;

import com.jiancai.algorithm.sort.Selection;
import com.jiancai.algorithm.sort.Sorting;

public class SortExplore {

  public static void main(String[] args) {

    Sorting sorting = new Selection();
    Integer[] array = {1,3,4,2,6,9,10,8,7,5};
    sorting.sort(array);
    sorting.show(array);
  }
}
