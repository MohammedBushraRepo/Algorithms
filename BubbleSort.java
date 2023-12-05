package Sorting;

public class BubbleSort {

    public void sort(int[] array){
        boolean isSorted;
        //here we need a loop to iterate over this array multiple times
        //in each iteration the next largest number will bubble up
        for (var i = 0 ; i < array.length ; i++){
            //Assume array is sorted
            isSorted = true;
            //here we need second loop  to compare every two items in this array , set i = 1 to start from the second item
            for (var j = 1 ; j < array.length - i ; j++)
                //compare j with the previous item
                if (array[j] < array[j - 1]) {   //that's mean we need to swap them , out of order , swap them
                    swap(array, j, j - 1);
                    isSorted = false;
                }
                if (isSorted)
                    return;
        }
    }

    //helper method to swap indexes
    private void swap(int[] array , int index1 , int index2){
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
