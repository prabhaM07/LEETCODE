with table_ as
(
    select id,email,row_number() OVER (PARTITION BY email order by id) AS row_num from Person
),
table2_ as 
(
    select id from table_ where row_num >1
)
DELETE FROM person
WHERE id IN (SELECT id FROM table2_);