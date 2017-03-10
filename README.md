# QueenTerrysSun
QuickSort Lab 

##Big-Oh runtime classification:

###Best Run Time: O( nlog(n) )
In the best case scenario, QuickSort will be using a pivot point that roughly partitions the array being examined in half each time the recursion is called (i.e. if n = the length of the array, then the array will be partitioned into two arrays like so: [n/2 elements], [n/2 elements]. For an array of an odd number length, being partitioned into [n/2 elements], [n/2 + 1 elements] is fine.) This action of repeatedly splitting in half has a run time of approximately O(log(n)), as proved by binary search. The action of selecting a pivot point is linear because the system will only need to transverse the array once to find the appropriate index. Thus, QuickSort will have a run time of O( nlog(n) ). 

###Worst Run Time: O( n^2 ) 
###Average: O( nlog(n) )
