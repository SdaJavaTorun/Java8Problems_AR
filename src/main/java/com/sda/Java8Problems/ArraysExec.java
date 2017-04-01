package com.sda.Java8Problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
//import static java.util.stream.Nodes.collect;

/**
 * Created by arczi on 4/1/17.
 */
public class ArraysExec {

    public static <T> T last (List<T> element) {

        int numberOfElements = element.size();
        return element.get(numberOfElements - 1);
    }

    public static <T> T lastList(LinkedList<T> el) { return el.getLast(); }

    public static <T> T lastRecursive (List<T> element) {
        return null;
    }

    //public static <T> int length (List<T> elements) {

      //  return elements.size();

    //}

    // wersja ze streamem
    public static <T> long length (List<T> elements) {

        if (elements == null)
            throw new IllegalArgumentException("Lista nie moze byc pusta");

        return elements.stream().count();
    }

    public static <T>List<T> reverse (List<T> elements) {

        Collections.reverse(elements);

        return elements;
    }

    public static <T> List<T> reverseIter (List<T> list) {
        int size = list.size();
        return IntStream.iterate(size - 1, el -> el -1)
                .limit(size).mapToObj(list::get).collect(toList());

    }

    public static <T> T lastRecursive () {

        return null;
    }

    public static <T> boolean isPalindrome (List<T> list) {
/*
        Stream.of(list).collect(Collectors.toCollection(LinkedList::new));

        StringBuilder strBuilder = new StringBuilder(String.valueOf(list));

        strBuilder.reverse();

        if(list.equals(strBuilder.toString())){
            return true;
        } else {
           return false;
        }
  */
    List<T> original = new ArrayList<T>(list);
    ArraysExec.reverse(list);
    return Objects.equals(list, original);
    }

    public static <T> List<T> compress (List<T> list) {

        HashSet<T> set = new HashSet<>(list);

        List<T> al = new ArrayList<>();
        for (T hashSet: set) al.add(hashSet);

        return al;
    }
}
