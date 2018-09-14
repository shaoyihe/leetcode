# Write your MySQL query statement below
SELECT
  Request_at                                             Day,
  CAST(if(canceled = 0, 0.0, canceled / total) as DECIMAL(3,2)) AS "Cancellation Rate"
FROM (
       SELECT
         Request_at,
         count(*)                                      total,
         sum(if(Status <> 'completed', 1, 0)) canceled
       FROM Trips a
       WHERE Client_Id NOT IN (
         SELECT Users_Id
         FROM Users
         WHERE Banned = 'Yes'
       ) AND Request_at BETWEEN '2013-10-01' AND '2013-10-03'
       GROUP BY Request_at
     ) a;