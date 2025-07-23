with table_ as
(
   select d.name as Department  , e.name as Employee , e.salary , dense_rank() OVER (PARTITION BY d.name ORDER BY e.salary desc)
 as drank from Employee e join Department d on e.departmentId = d.id
)
select Department ,Employee ,salary  from table_ where drank <= 3;
