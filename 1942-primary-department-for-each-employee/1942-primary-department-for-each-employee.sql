with table_ as
(
    select employee_id ,department_id,count(*) over(partition by employee_id ) as cnt,primary_flag from Employee
)
select employee_id ,department_id  from table_ 
WHERE 
    CASE 
        WHEN cnt = 1 THEN primary_flag = 'N'
        ELSE primary_flag = 'Y'
    END;