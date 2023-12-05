package Sorting;

public class InsertionSort {
    public void sort(int[] array ){
        //here we want to iterated over this array and insert each item in the correct position
        for (var i = 1 ; i < array.length ; i++){//we start from second number index[1] , because when we read the first item we assume it in the correct position

            var current = array[i];
            //we need another loop to look at all the previous items and if they greater shift them to the right
            var j = i - 1 ;   // start from the previous item
            while (j >= 0 && array[i] > current){ //as long as the item we have in j is grater than current
                array[j + 1] = array[j];  // copy the item to the right side
                j--; //decrement j
            }
            //so after this while loop all greater items will be shifted to the right
            //now store the current item on index j + 1
            array[j + 1] = current;
        }
    }
}
