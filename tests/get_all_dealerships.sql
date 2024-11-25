SELECT v.*
FROM Vehicles v
JOIN Inventory i ON v.VIN = i.VIN
WHERE i.dealership_id = 1;
