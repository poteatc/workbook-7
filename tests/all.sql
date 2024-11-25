SELECT v.*
FROM Vehicles v
JOIN Inventory i ON v.VIN = i.VIN
WHERE i.dealership_id = 1;

-- Replace with the ID of the dealership you want to query
SELECT v.*
FROM Vehicles v
JOIN Inventory i ON v.VIN = i.VIN
WHERE i.dealership_id = 3;

-- Replace with the VIN of the car you want to find
SELECT * 
FROM Vehicles
WHERE VIN = '2T1BURHE0KC123460';

-- Replace  with the VIN of the car you want to locate
SELECT d.*
FROM Dealerships d
JOIN Inventory i ON d.dealership_id = i.dealership_id
WHERE i.VIN = '2T1BURHE0KC123460';

-- Replace make, model, and color with the desired car attributes
SELECT DISTINCT d.*
FROM Dealerships d
JOIN Inventory i ON d.dealership_id = i.dealership_id
JOIN Vehicles v ON i.VIN = v.VIN
WHERE v.make = 'Ford'
  AND v.model = 'Focus'
  AND v.color = 'Red';

-- Replace dealership_id, start_date, and end_date with appropriate values
SELECT sc.*
FROM Sales_Contracts sc
JOIN Inventory i ON sc.VIN = i.VIN
WHERE i.dealership_id = 1
  AND sc.contract_date BETWEEN '2024-08-01' AND '2024-10-31';



