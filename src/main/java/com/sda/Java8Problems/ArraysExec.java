package com.sda.Java8Problems;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class ArraysExec {

    // private static T e;

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
                .filter(n -> (n+1) % m != 0)
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }

    public static <T> List<T> inputAt(List< T> input, int i, T alfa) {

                    input.add(i-1, alfa);
                    return input;
    }

    /**
     *
     */

    public static List<AbstractMap.SimpleEntry<Integer, String>> encode (List<String> list) {

        List<AbstractMap.SimpleEntry<Integer, String>> newList =
                new ArrayList<>();
        //AbstractMap.SimpleEntry<Integer, String> map =
        //        new AbstractMap.SimpleEntry(null, null);

        //String str = list.toString();
        int counter = 1; // licznik wystapien
        //String listPoz = ""; // do zapamietania nr indexu
//        counter = IntStream
//                .range(0, list.size())
//                .filter(i -> list.get(i).equals('a'))
//                .count();

//        AbstractMap.SimpleEntry<Integer, String> mMap = list.stream()
//                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

//        for (char c: list.to) {
//            if (c == 'a') counter++;
//        }
        for (int x = 0; x < list.size(); x++) {

            if (x < list.size()-1) {
                if (list.get(x) == list.get(x + 1)) {
                    counter++;
                } else {
                    //listPoz = list.get(x);
                    newList.add(new AbstractMap.SimpleEntry(counter, list.get(x)));
                    counter = 1;
                }
            }
            else
                newList.add(new AbstractMap.SimpleEntry(counter, list.get(x)));
        }
        return newList;
    }

    public static <T> List<String> decode(List<Serializable> serializables) {

        List<T> newList = new ArrayList<>();

        System.out.println(serializables.toString() + " " + serializables.size());

        for (int x =0; x < serializables.size(); x++) {
            if (serializables.get(x) instanceof IntStream) {
                int key = (int) serializables.get(x);
                for (int y =0; y < key; y++)
                    newList.add((T) serializables.get(x+1));
            }
        }

        //T[] str = elements;

       /* for (int x = 0; x < elements.length; x++) {
            if (str.hasNextInt() ) {}

        }*/


        return (List<String>) newList;
        //return Stream.of(elements).collect(Collectors.toCollection(List::new));
    }

    public static List <Integer> randomSelect (int limit, int low, int high) {

        return new Random().ints(limit, low, high)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List <Integer> range (Integer i, Integer j) {

        return IntStream
                .rangeClosed(i, j)
                .boxed()
                .collect(Collectors.toList());
    }

    public static HashMap<Boolean, List<String>> split (List<String> list, int i) {

        HashMap<Boolean, List<String>> map = new HashMap<>();
        map.put(true, list.subList(0, i));
        map.put(false, list.subList(i, list.size()));

        return map;
    }

    public static <T> List<T> duplicate2(List<T> list) {

        return list.stream().flatMap(e -> Collections.nCopies(2, e)
                .stream()).collect(toList());
    }

}
