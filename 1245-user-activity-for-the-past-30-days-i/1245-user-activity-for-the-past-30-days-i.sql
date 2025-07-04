with table_ as 
(
    select distinct user_id , activity_date from Activity WHERE activity_date BETWEEN DATE_SUB('2019-07-27', INTERVAL 29 DAY) AND '2019-07-27'
)
select activity_date as day , count(user_id) as active_users  from table_ group by activity_date ;
