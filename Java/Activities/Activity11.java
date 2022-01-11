package activities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        Map<Integer,String> colours = new HashMap<Integer, String>() ;
        colours.put(1,"Blue");
        colours.put(2,"Orange");
        colours.put(3,"Yellow");
        colours.put(4,"Green");
        colours.put(5,"Black");

        Iterator it = colours.entrySet().iterator();

        while(it.hasNext())
        {
            Map.Entry map = (Map.Entry) it.next();
            System.out.println(map.getKey()+":"+map.getValue());
        }

        colours.remove(3);

        if(colours.containsValue("Green"))
        {
            System.out.println("Green colour is present in the map");
        }

        System.out.println("Size of the map is : " + colours.size());
    }
}
