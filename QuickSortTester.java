public class QuickSortTester {


  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }

    public double findDuration(int numTimes, int size) {
     double total = 0;
    //  System.out.print("[0;0H");
     for (int z = 0; z < numTimes; z++) {
       long start = System.nanoTime();
       int[] arr = buildArray(size, (int) (Math.exp(10, 6)) );  
       qsort(arr);
       total += System.nanoTime() - start;
       System.out.println( "[2J" );
       System.out.print("case #: " + z);
     }
     return total/numTimes;
   }
    
}

