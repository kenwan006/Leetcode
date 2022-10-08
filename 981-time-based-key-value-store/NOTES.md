Method 1: Using Treemap
HashMap<String, TreeMap<Integer, String>>
HashMap<key, TreeMap<timestamp, value>>
​
Method2: binary search
Accoring the the constraint: All the timestamps are strictly increasing.
For the given key, we can use binary seach to get the value at the given timestamp.