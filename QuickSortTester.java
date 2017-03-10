import java.io.*;
import java.util.*;
public class QuickSortTester {


  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }

    public static double findDuration(int numTimes, int size) {
     double total = 0;
     for (int z = 0; z < numTimes; z++) {
       long start = System.nanoTime();
       int[] arr = buildArray(size, 1000000); //million
       QuickSort.qsort(arr);
       total += System.nanoTime() - start;
       System.out.println( "[2J" );
       System.out.println("[0;0H size: " + size);
       System.out.print("case #: " + z);
     }
     return (total/numTimes)/Math.pow(10, 9); //converts to seconds
   }

    public static void main(String[] args) throws FileNotFoundException {
      int[] dataPoints = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 3721, 4096, 5472, 6700, 8192, 10000, 16384, 20000, 32768, 40000, 50000, 60000, 70000, 80000, 90000,
        100000, 150000, 17500, 200000, 250000, 300000};
      double[] data = new double[dataPoints.length];
      //export as csv
      PrintWriter pw = new PrintWriter(new File("data.csv"));
      String expStr = "Array Size,Time(s)";
      for (int i = 0; i < data.length; i++) {
        data[i] = findDuration(10000, dataPoints[i]);
        expStr += dataPoints[i] + "," + data[i] + "\n";
      }
      System.out.println(Arrays.toString(data));
      System.out.println(expStr);
      pw.write(expStr);
      pw.close();
    }// end main
}
