import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

class Pair
{
    int row;
    int column;

    Pair(int r, int c) {
        row = r;
        column = c;
    }
}

class Main
{
    final static int rowCount = 7, columnCount = 8;
    static void FFill(char map[][], int row, int column) {

        Queue<Pair> floodQueue = new ArrayDeque<>();

        Pair pair = new Pair(row, column);
        floodQueue.add(pair);
        colored[row][column] = true;

        while(!floodQueue.isEmpty()) {
            Pair newPair = floodQueue.poll();

            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    if (i == 0 && j == 0) continue;

                    int targetRow = newPair.row + i;
                    int targetColumn = newPair.column + j;
                    char element = map[targetRow][targetColumn];

                    if (targetRow < 0 || targetRow >= rowCount || targetColumn < 0 || targetColumn >= columnCount) continue;


                    if (element == '·' && !colored[targetRow][targetColumn]) {
                        newPair = new Pair(targetRow, targetColumn);
                        floodQueue.add(newPair);
                        colored[targetRow][targetColumn] = true;
                    }
                }
            }
        }

    }

    static boolean[][] colored;

    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("f.in"));

        char[][] map = new char[rowCount][columnCount];
        colored = new boolean[rowCount][columnCount];



        for (int r = 0; r < rowCount; ++r) {
            String str = f.readLine();

            for (int c = 0; c < columnCount; ++c) {
                map[r][c] = str.charAt(c);
            }
        }

        //
        int totalRoom = 0;
        for (int r = 0; r < rowCount; ++r) {
            for (int c = 0; c < columnCount; ++c) {
                char element = map[r][c];

                if (element == '·' && !colored[r][c]) {
                    FFill(map, r, c);
                    totalRoom++;
                }
            }
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("f.out")));

System.out.print(totalRoom);
        out.close();

    }
}