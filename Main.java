import Search.Search;
import Sorting.BubbleSort;
import Sorting.MergeSort;
import Sorting.QuickSort;
import Sorting.SelectionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        int[] numbers = {7 , 2 , 9 , 4 , 5 };
        var search  = new Search();
        var index = search.LinearSearch(numbers , 9);
        System.out.println(index);


    }
}

/*Sorting tests
* int[] numbers = {7 , 3 ,5,5 ,1,2};
        var sorter = new QuickSort(); //just intialize the sorting class here
        sorter.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        * */