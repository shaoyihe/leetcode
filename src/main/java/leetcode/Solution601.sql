# Write your MySQL query statement below
SELECT
  id,
  date,
  people
FROM (
       SELECT
         if(rank >= 3, @found := TRUE AND @reset := FALSE, 0),
         if(rank >= 3, TRUE, if(@reset, FALSE, TRUE)) AS found,
         if(rank = 1, @reset := TRUE, 0),
         id,
         date,
         people,
         rank
       FROM (
              SELECT
                if(people < 100, @rank := 0, @rank := @rank + 1) AS rank,
                id,
                date,
                people
              FROM (SELECT @rank := 0) a,
                stadium
            ) a,
         (SELECT
            @found := FALSE,
            @reset = TRUE) b
       ORDER BY a.id DESC
     ) a
WHERE a.found = TRUE
ORDER BY a.id