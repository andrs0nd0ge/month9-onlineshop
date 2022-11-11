insert into products(name, price, qty, image, description, brand_id, category_id)
values
    ('245 mm Front Disc Brakes Brembo', 4000, 2, '-', 'Original 245mm disc brakes from Brembo', 1, 1),
    ('200 mm Rear Disc Brakes Wilwood', 3400, 2, '-', 'Original 200mm disc brakes from Wilwood', 1, 1),
    ('Front Brake Pads Powertech', 1200, 2, '-', '-', 3, 1);

insert into brands(name)
values
    ('Brembo'),
    ('Wilwood'),
    ('Powertech');

insert into categories(name)
values
    ('Brake System Parts'),
    ('Tyres'),
    ('Rims');