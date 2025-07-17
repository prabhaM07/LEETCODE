with table_ as
(
    select id,student,
        LAG(student) over() as lagi,
        lead(student) over() as leadi
    from seat
)
select id,
    case
        when id%2 = 0 then lagi
        when leadi is null then student
        else leadi 
    end as student
from table_;



-- when id % 2 ==0 then 