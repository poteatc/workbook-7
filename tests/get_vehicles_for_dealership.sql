-- Replace with the ID of the dealership you want to query
SELECT v.*
FROM Vehicles v
JOIN Inventory i ON v.VIN = i.VIN
WHERE i.dealership_id = 3;