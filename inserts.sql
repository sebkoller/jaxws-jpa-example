INSERT INTO public.studio (id, countrycode, name, postcode) VALUES (2, 'US', 'Universal Pictures', '91608');
INSERT INTO public.studio (id, countrycode, name, postcode) VALUES (1, 'US', 'Paramount Pictures', '90038');
INSERT INTO public.studio (id, countrycode, name, postcode) VALUES (3, 'US', 'Voltage Pictures', '90048');
INSERT INTO public.studio (id, countrycode, name, postcode) VALUES (4, 'US', 'Lionsgate Films', '90404');
INSERT INTO public.studio (id, countrycode, name, postcode) VALUES (5, 'DE', 'Babelsberg Studio', '14482');
INSERT INTO public.actor (id, birthdate, firstname, lastname, sex) VALUES (1, '1971-01-07', 'Jeremy', 'Renner', 'MALE');
INSERT INTO public.actor (id, birthdate, firstname, lastname, sex) VALUES (2, '1978-09-23', 'Anthony', 'Mackie', 'MALE');
INSERT INTO public.actor (id, birthdate, firstname, lastname, sex) VALUES (3, '1981-06-09', 'Natalie', 'Portman', 'FEMALE');
INSERT INTO public.actor (id, birthdate, firstname, lastname, sex) VALUES (4, '1960-04-04', 'Hugo', 'Weaving', 'MALE');
INSERT INTO public.movie (id, description, genre, length, releaseyear, studio_id, title) VALUES (1, 'During the Iraq War, a Sergeant recently assigned to an army bomb squad is put at odds with his squad mates due to his maverick way of handling his work.', 'THRILLER', 131, 2009, 3, 'The Hurt Locker');
INSERT INTO public.movie (id, description, genre, length, releaseyear, studio_id, title) VALUES (2, 'In a future British tyranny, a shadowy freedom fighter, known only by the alias of "V", plots to overthrow it with the help of a young woman.', 'ACTION', 132, 2006, 5, 'V for Vendetta');
INSERT INTO public.movie_cast (movies_id, actors_id) VALUES (1, 1);
INSERT INTO public.movie_cast (movies_id, actors_id) VALUES (1, 2);
INSERT INTO public.movie_cast (movies_id, actors_id) VALUES (2, 3);
INSERT INTO public.movie_cast (movies_id, actors_id) VALUES (2, 4);