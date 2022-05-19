package Test;

import java.util.HashSet;
import java.util.Set;

public class Testing {

    public static void main(String args[])
    {
        int res =  Integer.MAX_VALUE;


        System.out.println(Math.min(res, -1));


        Set<Integer> maps = new HashSet<Integer>();

        int[] arr = {-2,0,10,-19,4,6,-8};

        for(int i=0;i<arr.length;i++)
        {
            maps.add(arr[i]);
        }

        for(int i=0;i<arr.length;i++)
        {
            if(maps.contains((arr[i]*2)))
               System.out.println(arr[i]*2);
        }
    }
}
