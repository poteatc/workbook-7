-- Replace dealership_id, start_date, and end_date with appropriate values
SELECT sc.*
FROM Sales_Contracts sc
JOIN Inventory i ON sc.VIN = i.VIN
WHERE i.dealership_id = 1
  AND sc.contract_date BETWEEN '2024-08-01' AND '2024-10-31';