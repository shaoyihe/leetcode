# Write your MySQL query statement below

select class
from(
      select class, student
      from courses
      group by class , student
    )a
group by class
having count(*) >= 5
