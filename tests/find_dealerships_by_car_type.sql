-- Replace make, model, and color with the desired car attributes
SELECT DISTINCT d.*
FROM Dealerships d
JOIN Inventory i ON d.dealership_id = i.dealership_id
JOIN Vehicles v ON i.VIN = v.VIN
WHERE v.make = 'Ford'
  AND v.model = 'Focus'
  AND v.color = 'Red';