public class AnyTypeMergeSort<T extends Comparable<T>>{
    public void mergeSort(T[] A, int lowerBound, int upperBound){
        if (lowerBound >= upperBound){
            return;//base case
        }
        int midPoint = lowerBound + (upperBound - lowerBound) / 2;

        mergeSort(A, lowerBound, midPoint);
        mergeSort(A, midPoint + 1, upperBound);
        merge(A, lowerBound, midPoint ,upperBound);
    }

    public void merge(T[] A, int lowerBound, int midPoint, int upperBound){

        int leftArraySize = midPoint - lowerBound + 1;
        int rightArraySize = upperBound - midPoint;


        T[] leftArray = (T[]) new Comparable[leftArraySize];
        T[] rightArray = (T[]) new Comparable[rightArraySize];


        for (int i =0; i < leftArraySize; i++){
            leftArray[i] = A[lowerBound + i];
        }
        for (int j = 0; j < rightArraySize; j++){
            rightArray[j] = A[midPoint + 1  + j];
        }

        int i = 0;// inth item for left array
        int j = 0;// jth item for right array
        int k = lowerBound;// kth item for new merged array

        //The first while merges the two arrays together
        // the two following while loops merges any remaining
        //elements
        while (i < leftArraySize && j < rightArraySize){
            if (leftArray[i].compareTo(rightArray[j]) <= 0){
                A[k] = leftArray[i];
                i++;
            }else {
                A[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i < leftArraySize){
            A[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArraySize){
            A[k] = rightArray[j];
            j++;
            k++;
        }
    }
}//end class
