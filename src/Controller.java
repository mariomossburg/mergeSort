import java.util.Random;

public class Controller {
    public static void main(String[] args) {

        long startTime;
        long endTime;
        long elapsedTime;
        int[] array = randomArray();
        int[] arrayTwo = array.clone();
        String[] arrayForAnyType = {"Spongebob", "Patrick", "Sandy", "Gary", "Plankton", "Mr.Crabs"};

        System.out.println("Before merge traditional merge algorithm: ");
        printArray(array);
        lineBreak();

        System.out.println("After merge traditional merge algorithm: ");
        traditionalMergeSort(array);
        printArray(array);
        lineBreak();

        IntegerMergeSort integerMergeSort = new IntegerMergeSort();
        System.out.println("Before merge class merge algorithm: ");
        printArray(arrayTwo);
        lineBreak();

        startTime = System.nanoTime();
        integerMergeSort.mergeSort(arrayTwo, 0, arrayTwo.length-1);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("after merge class merge algorithm:");
        printArray(arrayTwo);
        System.out.println("The elapsed time of this mergeSort method is: " + elapsedTime + " ns");
        lineBreak();

        System.out.println("Before merge of AnyType:");
        for(String s: arrayForAnyType){
            System.out.print(s + " ");
        }
        lineBreak();
        lineBreak();

        AnyTypeMergeSort anyTypeMergeSort = new AnyTypeMergeSort();
        anyTypeMergeSort.mergeSort(arrayForAnyType, 0, arrayForAnyType.length-1);
        System.out.println("After merge of AnyType:");
        for(String s: arrayForAnyType){
            System.out.print(s + " ");

        }
        lineBreak();
        lineBreak();

    }//end main
    public static void lineBreak(){
        System.out.println();
    }

    public static int[] randomArray(){
        Random random = new Random();
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(8000);
        }
        return array;
    }
    public static void printArray(int[] array){
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    private static void traditionalMergeSort(int[] inputArray){
        int inputLength = inputArray.length;

        if (inputLength < 2){
            return;//base case
        }
        int midIndex = inputLength/2;
        int[] leftHalf = new int[midIndex];//determining size
        int[] rightHalf = new int[inputLength-midIndex];

        for(int i = 0; i < midIndex; i++){
            leftHalf[i] = inputArray[i];
        }
        for(int i = midIndex; i < inputLength; i++){
            rightHalf[i - midIndex] = inputArray[i];
        }
        traditionalMergeSort(leftHalf);
        traditionalMergeSort(rightHalf);
        traditionalMerge(inputArray, leftHalf, rightHalf);
    }
    private static void traditionalMerge(int[] inputArray, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0,j = 0,k = 0;

        while (i < leftSize && j < rightSize){
            if (leftHalf[i] <= rightHalf[j]){
                inputArray[k] = leftHalf[i];
                i++;
            }else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i < leftSize){
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightSize){
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}//end class
