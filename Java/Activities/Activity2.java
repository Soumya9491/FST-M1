package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] arrNumbers = {10, 77, 10, 54, -11, 10};


        System.out.println(sumResult(arrNumbers));
    }

    public static boolean sumResult(int[] arr)
    {
        boolean flag = false;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 10) {
                sum = sum + arr[i];
            }
        }

        if (sum == 30) {
            flag = true;
        }
        return flag;
    }
}
