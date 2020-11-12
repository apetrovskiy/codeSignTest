-- not yet tested

    SELECT sa.actor, aa.age
    FROM starring_actors sa
    JOIN actor_ages aa ON aa.actor = sa.actor
    where sa.movie_name in (select m2.movie from movies m2 join (select m1.genre from movies m1 group by m1.genre order by count(m1.genre) desc limit 1) m3 on m2.genre = m3.genre)
    ORDER BY aa.age DESC;

/*
CREATE PROCEDURE filmLibrary()
BEGIN
	/* Write your SQL here. Terminate each statement with a semicolon. */
    SELECT sa.actor, aa.age
    FROM starring_actors sa
    JOIN actor_ages aa ON aa.actor = sa.actor
    JOIN movies m ON m.movie = sa.movie_name /*AND COUNT(m.genre) = MAX(COUNT(m.genre))*/
    WHERE m.genre IN (SELECT mm.genre FROM movies mm GROUP BY mm.genre HAVING COUNT(mm.genre) ORDER BY COUNT(mm.genre) DESC)
    /*GROUP BY sa.actor, aa.age, m.genre
    HAVING COUNT(m.genre) > 1*/
    ORDER BY aa.age DESC;
END
*/

/*
CREATE PROCEDURE filmLibrary()
BEGIN
	/* Write your SQL here. Terminate each statement with a semicolon. */
    SELECT sa.actor, aa.age
    FROM starring_actors sa
    JOIN actor_ages aa ON aa.actor = sa.actor
    JOIN (SELECT *, row_number() OVER (PARTITION BY COUNT(m2.genre) ORDER BY COUNT(m2.genre) DESC) as row_num FROM movies m2 WHERE row_num = 1) AS m ON m.movie = sa.movie_name /*AND m.row_num = 1*/ /*AND COUNT(m.genre) = MAX(COUNT(m.genre))*/
    /*WHERE m.row_num = 1*/ /*IN (SELECT mm.genre FROM movies mm GROUP BY mm.genre HAVING COUNT(mm.genre) ORDER BY COUNT(mm.genre) DESC)*/
    /*GROUP BY sa.actor, aa.age, m.genre
    HAVING COUNT(m.genre) > 1*/
    ORDER BY aa.age DESC;
END
*/
