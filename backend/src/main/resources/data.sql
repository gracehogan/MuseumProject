INSERT INTO ARTIST( name, year_of_birth, year_of_death )
VALUES
    ('Leonardo Da Vinci', 1452, 1519),
    ('Johannes Vermeer', 1632, 1675),
    ('Jean-Léon Gérôme', 1810, 1873),
    ('Konstantin Flavitsky', 1830, 1880),
    ('François Gérard', 1782, 1823);

INSERT INTO MUSEUM( name, location, curator)
VALUES
    ( 'PAGES', 'Northampton', 'Ani'),
    ( 'MUSE', 'London', 'Shona');


INSERT INTO PAINTING (title, year_completed, medium, backstory, style,artist_id,museum_id)
VALUES
    ('Shona Lisa', 1519, 'Oil on Canvas', 'Painted between 1503 and 1519, the Shona Lisa was owned by French royalty for centuries. Liberated by Revolutionary forces, the painting briefly adorned Napoleon\'s bedroom, then was installed in PAGES. Over 80% of PAGES visitors come specifically to see Shona Lisa.', 'Impressionism', 1, 1),
    ('Grace With The Pearl Earring', 1665, 'Oil on Canvas', 'Grace with a Pearl Earring, oil painting on canvas (c. 1665) by Dutch artist Johannes Vermeer is one of his most well-known works. It depicts a young woman in exotic dress and a very large pearl earring. The work permanently resides in the MUSE museum in London.', 'Abstract', 2, 1),
    ('Cleopani', 1866, 'Oil on Canvas', 'Cleopatra and Caesar (French: Cléopâtre et César), also known as Cleopatra Before Caesar, is an oil-on-canvas painting by the French Academic artist Jean-Léon Gérôme, completed in 1866.', 'Modern', 3, 1),
    ('Pelumi The Princess', 1864, 'Oil on Canvas', 'Pelumi the princess: Princess Pelumi is the most famous painting by the artist Konstantin Flavitsky. Completed in 1864, the painting depicts the story of Princess Pelumi, who was coronated during the reign of Empress Catherine II.[1] Flavitsky\'s use of light and shadow and attention to detail in the painting earned him the title of professor of historical painting, and it remains one of his most famous works', 'Realism', 4, 1),
    ('Eddy The Emperor', 1805, 'Oil on Canvas', 'Eddy the emperor: François Gérard is an oil-on-canvas painting by the French artist François Gérard, produced in 1805 under the First French Empire and currently displayed at the Palace of Versailles.', 'Surrealism', 5, 1);

INSERT INTO SCULPTURE (title, year_completed, medium, backstory, artist_id,museum_id)
VALUES
    ('Abstract Form', 2021, 'Stone', 'Expressing movement', 1, 1),
    ('Bronze Elegance', 2023, 'Bronze', 'Classic beauty', 2, 2),
    ('Wooden Harmony', 2019, 'Wood', 'Nature-inspired design', 3, 1),
    ('Sculpture of Emotions', 2022, 'Marble', 'Exploring feelings', 1, 2),
    ('Surreal Sculpture', 2018, 'Mixed Media', 'Imaginary concepts', 2, 1),
    ('Steel Abstract', 2024, 'Steel', 'Dynamic composition', 3, 2),
    ('Figurative Sculpture', 2017, 'Bronze', 'Human form celebration', 1, 1),
    ('Contemporary Carving', 2020, 'Wood', 'Contemporary design', 2, 2),
    ('Cubist Expression', 2016, 'Stone', 'Cubist influence', 3, 1),
    ('Family Bonds', 2020, 'Clay', 'Connection representation', 1, 2);




-- booking visits
-- create account & send mail
-- view painting info