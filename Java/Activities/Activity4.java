package activities;

import java.util.Arrays;

public class Activity4 {
    public static void main(String[] args) {
        int[] arrNum = {4,3,5,6,9,2,0,1};
        System.out.println("Before sorting : "+ Arrays.toString(arrNum));
        sortArray(arrNum);
        System.out.println("After sorting : " + Arrays.toString(arrNum));
    }

    public static void sortArray(int[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[i]>arr[j])
                {
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
    }
}
