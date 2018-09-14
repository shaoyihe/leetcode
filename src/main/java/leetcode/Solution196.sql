# Write your MySQL query statement below
delete from Person
where id not in (
  select id
  from(
        select min(id) as id
        from person
        group by Email
      )a
)