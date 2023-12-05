

import java.io.*;

class dichotomy
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader f = new BufferedReader(new FileReader("dichotomy.in"));
        String targetInformation = f.readLine();
        int target = Integer.parseInt(targetInformation);
        String list = f.readLine();

        String [] information = list.split(" ");
        int numberForCalculate = list.length()-list.replace(" ","").length();
        int listNumber = numberForCalculate+1;

        int i = 0;
        int[]number = new int[1024];
        for(;i<listNumber;i++)
        {
            number[i]= Integer.parseInt(information[i]);
        }

        int low = 0;
        int high = listNumber;
        int mid = (low+high)/2;
        int outPrint;
        for (;;)
        {
            if (number[mid] == target)
            {
                outPrint = mid+1;
                break;
            }
           if (number[mid]>target)
           {
               mid = (high+low)/2;
               high = mid;
               if (number[mid] == target)
               {
                   outPrint = mid+1;
                   break;
               }
           }
           if (number[mid]<target)
           {
               mid = (high-mid)/2+mid;
               low = mid;
           }
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dichotomy.out")));
        out.println(outPrint);
        out.close();

    }
}