INSERT INTO public.studio (country_code, name, post_code) VALUES ('US', 'Universal Pictures', '91608');
INSERT INTO public.studio (country_code, name, post_code) VALUES ('US', 'Paramount Pictures', '90038');
INSERT INTO public.studio (country_code, name, post_code) VALUES ('US', 'Voltage Pictures', '90048');
INSERT INTO public.studio (country_code, name, post_code) VALUES ('US', 'Lionsgate Films', '90404');
INSERT INTO public.studio (country_code, name, post_code) VALUES ('DE', 'Babelsberg studio', '14482');
INSERT INTO public.actor (birthdate, first_name, last_name, gender) VALUES ('1971-01-07', 'Jeremy', 'Renner', 'MALE');
INSERT INTO public.actor (birthdate, first_name, last_name, gender) VALUES ('1978-09-23', 'Anthony', 'Mackie', 'MALE');
INSERT INTO public.actor (birthdate, first_name, last_name, gender) VALUES ('1981-06-09', 'Natalie', 'Portman', 'FEMALE');
INSERT INTO public.actor (birthdate, first_name, last_name, gender) VALUES ('1960-04-04', 'Hugo', 'Weaving', 'MALE');
INSERT INTO public.movie (description, genre, length, release_year, studio_id, title) VALUES ('During the Iraq War, a Sergeant recently assigned to an army bomb squad is put at odds with his squad mates due to his maverick way of handling his work.', 'THRILLER', 131, 2009, 3, 'The Hurt Locker');
INSERT INTO public.movie (description, genre, length, release_year, studio_id, title) VALUES ('In a future British tyranny, a shadowy freedom fighter, known only by the alias of "V", plots to overthrow it with the help of a young woman.', 'ACTION', 132, 2006, 5, 'V for Vendetta');
INSERT INTO public.movie_cast (movies_id, actors_id) VALUES (1, 1);
INSERT INTO public.movie_cast (movies_id, actors_id) VALUES (1, 2);
INSERT INTO public.movie_cast (movies_id, actors_id) VALUES (2, 3);
INSERT INTO public.movie_cast (movies_id, actors_id) VALUES (2, 4);

-- Inserts for movies.xml import
INSERT INTO public.studio (name, country_code, post_code) VALUES ('Working Title Films', 'UK', 'W1U 4AN');
INSERT INTO public.actor (first_name, last_name, gender, birthdate) VALUES ('Jeff', 'Bridges', 'MALE', '1949-12-04');
INSERT INTO public.actor (first_name, last_name, gender, birthdate) VALUES ('John', 'Goodman', 'MALE', '1952-06-20');
INSERT INTO public.actor (first_name, last_name, gender, birthdate) VALUES ('Julianne', 'Moore', 'FEMALE', '1960-12-03');
