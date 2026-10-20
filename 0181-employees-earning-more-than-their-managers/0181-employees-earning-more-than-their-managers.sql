# Write your MySQL query statement below
select e1.name as Employee
from Employee as e1
join Employee as e2
on e1.managerId = e2.id
where e1.salary > e2.salary;

-- line 5  ==> means: find the manager whose ID matches the employee's managerId.