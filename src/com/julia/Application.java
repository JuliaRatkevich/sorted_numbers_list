package com.julia;

import com.julia.SortedNumbersList;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        int[] listArray = new int[]{19, 8, -6, 34, 8};

        SortedNumbersList list = new SortedNumbersList(listArray);
        list.display();
        boolean deleted = list.remove(8);
        System.out.println("8 was deleted: " + deleted);
        list.display();
        boolean contains34 = list.contains(34);
        System.out.println(contains34);
        list.removeById(0);
        list.display();

        SortedNumbersList list2 = new SortedNumbersList(new int[]{2, -5, -6, -6, 2, 2, 2, 2});
        list2.display();
        list2.removeRepeated();
        list2.display();
//        SortedNumbersList list3 = list.intersection(list2);// {-6}
        SortedNumbersList list4 = list.union(list2);// {-6, -5, 2, 8, 19, 34}
        list4.display();
    }
}
