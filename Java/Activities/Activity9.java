package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>();
        for(int i=0; i<5; i++)
        {
            myList.add("Test"+i);
        }

        for(String names : myList)
        {
            System.out.println(names);
        }

        System.out.println("Third element in the array is : " +myList.get(2));

        if(myList.contains("Test2"))
        {
            System.out.println("name is present in the list");
        }

        System.out.println("Size of the list before removing : " + myList.size());

        myList.remove(3);

        System.out.println("Size of the list after removing : " + myList.size());
    }
}
