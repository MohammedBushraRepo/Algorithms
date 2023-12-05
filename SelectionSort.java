package Sorting;

public class SelectionSort {
    public void sort(int[] array){
        //here we need multiple passes
        for (var i = 0 ; i < array.length ; i ++ ){
            //in each iteration we should find the next minimum value
            var minIndex = i; //assume the firt item is the smallest one
            //then we iterate over this array if we find smaller item will update the index
            for (var j = i ; j < array.length ; j ++)
                if (array[j] < array[minIndex])
                    minIndex = j;
            swap(array , minIndex , i);

        }
    }

    //helper method to swap indexes
    private void swap(int[] array , int index1 , int index2){
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
