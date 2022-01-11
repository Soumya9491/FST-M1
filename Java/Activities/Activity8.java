package activities;

public class Activity8 {
    public static void main(String[] args) {
        try {
            Activity8.exceptionTest("New Message");
            Activity8.exceptionTest(null);
        }
        catch(CustomException m)
        {
            System.out.println(m.getMessage());
        }
    }

     public static void exceptionTest(String s) throws CustomException
    {
            if (s == null) {
                throw new CustomException("String value is null");
            } else {
                System.out.println(s);
            }

    }
}
