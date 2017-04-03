package list1;

import com.sda.Java8Problems.ArraysExec;
import com.sda.Java8Problems.CollectionUtils;
import org.junit.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;


public class ArraysTest {

    @Test
    public void shouldFindLastElementFromAList() {

        assertThat(ArraysExec.last(asList("a", "as", "c")),
               is(equalTo("c")));
    }

    @Test
    public void shouldFindLastElementFromALinkedList() {

        LinkedList<String> list = CollectionUtils.linkedList("a", "b", "c");

        //LinkedList<String> list = new LinkedList<>(Arrays.asList("a", "as", "c"));
                assertThat(ArraysExec.lastList(list), is(equalTo("c")));
    }

    @Test
    public void shouldFindLastElementFromArraysList() {

        ArrayList<String> alist = CollectionUtils.arrayList("a", "b", "c");

        //LinkedList<String> list = new LinkedList<>(Arrays.asList("a", "as", "c"));
        //assertThat(ArraysExec.last(asList()), is(equalTo("c")));
    }

    //
    @Test
    public void shouldFindLastElementFromAListUsingRecursion () {
          assertThat(ArraysExec.lastRecursive(asList("a","b","c")), is(equalTo("c")));
    }

    @Test
    public void listOfEmptyListShouldBe0 () {
        long length1 = ArraysExec.length(Collections.emptyList());
        assertThat(length1, is(equalTo(0L)));
    }

    @Test
    public void shouldFindListOfNonEmptyList () {
        assertThat(ArraysExec.length(asList(1,2,3,4,5,6)), is(equalTo(6L)));
    }

    @Test
    public void shouldReverseAList () {
        List<Integer> numbers = asList(1,2,3,4,5,6,7,8,9,10);
        assertThat(ArraysExec.reverse(numbers), is(equalTo(asList(10,9,8,7,6,5,4,3,2,1))));
    }

    @Test
    public void shouldReturnTrueWhenListIsPalindrome () {
        assertTrue(ArraysExec.isPalindrome(asList("a", "l", "a")));
    }

    @Test
    public void shouldRemoveConsecutiveDuplicatesInAList () {
        List<String> compressedList = ArraysExec.compress(asList("a","a","e","a","a","b","b", "c", "c", "d","d","d","d", "e","e","e","e","e","e"));
        assertThat(compressedList, contains("a", "b", "c", "d", "e"));
    }

    @Test
    public void shouldDuplicateElementsInAList2() {
        List<String> duplicates = ArraysExec.duplicate(Arrays.asList("a","b", "c"), 3);
        assertThat(duplicates, contains("a","a","a","b","b","b","c","c","c"));
    }

    @Test
    public void shouldDuplicateElementsInAListByLuk() throws Exception {
        List<String> duplicates = ArraysExec.duplicateByLuk(Arrays.asList("a","b", "c"), 3);
        assertThat(duplicates, contains("a","a","a","b","b","b","c","c","c"));
    }

    @Test
    public void shouldDropEveryNthElement () {
        List<String> result = ArraysExec.dropEveryNth(Arrays.asList(
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 3 );
        assertThat(result, contains("a", "b", "d", "e", "g", "h", "j", "k"));
    }

    @Test
    public void shouldInsertElementAtSecondPosition() {
        List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
        List<String> result = ArraysExec.inputAt(input,2, "alfa");
        assertThat(result, contains("a", "alfa", "b", "c", "d"));
    }

    /**
     *
     * HW
     */

    @Test
    //liczba elementow powtarzajacych sie
    public void shouldEncodeAList() throws Exception {
        List<AbstractMap.SimpleEntry<Integer, String>> encodedList = ArraysExec.encode(
                Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
        assertThat(encodedList.get(0), is(equalTo(new AbstractMap.SimpleEntry<>(4, "a"))));
        assertThat(encodedList.get(1), is(equalTo(new AbstractMap.SimpleEntry<>(1, "b"))));
        assertThat(encodedList.get(2), is(equalTo(new AbstractMap.SimpleEntry<>(2, "c"))));
        assertThat(encodedList.get(3), is(equalTo(new AbstractMap.SimpleEntry<>(2, "a"))));
        assertThat(encodedList.get(4), is(equalTo(new AbstractMap.SimpleEntry<>(1, "d"))));
        assertThat(encodedList.get(5), is(equalTo(new AbstractMap.SimpleEntry<>(4, "e"))));
    }


    @Test
   //odwrotnosc poprzedniego
    public void shouldDecodeEncodedList() throws Exception {
        List<String> encoded = ArraysExec.decode(
                Arrays.asList(
                        new AbstractMap.SimpleEntry<>(4, "a"), "b",
                        new AbstractMap.SimpleEntry<>(2, "c"),
                        new AbstractMap.SimpleEntry<>(2, "a"), "d",
                        new AbstractMap.SimpleEntry<>(4, "e")));

        assertThat(encoded, hasSize(14));
    }

    @Test
    //duplikaty elementow
    public void shouldDuplicateElementsInAList() throws Exception {
        List<String> duplicates = ArraysExec.duplicate2(Arrays.asList("a", "b", "c", "d"));
        assertThat(duplicates, hasSize(8));
        assertThat(duplicates, contains("a", "a", "b", "b", "c", "c", "d", "d"));
    }

    @Test
    //podzial listy
    public void shouldSplitInTwoHalves() throws Exception {
        Map<Boolean, List<String>> result =
                ArraysExec.split(
                        Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3);
        assertThat(result.get(true), contains("a", "b", "c"));
        assertThat(result.get(false), contains("d", "e", "f", "g", "h", "i", "k"));
    }

    @Test
    //stworzenie listy z podanego zakresu
    public void shouldCreateARangeBetween4And9() throws Exception {
        List<Integer> range = ArraysExec.range(4, 9);
        assertThat(range, hasSize(6));
        assertThat(range, contains(4, 5, 6, 7, 8, 9));

    }

    @Test
    public void shouldGive6RandomNumbersFromARangeStartingFrom1To49() throws Exception {
        List<Integer> randomList = ArraysExec.randomSelect(6, 1, 49);
        assertThat(randomList, hasSize(6));
        System.out.println(randomList); // One possible output [47, 30, 36, 38, 11, 1]
    }
}
