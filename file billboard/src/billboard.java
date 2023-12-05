/*
ID: cicizhou
LANG: JAVA
TASK: billboard
*/

import java.io.*;

public class billboard
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("billboard.in"));
        String[] oneBoard;
        oneBoard = f.readLine().split(" ");
        String[] twoBoard;
        twoBoard = f.readLine().split(" ");
        String[] track ;
        track = f.readLine().split(" ");


        int [] oneLocation = new int[4];
        for (int i = 0;i<4;i++)
        {
            oneLocation[i]=Integer.parseInt(oneBoard[i]);
        }

        int [] twoLocation = new int[4];
        for (int i = 0;i<4;i++)
        {
            twoLocation[i]=Integer.parseInt(twoBoard[i]);
        }

        int [] trackLocation = new int[4];
        for (int i = 0;i<4;i++)
        {
            trackLocation[i]=Integer.parseInt(track[i]);
        }

        int oneLength = oneLocation[2]-oneLocation[0];
        int oneWide = oneLocation[3]-oneLocation[1];
        int twoLength = twoLocation[2]-twoLocation[0];
        int twoWide = twoLocation[3]-twoLocation[1];
        int trackLength = trackLocation[2]-trackLocation[0];
        int trackWide = trackLocation[3]-trackLocation[1];

        int one = oneLength * oneWide;
        int two = twoLength * twoWide;


        int hideLO = 0;
        int hideWO = 0;
        int hideLT = 0;
        int hideWT = 0;

        if (trackLocation[0]<=oneLocation[0])
        {
            if (trackLocation[2]>oneLocation[2])
            {
                hideLO = oneLength;
            }
            else if (trackLocation[2]<=oneLocation[0])
            {
                hideLO = 0;
            }
            else
            {
                hideLO = trackLocation[2]-oneLocation[0];
            }
        }
        else if (trackLocation[0]<=oneLocation[2])
        {
           if (trackLocation[2]>oneLocation[2])
           {
               hideLO = oneLocation[2]-trackLocation[0];
           }
           else if (trackLocation[2]<=oneLocation[0])
           {
               hideLO = 0;
           }
           else
           {
               hideLO = trackLength;
           }
        }




       if  (trackLocation[0]<=twoLocation[0])
       {
           if (trackLocation[2]>twoLocation[2])
           {
               hideLT = twoLength;
           }
           else if (trackLocation[2]<twoLocation[0])
           {
               hideLT = 0;
           }
           else
           {
               hideLT = trackLocation[2]-twoLocation[0];
           }
       }
       else if (trackLocation[0]<=twoLocation[2])
       {
           if (trackLocation[2]<twoLocation[0])
           {
               hideLT = 0;
           }
           else if (trackLocation[2]>twoLocation[2])
           {
               hideLT = twoLocation[2]-trackLocation[0];
           }
           else
           {
               hideLT = trackLength;
           }
       }




       if (trackLocation[1]<=oneLocation[1])
       {
          if (trackLocation[3]>oneLocation[3])
          {
              hideWO=oneWide;
          }
          else if (trackLocation[3]<oneLocation[0])
          {
              hideWO = 0;
          }
          else
          {
              hideWO = trackLocation[3]-oneLocation[1];
          }
       }
       else if (trackLocation[1]<=oneLocation[3])
       {
           if (trackLocation[3]<oneLocation[1])
           {
               hideWO = 0;
           }
           else if (trackLocation[3]>oneLocation[3])
           {
               hideWO = oneLocation[3]-oneLocation[1];
           }
           else
           {
               hideWO = trackWide;
           }
       }




       if (trackLocation[1]<=twoLocation[1])
       {
         if (trackLocation[3]>twoLocation[3])
         {
             hideWT = twoLength;
         }
         else if (trackLocation[3]<twoLocation[1])
         {
             hideWT = 0;
         }
         else
         {
             hideWT = trackLocation[3]-twoLocation[1];
         }
       }
       else if (trackLocation[1]<=twoLocation[3])
       {
          if (trackLocation[3]<twoLocation[1])
          {
              hideWT = 0;
          }
          else if (trackLocation[3]>twoLocation[3])
          {
              hideWT = twoLocation[3]-trackLocation[1];
          }
          else
          {
              hideWT = trackWide;
          }
       }




        int no = (hideWO * hideLO) +(hideWT*hideLT);
        int result = one + two -no;
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

        out.println(result);
        out.close();

    }
}