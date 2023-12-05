import java.io.*;
import java.util.ArrayList;
import java.util.List;

class SelectSort
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("SelectSort.in"));
        String listWithoutOrder = f.readLine();
        String [] information = listWithoutOrder.split(" ");

        int numberOfElement = listWithoutOrder.length()-listWithoutOrder.replace(" ","").length()+1;
        List<Integer> numberList = new ArrayList<Integer>();
        int[] numberWithoutOrder = new int[1024];
        int i =0;
        for (; i<numberOfElement;i++)
        {
            numberWithoutOrder[i] = Integer.parseInt(information[i]);
            numberList.add(numberWithoutOrder[i]);
        }
//       List<Integer>newList = new ArrayList<Integer>();
        int mid = Integer.MAX_VALUE;
        int placeOfList = -1 ;
        for (int a=0;a<numberOfElement;a++)
        {
            mid = Integer.MAX_VALUE;
            for (i=a;i<numberList.size();i++)
            {
                if(numberList.get(i)<mid)
                {
                    mid = numberList.get(i);
                    placeOfList = i;
                }
            }
//            newList.add(mid);
//            numberList.remove(placeOfList);
              numberList.set(placeOfList,numberList.get(a));
              numberList.set(a,mid);

        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("SelectSort.out")));
        for (int b=0;b<numberOfElement;b++)
        {
            out.println(numberList.get(b));
        }
        out.close();

    }
}