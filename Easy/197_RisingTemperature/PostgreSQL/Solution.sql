SELECT t1.id
FROM Weather t1
LEFT JOIN Weather t2 ON t1.recordDate = t2.recordDate + INTERVAL '1 day'
WHERE t1.temperature > t2.temperature;