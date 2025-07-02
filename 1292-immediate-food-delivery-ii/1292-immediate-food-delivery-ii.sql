with table_name as( select customer_id,row_number() over (partition by customer_id order by order_date) as rownum,order_date,customer_pref_delivery_date 
from Delivery)

select 
    round((sum(case
            when order_date  = customer_pref_delivery_date then 1
            else 0
            end
        )/count(*))*100,2) as immediate_percentage 
 from table_name where rownum = 1;

 