SELECT b.Name Department ,
       a.Name  Employee,
  a.Salary
FROM (
       SELECT if (@pre_departmentId = DepartmentId, if(@pre_salary = Salary , @rank, @rank := @rank + 1 ) , @rank := 1) as rank,
         Id, Name, Salary,
              @pre_departmentId := DepartmentId as DepartmentId,
         @pre_salary := Salary
       from (SELECT @pre_departmentId := NULL, @rank := 0, @pre_salary := NULL) a,
         Employee
       ORDER BY DepartmentId, Salary DESC
     )a
  INNER JOIN Department  b on a.DepartmentId = b.id
where a.rank <= 3