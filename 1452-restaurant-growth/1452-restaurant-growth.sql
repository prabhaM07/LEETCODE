with table_ as
(
    select distinct visited_on as v,dense_rank() over(order by visited_on) as dr from customer order by visited_on
),
table2_ as
(
    select c.visited_on,v,amount,dr from customer c join table_ t on c.visited_on BETWEEN v - INTERVAL 6 DAY AND v
)
select v as visited_on,sum(amount) as amount, round(sum(amount)/7,2) as average_amount  from table2_ where dr >= 7 group by v order by dr;


