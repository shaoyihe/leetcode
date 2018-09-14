# Write your MySQL query statement below
SELECT distinct num as ConsecutiveNums
from(
      select  case when @pre_num = num then @total := @total + 1 else @total :=1 end total_order,
              @pre_num := num as num
      from (select @total := 0 , @pre_num := null) a , Logs
    )a
WHERE a.total_order =3         