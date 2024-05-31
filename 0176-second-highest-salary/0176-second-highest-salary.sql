# Write your MySQL query statement below



with tmp as (select max(salary) as max_salary from employee)

select max(salary) as SecondHighestSalary 
from employee 
where salary < (select max_salary from tmp);


