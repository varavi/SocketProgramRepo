package com.rkv.notification;

public class Demo {

    public static void main(String[] args) {

Demo.getSeries(100);
    }

   public static void getSeries(int input)
   {
      int col=1;
       while((col+col+1)<=input){
         int  tempCol=col;
         int  sum=0;
           while(sum<input)
           {

               sum+=col;
               col++;
           }
           if(sum==input)
           {
               col=tempCol;
               sum=0;
               while(sum<input)
               {
                   System.out.print(" "+(col));
                   sum+=col;
                   col++;

               }
               System.out.println();

           }

           col=tempCol+1;
       }
   }
}
