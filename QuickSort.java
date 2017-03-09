/*
Terry Guan
APCS2 PD3
HW#15 Quick sort
2017-03-09
*/
/*****************************************************
* class QuickSort
* (skeleton) <<delete this line if untrue>>
* Implements quicksort algo to sort an array of ints in place
*
* 1. Summary of QuickSort algorithm:
* QSort(arr):
* The algorithm first partitions the array into three parts relative to a given point c:
  c, values less than c, and values greater than c. C is guranteed to be at its resting position while all other
  values are guranteed to be in the correct partitions. The algo continues by further splitting the partitions that are
  less than and greater than and sorting them relative another point. The algo continues splitting the array into smaller
  partitions until the partitions can no longer be splitted further (until the upper bound is greater than the lower bound
  which results in there being no possible way to split the partition).
* 2a. Worst pivot choice / array state and associated runtime:
* The worst pivot choices are the most left and most right index. When the array is already sorted, having the right
index will result in a runtime of O(n^2) because the array will be split into partitions in such a way that the
algo will go through every element in the array. If the array is reverse sorted and the left most index is the pivot it will
also result in a O(n^2) because of the same reason stated above for right indexes. This is a result of the array already being sorted
either right to left or left to right. As the array is passed in both the situations, the starting pivot is already larger than the other numbers
which results in the partitions remaining the same as before the algo made one pass. This means that the next pivot point is the next number and this
choosing of the next pivot repeats until all elements have become the pivot resulting in a runtime of O(n^2).
* 2b. Best pivot choice / array state and associated runtime:
* The best choice for the algo is middle element of the lower and upper bound. The array arrangement does not matter because the
algo should always be splitting each range into halves repeatedly until it cannot be split anymore.
* 3. Approach to handling duplicate values in array:
* By using the best pivot choice, the handling of duplicate values is done. This is because each consecutive halving and sorting will
force the duplicate into its final resting place.
*****************************************************/

/***
PROTIP: Assume no duplicates during initial development phase.
Once you have a working implementation, test against arrays
with duplicate values, and revise if necessary. (Backup first.)
***/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a ) {
    for ( int o : a )
    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------



  /*****************************************************
  * void qsort(int[])
  * @param d -- array of ints to be sorted in place
  *****************************************************/
  public static void qsort( int[] d ) {
    qsortH(d, 0, d.length - 1);
  }

  public static void qsortH(int[] arr, int start, int end) {
    if (start > end)
      return;
    else {
      int currentPivot = partition(arr, start, end, (start + end)/2);
      // System.out.println("pivot: " + currentPivot);
      qsortH(arr, start, currentPivot - 1);
      qsortH(arr, currentPivot + 1, end);
    }
  }
  // Thinkers are encouraged to roll their own subroutines.
  // Insert your auxiliary helper methods here.

  public static int partition(int[] arr, int start, int end, int comp) {
    int v = arr[comp];
    //swap
    //switches the end num with the comp num essentially setting the the num as the last number
    // in range (a, c)
    arr[comp] = arr[end];
    arr[end] = v;
    int s  = start;
    for (int i = start; i < end; i++) {
      if (arr[i] < v) {
        //swap
        int d = arr[s];
        arr[s] = arr[i];
        arr[i] = d;
        s++;
      }
    }
    //swap that places the num at index comp with the least number that is greater than comp
    //resulting in numbers larger than comp being after comp and numbers less than it being before comp
    int z = arr[s];
    arr[s] = arr[end];
    arr[end] = z;
    return s;
  }

  //main method for testing
  public static void main( String[] args )
  {

    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/



    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
