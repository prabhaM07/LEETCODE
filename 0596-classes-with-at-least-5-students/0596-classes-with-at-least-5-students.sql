with table_ as
(
    select class,count(student)as cnt from Courses group by class
)
select class from table_ where cnt >=5;