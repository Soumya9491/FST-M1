package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<Integer>();

        for(int i=0; i<6; i++)
        {
            hs.add(i);
        }

        System.out.println("Size of the hash set is : " + hs.size());

        hs.remove(2);

        try{
            hs.remove(6);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        if(hs.contains(3))
        {
            System.out.println("Element is present");
        }

        for(int n : hs)
        {
            System.out.println(n);
        }
    }
}
