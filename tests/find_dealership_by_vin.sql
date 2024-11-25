-- Replace with the VIN of the car you want to locate
SELECT d.*
FROM Dealerships d
JOIN Inventory i ON d.dealership_id = i.dealership_id
WHERE i.VIN = '2T1BURHE0KC123460';