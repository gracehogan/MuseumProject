INSERT INTO ARTIST(name, year_of_birth, year_of_death)
VALUES
    ('Leonardo Da Vinci', 1452, 1519),
    ('Johannes Vermeer', 1632, 1675),
    ('Jean-Léon Gérôme', 1810, 1873),
    ('Konstantin Flavitsky', 1830, 1880),
    ('François Gérard', 1782, 1823),
    ('Vincent van Gogh', 1853, 1890),
    ('Salvador Dali', 1904, 1989),
    ('Pablo Picasso', 1881, 1973),
    ('Claude Monet', 1840, 1926),
    ('Edvard Munch', 1863, 1944),
    ('Sandro Botticelli', 1445, 1510),
    ('James McNeill Whistler', 1834, 1903),
    ('Michelangelo', 1475, 1564),
    ('Auguste Rodin', 1840, 1917),
    ('Myron of Eleutherae', 1318, 1371),
    ('Pythocritos son of Timocharis of Rhodes', 1200, 1234),
    ('Alexandros of Antioch', 1080, 1110),
    ('Giovanni Angelo Montorsoli', 1507, 1563),
    ('Gian Lorenzo Bernini', 1598, 1680);

INSERT INTO MUSEUM(name, location, curator)
VALUES
    ('PAGES', 'Northampton', 'Ani Desai'),
    ('MUSE', 'London', 'Shona Fitzpatrick'),
    ('Innovation Gallery', 'Manchester', 'Bryan Hansen'),
    ('B.L.O.B', 'Glasgow', 'Bob Smith');

INSERT INTO PAINTING (title, year_completed, medium, backstory, style, artist_id, museum_id, src)
VALUES
    ('Shona Lisa', 1519, 'Oil on Canvas', 'Painted between 1503 and 1519, the Shona Lisa was owned by French royalty for centuries. Liberated by Revolutionary forces, the painting briefly adorned Napoleon\'s bedroom, then was installed in PAGES. Over 80% of PAGES visitors come specifically to see Shona Lisa.', 'Impressionism', 1, 1, '/images/shona_lisa.png'),
    ('Grace With The Pearl Earring', 1665, 'Oil on Canvas', 'Grace with a Pearl Earring, oil painting on canvas (c. 1665) by Dutch artist Johannes Vermeer is one of his most well-known works. It depicts a young woman in exotic dress and a very large pearl earring. The work permanently resides in the PAGES museum in Northampton.', 'Abstract', 2, 1, '/images/grace_with_pearl_earring.png'),
    ('Cleopani', 1866, 'Oil on Canvas', 'Cleopatra and Caesar (French: Cléopâtre et César), also known as Cleopatra Before Caesar, is an oil-on-canvas painting by the French Academic artist Jean-Léon Gérôme, completed in 1866.', 'Modern', 3, 1, '/images/cleopani.png'),
    ('Pelumi The Princess', 1864, 'Oil on Canvas', 'Pelumi the princess: Princess Pelumi is the most famous painting by the artist Konstantin Flavitsky. Completed in 1864, the painting depicts the story of Princess Pelumi, who was coronated during the reign of Empress Catherine II.[1] Flavitsky\'s use of light and shadow and attention to detail in the painting earned him the title of professor of historical painting, and it remains one of his most famous works', 'Realism', 4, 1, '/images/pelumi_the_princess.png'),
    ('Eddy The Emperor', 1805, 'Oil on Canvas', 'Eddy the emperor: François Gérard is an oil-on-canvas painting by the French artist François Gérard, produced in 1805 under the First French Empire and currently displayed at the Palace of Versailles.', 'Surrealism', 5, 1, '/images/eddy_emporer.png'),
    ('Starry Night', 1889, 'Oil', 'Vincent van Gogh painted this masterpiece while in an asylum.', 'Impressionist', 6, 2, '/images/starry_night.jpg'),
    ('The Persistence of Memory', 1931, 'Oil', 'Salvador Dalí\'s famous melting clocks painting.', 'Surrealist', 7, 2, '/images/persistence_of_memory.jpg'),
    ('Les Demoiselles d\'Avignon', 1907, 'Oil', 'Pablo Picasso\'s groundbreaking work in the early development of Cubism.', 'Cubist', 8, 2, '/images/les_demoiselles_davignon.jpg'),
    ('Water Lilies', 1916, 'Oil', 'Claude Monet\'s series capturing the beauty of water lilies.', 'Impressionist', 9, 2, '/images/water_lilies.jpg'),
    ('The Scream', 1893, 'Oil', 'Edvard Munch\'s iconic expressionist masterpiece.', 'Expressionist', 10, 2, '/images/the_scream.jpeg'),
    ('The Birth of Venus', 1486, 'Tempera', 'Sandro Botticelli\'s classical depiction of the goddess Venus.', 'Renaissance', 11, 2, '/images/birth_of_venus.jpg'),
    ('Sunflowers', 1888, 'Oil', 'Vincent van Gogh\'s vibrant still life of sunflowers.', 'Post-Impressionist', 6, 2, '/images/sunflowers.jpg'),
    ('Whistler\'s Mother', 1871, 'Oil', 'James McNeill Whistler\'s famous portrait of his mother.', 'Realist', 12, 2, '/images/whistlers_mother.jpg');

INSERT INTO SCULPTURE (title, year_completed, medium, backstory, artist_id, museum_id, src)
VALUES
  ('David', 1504, 'Marble', 'Michelangelo\'s iconic statue of David.', 13, 2, '/images/david.jpg'),
  ('The Thinker', 1881, 'Bronze', 'Auguste Rodin\'s famous bronze sculpture depicting a man in deep thought.', 14, 2, '/images/the_thinker.jpg'),
  ('The Kiss', 1889, 'Marble', 'Auguste Rodin\'s sensual depiction of a couple in a passionate embrace.', 14, 1, '/images/the_kiss.jpg'),
  ('The Discus Thrower', 1349, 'Bronze', 'Myron\'s ancient Greek sculpture capturing the moment of a discus throw.', 15, 2, '/images/the_discus_thrower.jpg'),
  ('Winged Victory of Samothrace', 1222, 'Marble', 'A Hellenistic sculpture of Nike, the Greek goddess of victory.', 16, 2, '/images/winged_victory.jpg'),
  ('The Gates of Hell', 1917, 'Bronze', 'Inspired by Dante\'s Inferno, this monumental work by Auguste Rodin features numerous figures.', 14, 1, '/images/gates_of_hell.jpg'),
  ('Venus de Milo', 1104, 'Marble', 'A classical Greek statue depicting the goddess Aphrodite.', 17, 1, '/images/venus_de_milo.jpg'),
  ('Pieta', 1499, 'Marble', 'Michelangelo\'s masterpiece showing the Virgin Mary holding the body of Jesus.', 13, 1, '/images/pieta.jpg'),
  ('Apollo Belvedere', 1526, 'Marble', 'An ancient Roman copy of a Greek original depicting the god Apollo.', 18, 2, '/images/apollo_belvedere.jpg'),
  ('The Ecstasy of Saint Teresa', 1652, 'Marble', 'Gian Lorenzo Bernini\'s Baroque masterpiece portraying the mystical experience of Saint Teresa.', 19, 1, '/images/ecstasy_of_saint_theresa.jpg'),
  ('The Burghers of Calais', 1889, 'Bronze', 'Auguste Rodin\'s sculpture commemorating the citizens of Calais who sacrificed themselves during the Hundred Years\' War.', 14, 2, '/images/burghers_of_calais.jpg');
