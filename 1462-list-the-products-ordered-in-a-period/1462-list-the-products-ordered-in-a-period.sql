with table_ as
(
    select p.product_id,p.product_name,o.unit from Products p join Orders o on p.product_id  = o.product_id where month(order_date) = '2' and year(order_date) = '2020'
)
select product_name ,sum(unit) as unit from table_ group by product_id ,product_name having sum(unit) >= 100;
