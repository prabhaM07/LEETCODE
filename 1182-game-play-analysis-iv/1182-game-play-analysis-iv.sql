with table_name as 
(
    select player_id ,event_date ,
    lag(event_date) over(partition by player_id order by event_date) as prev ,row_number() over(partition by    player_id) as rownum from Activity
)
select
    case 
    when count(*) >0 then
    round(sum(
        case
            when datediff(event_date,prev) = 1 then 1
            else 0 
            end
    )   /
(select count(*) from table_name where rownum = 1 ),2) 
else 0
end as fraction  from table_name where rownum = 2 ;

-- player_id,