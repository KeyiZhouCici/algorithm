/*
ID: cici.zh1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

class Cat {
    private String name;
}

class friday
{
//    public static int

    public static void main (String [] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        String number = f.readLine();
        int namenumber = Integer.parseInt(number);
        List<String> namelist = new ArrayList<>();
        for (int i = 1; i <= namenumber; i++)
        {
            String name = f.readLine();
            namelist.add(name);
        }

        Dictionary<String, Integer> dictionary = new Hashtable<>();
        for (int a = 1; a <= namenumber; a++)
        {
            String people = f.readLine();
            String information = f.readLine();
            String[] splitinformation = information.split(" ");
            String money = splitinformation[0];
            String given = splitinformation[1];
            int givennumber = Integer.parseInt(given);
            int moneyinitialint = Integer.parseInt(money);
            int everyoneadd = 0;

            if (givennumber != 0)
            {
                everyoneadd = Math.floorDiv(moneyinitialint, givennumber);
            }
            if (givennumber == 0)
            {
                 everyoneadd = 0;
            }
            int negativemoneywithleft = moneyinitialint*(-1) +(moneyinitialint-(everyoneadd * givennumber));
            int allmoney = 0;
             if(dictionary.get(people) != null)
             {
                int moneygetted = dictionary.get(people);
                allmoney = moneygetted +negativemoneywithleft;
             }
            if(dictionary.get(people) == null)
            {
                dictionary.put(people, moneyinitialint*(-1));
                allmoney = negativemoneywithleft;
            }
            dictionary.put(people,allmoney );



            for (int c = 1; c <= givennumber; c++) {
                String moneygetter = f.readLine();
                if(dictionary.get(moneygetter) != null)
                {
                    int addedafter = dictionary.get(moneygetter)+everyoneadd;
                    dictionary.put(moneygetter,addedafter);
                }
                if (dictionary.get(moneygetter)==null)
                {
                    dictionary.put(moneygetter, everyoneadd);
                }
            }


        }


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

       for(int iii = 0; iii < namelist.size(); iii++)
        {
            String key = namelist.get(iii);
            out.println(key+" "+dictionary.get(key));
        }
       out.close();
    }
}



