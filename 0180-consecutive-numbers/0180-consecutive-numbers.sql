with table_ as
(
    SELECT 
    num, 
    LAG(num, 1) OVER() AS num2, 
    LAG(num, 2) OVER() AS num3
    FROM Logs
)
select 
    distinct num as ConsecutiveNums 
from table_ where num = num2 && num2 = num3;


