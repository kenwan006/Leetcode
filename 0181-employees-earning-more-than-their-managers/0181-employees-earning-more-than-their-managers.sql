# Write your MySQL query statement below
SELECT name AS Employee
FROM Employee AS p1
WHERE p1.salary > (SELECT salary 
                   FROM Employee AS p2 
                   WHERE p1.managerId = p2.id)