- Topological Sorting - check if it's a DAG (directed acyclic graph)..
(https://en.wikipedia.org/wiki/Topological_sorting#:~:text=In%20computer%20science%2C%20a%20topological,before%20v%20in%20the%20ordering)
​
- If the finally sorted elements include all vertex then there is no cycle in the graph. Say there are 6 nodes, 1, 2, 3, 4, 5, 6, but after topological sorting the sorted array only includes 1,2 ,3 then we say there must be a cycle in the graph.
​
/** BFS Topological sorting !
* Find all vertices with 0 indgree, and add them all to a queue;
* Pop out a vertice each time, add this vertice to the result, and decrease the indgree of all its neighboring vertices by one. If any neighboring vertice will have 0 indgree, then add it to the queue.
* Do the last step until there is no vertice left in the queue;
* If the result includes all then coureses, which means there is no cycle in the graph, and thus all courses can be scheduled.
*/
​