CREATE PROCEDURE countriesInfo()
BEGIN
	/* Write your SQL here. Terminate each statement with a semicolon. */
    SELECT count(*) as number, AVG(population) as average, SUM(population) as total
    FROM countries;
END
