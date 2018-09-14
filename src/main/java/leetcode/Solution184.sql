# Write your MySQL query statement below
select b.name as Department , c.Name Employee , a.Salary
from(
      select max(Salary) Salary ,DepartmentId
      from Employee
      group by DepartmentId
    )a
  inner join Employee c on a.Salary = c.Salary and a.DepartmentId = c.DepartmentId
  inner join Department  b on a.DepartmentId = b.id