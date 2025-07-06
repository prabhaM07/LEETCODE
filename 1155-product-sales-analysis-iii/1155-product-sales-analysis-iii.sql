with table_ as
(
    select product_id,year ,quantity ,price , dense_rank() over(partition by product_id  order by year) as dense from Sales
)
select product_id,year as first_year ,quantity as quantity,price as price  from table_ where dense = 1 ;