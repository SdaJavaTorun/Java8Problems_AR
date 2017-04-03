package com.sda.Java8Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by arczi on 4/1/17.
 */
public class CollectionUtils {

    //wkladanie dowolnej ilosci elementow do listy

    public static <T>LinkedList<T> linkedList(T... elements) {

        return Stream.of(elements).collect(Collectors.toCollection(LinkedList::new));
    }

    //wkladanie dowolnej ilosci elementow do listy

    public static <T>ArrayList<T> arrayList(T... elements) {

        return Stream.of(elements).collect(Collectors.toCollection(ArrayList::new));
    }



}
