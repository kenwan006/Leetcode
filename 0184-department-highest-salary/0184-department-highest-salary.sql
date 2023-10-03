# Write your MySQL query statement below
select 
    d.name as Department, 
    e.name as Employee, 
    e.salary as Salary
from 
    Employee e,
    Department d,
    (select departmentId, max(salary) as salary 
     from Employee
     group by departmentId) t
where e.departmentId = d.id and 
      d.id = t.departmentId and 
      e.salary = t.salary
      
      