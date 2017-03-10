# QueenTerrysSun
QuickSort Lab 

##Big-Oh runtime classification:

###Best Run Time: O( nlog(n) )
In the best case scenario, QuickSort will be using a pivot point that roughly partitions the array being examined in half each time the recursion is called (i.e. if n = the length of the array, then the array will be partitioned into two arrays like so: [n/2 elements], [n/2 elements]. For an array of an odd number length, being partitioned into [n/2 elements], [n/2 + 1 elements] is fine.) This action of repeatedly splitting in half has a run time of approximately O(log(n)), as proven by binary search. The action of selecting a pivot point is linear because the system will only need to traverse the array once to find the appropriate index. Thus, QuickSort will have a run time of O( nlog(n) ). 

###Worst Run Time: O( n^2 )
In the worst case scenario, QuickSort will be using a pivot point that’s either at the very beginning or the very end. Let n be equal to the length of the array being sorted. When such pivot point is used, the resulting arrays after partitioning will consist of [0 elements] or [1 element] and [n-1 elements]. Separating into [0/1] and [n-1] will occur for every element in the array and picking the pivot point has a linear run time (traversing through the array once to find the appropriate index). Thus, the worst case will have a run time of O(n*n) or (n^2). 

###Average Time: O( nlog(n) )
Although quick sort has a worst case of O(n ^ 2), the worst case is obscure enough where it is not statistically significant resulting in an algorithm that typically runs in O(n log n )
