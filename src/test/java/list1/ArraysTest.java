package list1;

import com.sda.Java8Problems.CollectionUtils;
import org.junit.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.*;

import com.sda.Java8Problems.ArraysExec;

import static java.util.Arrays.asList;
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
    public void shouldDuplicateElementsInAList() throws Exception {
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
}
