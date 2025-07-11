with table_ as
(
    select product_id ,new_price ,change_date ,
     ROW_NUMBER() OVER (PARTITION BY product_id ORDER BY 
        CASE 
            WHEN change_date <= '2019-08-16' THEN 0 
            ELSE 1 
        END,change_date desc
    ) AS row_num from Products
)
select 
    product_id , case when change_date <= '2019-08-16' then new_price else 10 end as price 
from table_ where row_num = 1;