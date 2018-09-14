select a.Score, cast(a.rank AS UNSIGNED ) as rank
from (
       select case when b.Score = @pre_score then @rank else @rank := @rank + 1 end as rank,
              @pre_score := b.Score                                                 as Score
       from (select @pre_score := null) a,
         (select @rank := 0) c,
         Scores b
       order by b.Score desc
     )a