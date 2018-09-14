# Write your MySQL query statement below
select a.SecondHighestSalary
from (
       select Salary as SecondHighestSalary
       from Employee
       where Employee.Salary< (select max(Salary) from Employee)
       union all
       select null
     )a
order by 1 desc
limit 1