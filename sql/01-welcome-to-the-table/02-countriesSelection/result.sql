CREATE PROCEDURE countriesSelection()
BEGIN
	/* Write your SQL here. Terminate each statement with a semicolon. */
    SELECT * FROM countries
    WHERE continent = 'Africa';
END
