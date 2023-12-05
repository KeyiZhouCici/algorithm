/*
ID: cici.zh1
LANG: JAVA
TASK: college
*/

import java.io.*;

class college
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("college.in"));
        int number = Integer.parseInt(f.readLine());

        String line = f.readLine();
        String[] stringWant = line.split(" ");
        long [] want = new long[number];
        for (int i=0;i<number;i++)
        {
            want[i]=Integer.parseInt(stringWant[i]);
        }






        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("college.out")));


        out.close();

    }
}