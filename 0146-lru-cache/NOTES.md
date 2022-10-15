We have two major challenges to solve this problem.
1. When putting new items into the cache, if the cache is already full, we have to remove the least recently used (put/get)
2. Each operation run in O(1).
​
To solve the first challenge, we can always put the most recently used item to the front of a list, so we can just remove the last item in the list when it exceeds the max capacity
​
To solve the second challenge,
*get(key, value)* - use a hashmap to decide whether the key is existing; if no return -1; if yes, return the value and have to move the item to the front of the list, or we can just remove the current item and insert it to the front of the list;
*put(key, value)* - if the key does not exist in the list, then just put the new item to the front of the list; If the key already exists then we have to update its value and move it to the front, or say remove the current item and insert it the front of the list.
​
For both methods we have to run remove() and insert(), but how can we run both of them in O(1) time ?  We can use a **doubly linkedlist**, which includes the prev node and next node, so we can easily remove it and insert.