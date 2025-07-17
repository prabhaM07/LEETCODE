with table_ as
(
    select mr.movie_id ,ms.title ,mr.user_id ,u.name,mr.rating,mr.created_at,count(u.user_id) over(partition by u.user_id) as cnt from Movies ms join MovieRating mr on ms.movie_id = mr.movie_id join Users u on u.user_id  = mr.user_id
),
table2 as 
(
    select name,row_number() over(order by cnt desc,name) as rownum1,title,avg(rating) over(partition by movie_id) as avge from table_ where year(created_at) = 2020 and MONTH(created_at) = 2 
),
table3 as 
(
    (SELECT name AS results FROM table2 order by rownum1 LIMIT 1)
    UNION ALL
    (SELECT title AS results FROM table2 order by avge desc,title limit 1)
)
select * from table3;

-- 