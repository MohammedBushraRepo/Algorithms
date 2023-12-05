package Sorting;

public class MergeSort {
    public void sort(int[] array){

        //base condition to terminate the recursion -- stop when we have an array of a single item because it is already sorted
        if (array.length < 2)
            return;

        //divide this array to half
        var middle = array.length / 2 ;
        //allocate new array that will our new partition

        int[] left = new int[middle];
         //new we need to copy all item up to middle point
        for (var i = 0 ; i < middle ; i++ )
            left[i] = array[i];

        //now we need to create the write partition as well
        int[] right = new int[array.length - middle];
        for (var i = middle ; i < array.length ; i++)//we start looping from the middle
            right[i - middle] = array[i]; //right[i - middle] to calculate the right index

        //Sort each half , using recursive calls
        sort(left);
        sort(right);
        //Merge the result
        merge(left , right , array);
    }
    private void merge (int[] left , int[] right , int[] result){
       //here we need three counter variable i for left, j for right , k for result
        int i = 0 , j = 0 , k = 0 ;
        while (i < left.length && j < right.length ){   //with i and j we read one item at a time from each array
            //now we need the smallest value and store it in the result array
            if (left[i] <= right[j])
                result[k++] = left[i++]; // copy the item of index i to result k with index k and increment next item
            else
                result[k++] = right[j++];
        }
        //if the right partition has a lot of items
        while (i < left.length )
            result[k++] = left[i++];


        while (j < right.length)
            result[k++] = right[j++];
    }
}
