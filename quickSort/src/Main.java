import java.io.*;
import java.util.ArrayList;
import java.util.List;


class quickSort
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("quickSort.in"));
        String numbers = f.readLine();
        String[] numberList = numbers.split(" ");
        int count = numbers.length() - numbers.replace(" ", "").length()+1;


        int[] listNumberInt = new int[1024];
        for (int i = 0; i < count; i++) {
            listNumberInt[i] = Integer.parseInt(numberList[i]);
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int n = 0; n < count; n++) {
            list.add(listNumberInt[n]);
        }

        for (int a = 0; a< count; a++)
        {
            if(a==count-1)
            {
                break;
            }
            int stopPosition;
            int calculateNumber = count+1 ;
            int b = 1;
            int c = 1;

            int numberToCheck = 0;
            numberToCheck = calculateNumber - a - 1;
            if (numberToCheck < 0)
            {
                numberToCheck = 0;
            }


            int bNumber = 0;
            for (; b < numberToCheck; ) {
                if (list.get(a) > list.get(a + b)) {
                    int one = list.get(a);
                    int two = list.get(a + b);
                    int numberToChange = list.get(a + c);
                    list.set(a + c, list.get(a + b));
                    list.set(a + b, numberToChange);
                    c++;
                    bNumber = b+1;
                }
                ++b;
            }
            if(c>1)
            {
                int swichNumber = list.get(a + c - 1);
                list.set(a + c - 1, list.get(a));
                list.set(a, swichNumber);
            }

            if (a + bNumber - 1 == a + 1) {
                stopPosition = 0;
                a++;
            } else {
                stopPosition = a + bNumber - 1;
                calculateNumber = count - 1 - (stopPosition);
            }
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("quickSort.out")));
        for (int result = 0; result < count; result++)
        {
            out.println(list.get(result));
        }
        out.close();
    }
}



