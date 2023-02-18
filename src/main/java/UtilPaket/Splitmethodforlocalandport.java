package UtilPaket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Splitmethodforlocalandport {
    public  ArrayList portnumber()

    {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String [] arr=a.split(":");
        int b=Integer.parseInt(arr[1]);
     ArrayList<Object> list=new ArrayList<>();
     list.add(arr[0]);
     list.add(b);
     return list;
    }

}
