package Sorting;

public class QuickSort {
    /* 0 , 9
    * 4 pivot
    * (0 , 3)left
    * (5 , 9)right*/
    public void sort(int[] array){
        sort(array , 0 , array.length - 1);
    }
    private void sort(int[] array , int start , int end){
        //base condition to terminate the recursion
        if (start >= end) // that means we have single item array
            return;

        // Partition this array , as part of partitioning pivot will be assumed the last element in this array
        //it going to move to its correct position
        var boundary = partitioning(array , start , end);


        //Sort left - recursively
        sort(array , start , boundary - 1 ); // boundary represent the index of the pivot, ends before pivot

        //Sort right - recursively
        sort(array , boundary + 1 , end); // starts after the pivot

    }

    //Partitioning algorithm
    //the returning int is the index of the pivot after it moved to his correct position

    private int partitioning(int[] array , int start , int end){
        //assume pivot to be the last element of the array
        var pivot = array[end]; //array[array.length - 1 ];
        //also we need boundary which is set to -1 which means the left portion is empty , and the right starts from index 0
        var boundary = start - 1; //-1
        //we need to iterate over this array if we found if we find an item who is smaller than the pivot we need to but it in the left partition
        //and to do that we will increment the boundary and do a swap
        for (var i = start ; i <= end ; i++)
            if (array[i] <= pivot ){
                //increment the boundary
                boundary++;
                swap(array , i , boundary);
            }
        return boundary;//this will be the index of the pivot after its moved

    }
    //helper method to swap indexes
    private void swap(int[] array , int index1 , int index2){
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
