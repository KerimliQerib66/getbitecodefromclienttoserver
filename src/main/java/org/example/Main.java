package org.example;

import Bean.Client;
import Bean.Server;
import UtilPaket.Message;
import UtilPaket.Scanner1;
import UtilPaket.Splitmethodforlocalandport;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Message m=new Message();
        Scanner1 sc1=new Scanner1();
        Splitmethodforlocalandport sm=new Splitmethodforlocalandport();

       System.out.println(m.nameandsurname);
        String name= sc1.scString();
System.out.println(m.portnumber);
        ArrayList<Object> aj =sm.portnumber();

        System.out.println(m.fileSource);
        String filesource= sc1.scString();

        ExecutorService Ex= Executors.newFixedThreadPool(2);
       Ex.execute(new Server());
       Ex.execute(new Client((String) aj.get(0),(int)aj.get(1),filesource));

       try {
           if(!Ex.awaitTermination(10, TimeUnit.SECONDS)){
               Ex.shutdownNow();
           }
       }
       catch (InterruptedException e){
           Ex.shutdownNow();
           Thread.currentThread().interrupt();
           e.printStackTrace();

       }
       System.out
    }
}