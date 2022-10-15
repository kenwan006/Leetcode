/** Topological Sorting
(Origianl idea: for each vertex, set it as the root and calculate the corresponding height. Then find  those with min height. This would fail due to time limit exception).
- Basics: a tree graph can't have more than 2 minimum height trees(MHTs)
- keep trimming the leaves unital there are 1 or 2 vertics left
*/