with table_ as
(
    select tiv_2015, count(*) over(partition by tiv_2015) as cnt1,tiv_2016 ,count(*) over(partition by lat ,lon) as cnt2 from Insurance
)
select round(sum(tiv_2016),2) as tiv_2016 from table_ where cnt1 > 1 and cnt2 = 1;