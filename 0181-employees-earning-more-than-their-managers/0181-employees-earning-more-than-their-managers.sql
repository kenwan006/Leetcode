# Write your MySQL query statement below
SELECT a.name AS Employee
FROM Employee as a
JOIN Employee as b
ON a.managerId = b.id AND a.salary > b.salary