/*
ID: cici.zh1
LANG: JAVA
TASK: friday
*/

import java.io.*;

import static java.lang.System.out;

class friday {
    static int mon = 0;
    static int tues = 0;
    static int wed = 0;
    static int thur = 0;
    static int fri = 0;
    static int sat = 0;
    static int sun = 0;

    public static void MonthDay(int ThirteenWeekDay) {
        if (ThirteenWeekDay == 3) {
           ++mon;
        } else if (ThirteenWeekDay == 4) {
           ++tues;
        } else if (ThirteenWeekDay == 5) {
            ++wed;
        } else if (ThirteenWeekDay == 6) {
            ++thur;
        } else if (ThirteenWeekDay == 7) {
            ++fri;
        } else if (ThirteenWeekDay == 1) {
           ++sat;
        } else if (ThirteenWeekDay == 2) {
           ++sun;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        String yeard = f.readLine();
        int yearduring = Integer.parseInt(yeard);

        ++sat;
        int november = 0;

        int december = 0;
        for (int i = 0; i < yearduring; i++) {
            if (1900 + i != 1900) {
                december = (november + 31) % 7;

                int janruaryfirstday = december + 1;
                MonthDay(janruaryfirstday);
            }

            int January = (december + 31) % 7;
            int Februaryfirstday = January + 1;

            MonthDay(Februaryfirstday);

            int February;
            int modofleapyear = (1900 + i) % 4;

            if (modofleapyear == 0 && 1900 + i != 1900 && 1900 + i != 2100 && 1900 + i != 2200) {
                February = (January + 29) % 7;
            } else {
                February = (January + 28) % 7;
            }

            int Marchfirstday = February + 1;
            MonthDay(Marchfirstday);

            int March = (February + 31) % 7;
            int Aprilfirstday = March + 1;
            MonthDay(Aprilfirstday);

            int April = (March + 30) % 7;
            int Mayfirstday = April + 1;
            MonthDay(Mayfirstday);

            int May = (April + 31) % 7;
            int Junefirstday = May + 1;
            MonthDay(Junefirstday);

            int June = (May + 30) % 7;
            int Julyfirstday = June + 1;
            MonthDay(Julyfirstday);

            int July = (June + 31) % 7;
            int Augustfirstday = July + 1;
            MonthDay(Augustfirstday);

            int August = (July + 31) % 7;
            int Septemberfirstday = August + 1;
            MonthDay(Septemberfirstday);

            int September = (August + 30) % 7;
            int octoberfirstday = September + 1;
            MonthDay(octoberfirstday);

            int october = (September + 31) % 7;
            int novemberfirstday = october + 1;
            MonthDay(novemberfirstday);

            november = (october + 30) % 7;
            int decemberfirstday = november + 1;
            MonthDay(decemberfirstday);

            out.println("1900" + i + " " + sat + " " + sun + " " + mon + " " + tues + " " + wed + " " + thur + " " + fri);
        }





        out.println(sat + " " + sun + " " + mon + " " + tues + " " + wed + " " + thur +" "+fri);
        out.close();
    }
}

