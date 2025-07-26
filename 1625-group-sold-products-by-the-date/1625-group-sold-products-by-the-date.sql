with table_ as
(
    select sell_date , product , count(*) over(partition by sell_date) as cnt from Activities group by sell_date,product
)
select sell_date , cnt as num_sold,GROUP_CONCAT(product ORDER BY product SEPARATOR ',') AS products from table_ group by sell_date  ;
