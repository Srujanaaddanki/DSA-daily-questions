# Write your MySQL query statement below
SELECT s.name
FROM SalesPerson AS s
LEFT JOIN (
    SELECT DISTINCT o.sales_id
    FROM Orders AS o
    JOIN Company AS c
        ON o.com_id = c.com_id
    WHERE c.name = 'RED'
) AS red_orders
    ON s.sales_id = red_orders.sales_id
WHERE red_orders.sales_id IS NULL;


# i really unable to understand this completely 

