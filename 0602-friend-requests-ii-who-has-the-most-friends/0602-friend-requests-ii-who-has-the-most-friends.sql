with table_ as
(
    select requester_id,accepter_id from RequestAccepted
    union all
    select r1.requester_id,r2.accepter_id from RequestAccepted r1 join RequestAccepted r2 on r1.requester_id  = r2.accepter_id
)
,
table2_ as (
    select requester_id as id,count(*) as num from table_ group by requester_id
)
select id,num from table2_ order by num desc limit 1;