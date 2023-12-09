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

        for (int a = 0; a<number; a++)
        {
            if ()
        }





    }
}