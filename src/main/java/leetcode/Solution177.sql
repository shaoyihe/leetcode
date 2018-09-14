CREATE FUNCTION getNthHighestSalary(N INT)
       RETURNS INT
       BEGIN
              set @rank = 0;
              RETURN (select *
                      from (select Salary
                            from (select Salary, @rank := @rank + 1 as rank
                                  from (select Salary from Employee group by Salary order by Salary desc)a)a
                            where a.rank = N
                            union
                            select null)a
                      limit 1);
       END;