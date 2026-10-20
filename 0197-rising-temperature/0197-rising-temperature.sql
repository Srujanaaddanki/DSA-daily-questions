# Write your MySQL query statement below
select w1.id as Id
from Weather as w1
join Weather as w2
on DATEDIFF(w1.recordDate , w2.recordDate) = 1
where w1.temperature > w2.temperature;
-- A self-join is useful when you need to compare one row with another row in the same table.
