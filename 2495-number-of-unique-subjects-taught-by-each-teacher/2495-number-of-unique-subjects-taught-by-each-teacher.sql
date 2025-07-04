with table_ as 
(
    select distinct subject_id as sub,teacher_id from Teacher
)
select teacher_id ,count(*) as cnt from table_ group by teacher_id ;