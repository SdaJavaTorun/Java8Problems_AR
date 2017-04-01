package com.sda.Java8Problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static <T> Object lastRecursive (List<T> list) {


        return lastRecursive(list);
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

    public static <T> List<T> compressByLuk (List<T> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static <T> List<T> duplicate (List<T> list, int m) {
        List<T> multiList = new ArrayList<>();
        for (int x=0; x<list.size(); x++) {
            for (int y=0; y<m; y++)
                multiList.add(list.get(x));
        }

       // multiList = list.stream().flatMap(p -> p.)

        return multiList;
    }

    public static <T> List<T> duplicateByLuk (List<T> list, int m) {
        return list.stream().flatMap(e -> Collections.nCopies(m, e)
                .stream()).collect(toList());
    }

    public static <T> List<T> dropEveryNth (List<T> list, int m) {
        
        return IntStream
                .range(0, list.size())
                .filter(n -> (n+1) % 3 != 0)
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }
}
