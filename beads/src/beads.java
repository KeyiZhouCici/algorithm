/*
ID: cici.zh1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class BeadInfo
{
    int redCount;
    int blueCount;

    public BeadInfo()
    {
        redCount = 0;
        blueCount = 0;
    }
}

public class beads {
    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        String number = f.readLine();
        String necklace = f.readLine();
        final String doubleNecklace = necklace + necklace;

        char[] beadArray = doubleNecklace.toCharArray();


        List<BeadInfo> leftBeadInfoList = new ArrayList<>(beadArray.length);
        for (int i = 0; i < beadArray.length; ++i) {
            BeadInfo beadInfo = new BeadInfo();
            leftBeadInfoList.add(beadInfo);
        }

        for (int i = 0; i < beadArray.length; ++i) {
            BeadInfo beadInfo = leftBeadInfoList.get(i);

            if (beadArray[i] == 'w') {
                if (i == 0) {
                    beadInfo.blueCount = 1;
                    beadInfo.redCount = 1;
                } else {
                    beadInfo.redCount = leftBeadInfoList.get(i - 1).redCount + 1;
                    beadInfo.blueCount = leftBeadInfoList.get(i - 1).blueCount + 1;
                }
            } else if (beadArray[i] == 'r') {
                if (i == 0) {
                    beadInfo.blueCount = 0;
                    beadInfo.redCount = 1;
                } else {
                    beadInfo.redCount = leftBeadInfoList.get(i - 1).redCount + 1;
                    beadInfo.blueCount = 0;
                }
            } else if (beadArray[i] == 'b') {
                if (i == 0) {
                    beadInfo.blueCount = 1;
                    beadInfo.redCount = 0;
                } else {
                    beadInfo.redCount = 0;
                    beadInfo.blueCount = leftBeadInfoList.get(i - 1).blueCount + 1;
                }
            }
        }


        List<BeadInfo> rightBeadInfoList = new ArrayList<>(beadArray.length);
        for (int i = 0; i < beadArray.length; i++) {
            BeadInfo beadInfo = new BeadInfo();
            rightBeadInfoList.add(beadInfo);
        }

        for (int i = beadArray.length - 1; i >= 0; --i) {
            BeadInfo beadInfo = rightBeadInfoList.get(i);

            if (beadArray[i] == 'w') {
                if (i == beadArray.length - 1) {
                    beadInfo.redCount++;
                    beadInfo.blueCount++;
                } else {
                    beadInfo.redCount = rightBeadInfoList.get(i + 1).redCount + 1;
                    beadInfo.blueCount = rightBeadInfoList.get(i + 1).blueCount + 1;
                }
            } else if (beadArray[i] == 'r') {
                if (i == beadArray.length - 1) {
                    beadInfo.redCount = 1;
                    beadInfo.blueCount = 0;
                } else {
                    beadInfo.redCount = rightBeadInfoList.get(i + 1).redCount + 1;
                    beadInfo.blueCount = 0;
                }
            } else if (beadArray[i] == 'b') {
                if (i == beadArray.length - 1) {
                    beadInfo.redCount = 0;
                    beadInfo.blueCount = 1;
                } else {
                    beadInfo.redCount = 0;
                    beadInfo.blueCount = rightBeadInfoList.get(i + 1).blueCount + 1;
                }
            }
        }


        rightBeadInfoList.remove(0);
        rightBeadInfoList.add(new BeadInfo());


        int max = 0;

        for (int i = 0; i < beadArray.length; ++i) {
            int leftMax = Math.max(leftBeadInfoList.get(i).redCount, leftBeadInfoList.get(i).blueCount);
            int rightMax = Math.max(rightBeadInfoList.get(i).redCount, rightBeadInfoList.get(i).blueCount);
            if (max>Integer.parseInt(number))
            {
                max = Integer.parseInt(number);
            }
            else {

                max = Math.max(max, leftMax + rightMax);
            }
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        out.println(max);
        out.close();
    }
}
