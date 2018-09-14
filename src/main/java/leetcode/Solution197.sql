# Write your MySQL query statement below
select Id
from Weather a
where exists (
    select 1
    from Weather b
    where a.RecordDate - INTERVAL 1 DAY = b.RecordDate and a.Temperature > b.Temperature
)