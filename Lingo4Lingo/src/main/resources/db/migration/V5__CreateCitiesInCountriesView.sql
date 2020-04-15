CREATE OR REPLACE VIEW cities_in_countries AS
SELECT country_name, city_name
FROM countries JOIN cities USING (country_code);
