with table_ as
(
   select person_name ,weight , SUM(weight) OVER (
    ORDER BY turn
    ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW
    ) as total from Queue
)
select person_name  from table_ where total<=1000 order by total desc limit 1;