with table_ as
(
    select num ,count(*) as cnt from MyNumbers group by num
)
select 
    case
    when count(*) > 0 then max(num)
    else null
    end as num
from table_ where cnt = 1;