/** Iteration
* Fisrt define a reverse function to reverse all nodes between start and end exclusively
-reverse(start, end), it returns the tail node of the reversed list
* Iterate through the original list, and count the nodes walked by, once count % k == 0, then run reveser(start, end)
* eg: -1(dummy) -> 1 -> 2 ->3 ->4 -> 5 -> 6, k = 3, start = -1, ptr = 1, when count == 3, ptr walks to 4, and reverse nodes between -1 and 4, run reverse(-1, 4) we get new start = 1, and the new list is: -1(dummy) -> 3 -> 2-> 1(new start)-> 4 -> 5 -> 6
*/