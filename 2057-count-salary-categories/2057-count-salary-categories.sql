with table1_ as(
    select 'Low Salary' AS category
    UNION ALL
    select 'Average Salary'
    UNION ALL
    select 'High Salary'
),

table2_ as (
select 
    case
        when income<20000 then 'Low Salary'
        when income >= 20000 and income <= 50000 then 'Average Salary'
        else 'High Salary'
    end as category
    from Accounts
) 
select t1.category ,
case
    when t2.category is null then 0
    else count(*)
end as accounts_count 
from table1_ t1 left join table2_ t2 on t1.category = t2.category group by t1.category;

