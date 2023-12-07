/*
ID: cici.zh1
LANG: JAVA
TASK: college
*/

import java.io.*;
import java.util.*;

class college
{

    public static Dictionary<Integer, Integer> collect(List<Integer> a)
    {
        Dictionary <Integer,Integer> number = new Hashtable<>();
        int last = 0;
        int previous = 0;
        for (int b = 0;b <a.size()-2; b++)
        {
            if (!Objects.equals(a.get(b), a.get(b + 1)))
            {


                    if (number.isEmpty())
                    {
                        number.put(a.get(b),b+1);
                        previous = b+1;
                    }

                    else
                    {
                        number.put(a.get(b),b+1-previous);
                        previous = b ;
                    }
                    last = b;
            }

        }
        number.put(a.get(last+1), a.size()-last-1);
        return number;
    }


    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);
        int number =  in.nextInt();


        List<Integer> want = new ArrayList<>();


        for (int index= 0; index<number;index++)
        {
            want.add(in.nextInt());
        }


        Collections.sort(want);

        Dictionary<Integer,Integer> collectResult = new Hashtable<>();
        collectResult = collect(want);

        List<Integer> moneyForSchool = new ArrayList<>();
        List<Integer> moneyForCow = new ArrayList<>();

        int add  = 0;
        int tuition = 0;
        int c = 0;
        int b = 0;
        List<Integer> fee = new ArrayList<>();

        for (int i = 0;i<number;)
        {
            add = collectResult.get(want.get(i));
             if ( i == 0 )
             {
                  tuition = want.get(i) * number;
             }
             else
             {
                  tuition = want.get(i)*(number-c);
             }
             moneyForSchool.add(tuition);
             moneyForCow.add(want.get(i));

             fee.add(tuition);

             c = c + add;
             b = b+add;
             i = b;
        }

        int compare = 0;
        Collections.sort(fee);

        int maximum = fee.get(fee.size()-1);

         List<Integer> same = new ArrayList<>();

         for(int z=0; z<moneyForSchool.size()-1;z++)
         {
             if (moneyForSchool.get(z)==maximum)
             {
                 same.add(moneyForCow.get(z));
             }
         }
         Collections.sort(same);


        int result = fee.get(fee.size()-1);

        int each = same.get(0);

        System.out.println(result+" "+each);




    }
}