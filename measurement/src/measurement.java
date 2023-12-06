/*
ID: cicizhou
LANG: JAVA
TASK: measurement
*/

import java.io.*;
import java.util.*;

class Cows
{
    String name;
    int date;
    char po;
    int scoreChange;

    int score;

}

class measurement
{
    static Cows info(String line)
    {
        List<Cows> cowsList = new ArrayList<>();
        String [] information = line.split(" ");
        Cows cow = new Cows();
        cow.date = Integer.parseInt(information[0]);
        cow.name = information[1];
        cow.po = information[2].charAt(0);
        String w = information[2];
        int howLong  = w.length();
        for(int i = 0; i<howLong-1;i++)
        {
               cow.scoreChange += w.charAt(i+1);
        }
        cow.score = 7;



        return cow;
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        int lineNum =Integer.parseInt( f.readLine());
        List<Cows> cowsList = new LinkedList<>();

        List<Integer>skip = new ArrayList<>();
        for (int index = 0; index<lineNum;index++)
        {
            cowsList.add(info(f.readLine()));
        }


       for (int a = 0; a<lineNum-1;a++)
       {
           int min = a;
           for (int b = a + 1; b < lineNum; b++)
           {
               if (cowsList.get(b).date < cowsList.get(min).date)
               {
                   min = b;
               }

           }

           if (min != a)
           {
               Collections.swap(cowsList, min, a);
           }
       }


        int total=0;
        int winCowNumber=0;
        Dictionary<String,Integer> dicCow = new Hashtable<>();
        List<String> cowsName = new ArrayList<>();

        for (int c = 0; c<lineNum;c++)
        {
            if (!cowsName.contains(cowsList.get(c).name))
            {
                cowsName.add(cowsList.get(c).name);
                dicCow.put(cowsList.get(c).name,cowsList.get(c).score);
            }



            if (cowsList.get(c).po == '+')
            {
                dicCow.put(cowsList.get(c).name,dicCow.get(cowsList.get(c).name) + cowsList.get(c).scoreChange);

            }
            else
            {
                dicCow.put(cowsList.get(c).name,dicCow.get(cowsList.get(c).name) - cowsList.get(c).scoreChange);
            }

            if (c==0)
            {
                winCowNumber = 0;
                ++total;
            }
            else
            {
              if(dicCow.get(cowsList.get(c).name)>= dicCow.get(cowsList.get(winCowNumber).name))
              {

                  if (cowsList.get(c).name!=cowsList.get(winCowNumber).name)
                  {
                      winCowNumber = c;
                      ++total;
                  }
              }

            }
        }



        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

        out.println(total);
        out.close();

    }
}


