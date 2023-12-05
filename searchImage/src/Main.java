import java.io.*;

class searchImage
{
    static int cellNumber = 0;
    static void zeroFirstLine (char zeroOne, String [] cell)
    {
        zeroOne = cell[0].charAt(0);
        if(cell[0].charAt(1)!='0' && cell[1].charAt(0)!='0' && zeroOne!='0')
        {
            ++cellNumber;
        }
    }
    static void lastFirstLine (char lastOne, String [] cell,int length )
    {
        lastOne = cell[0].charAt(length - 1);
        if (cell[0].charAt(length - 2) != '0' && cell[1].charAt(length - 1) != '0' && lastOne!='0')
        {
            ++cellNumber;
        }
    }

    static void firstLineExceptHeadAndAss (String line,String [] cell,int length)
    {
        line = cell[0];
        for (int i = 1; i<length-1;i++)
        {
            if (cell[0].charAt(i)!='0' && cell[0].charAt(i-1)!='0' &&cell[0].charAt(i+1)!='0' &&cell[1].charAt(i)!='0')
            {
                ++cellNumber;
            }
        }
    }
    static void lastLineExceptHeadAndAss (String line,String [] cell,int length,int height)
    {
        line = cell[height-1];
        for (int i = 1; i<length-1;i++)
        {
            if (cell[height-1].charAt(i)!='0' && cell[height-1].charAt(i-1)!='0' &&cell[height-1].charAt(i+1)!='0' &&cell[height-2].charAt(i)!='0')
            {
                ++cellNumber;
            }
        }
    }

    static void middleLineForHead (char zeroOne, String [] cell,int height)
    {
        for (int i = 1; i<height-1;i++)
        {
            zeroOne = cell[i].charAt(0);
            if (cell[i].charAt(1)!='0' && cell[i+1].charAt(0)!='0' && zeroOne!='0' && cell[i-1].charAt(0)!='0')
            {
                ++cellNumber;
            }
        }
    }

    static void middleLineForAss (char zeroOne, String [] cell,int height)
    {
        for (int i = 1; i<height-1;i++)
        {
            zeroOne = cell[i].charAt(0);
            if (cell[i].charAt(1)!='0' && cell[i-1].charAt(0)!='0' && zeroOne!='0' && cell[i-1].charAt(0)!='0')
            {
                ++cellNumber;
            }
        }
    }

    static void  middleLine (String []cell,int height, int length)
    {
        for (int i = 1; i<height-1;i++)
        {
            for(int a =1;a<length-1;a++)
            {
                if(cell[i].charAt(a)!='0' && cell[i+1].charAt(a)!='0' && cell[i-1].charAt(a)!='0' && cell[i].charAt(a+1)!='0' && cell[i].charAt(a-1)!='0')
                {
                    ++cellNumber;
                }
            }
        }
    }





    public static void main(String[] args) throws Exception
    {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] information = bf.readLine().split(" ");
        int height = Integer.parseInt(information[0]);
        int length = Integer.parseInt(information[1]);

        String [] cell = new String[1024];
        for (int i=0;i<height;i++)
        {
            cell[i] = bf.readLine();
        }



        int total = height*length;
        char zeroOfFirstLine = '0';
        char lastOfFirstLine = '0';
        String firstLine = "0";
        String lastLine = "0";
        char zeroOne = '0';
        char zeroAss ='0';

        zeroFirstLine(zeroOfFirstLine,cell);
        lastFirstLine(lastOfFirstLine,cell,length);
        firstLineExceptHeadAndAss(firstLine,cell,length);
        lastLineExceptHeadAndAss(lastLine,cell,length,height);
        middleLineForHead (zeroOne,cell,height);
        middleLineForAss(zeroAss,cell,height);
        middleLine(cell,height,length);



        System.out.print(cellNumber);


    }
}