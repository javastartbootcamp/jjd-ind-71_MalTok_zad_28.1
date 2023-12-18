INSERT INTO category
    (name, description)
VALUES
    ('Elektronika', 'Bardzo fajne przedmioty'),
    ('Moto', 'Samochody, skutery i ciężarówki'),
    ('Meble', 'Stylowe, nowoczesne, 100% drewno'),
    ('Przybory kuchenne', 'Wszystko do gotowania');

INSERT INTO offer
    (title, description, img_url, price, category_id)
VALUES
        ('Telewizor', 'Super telewizor o przekątnej 55 cali', 'http://blabla2.jpg', 1299.0, 1),
        ('Kino domowe', 'Wypasione kino domowe firmy Sony, gra tak, że można robić festyn', 'http://blabla3.jpg', 699.0, 1),
        ('Stół drewniany', 'Idealny stół drewniany dla rodziny, 6 krzeseł gratis', 'http://blabla.jpg', 2699.0, 3),
        ('Daewoo Tico', 'Wieśka Tico', 'http://blabla2.jpg', 1199.0, 2),
        ('Łyżka Nessie', 'Bajerancka łyżka w kształcie potwora z Loch Ness', 'http://blabla4.jpg', 57.0, 4);