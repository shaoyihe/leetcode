# Write your MySQL query statement below
select *
from(
      select a.id, b.student
      from seat a
        inner join seat b on a.id = b.id + 1
      where a.id % 2 = 0
      union all
      select a.id, ifnull(b.student, a.student) student
      from seat a
        left join seat b on a.id = b.id - 1
      where a.id % 2 = 1
    )a
order by a.id