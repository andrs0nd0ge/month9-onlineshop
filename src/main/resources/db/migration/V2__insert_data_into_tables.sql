insert into online_shop.brands(name)
values
    ('Brembo'),
    ('Wilwood'),
    ('Powertech');

insert into online_shop.categories(name)
values
    ('Brake System Parts'),
    ('Tyres'),
    ('Rims');

insert into online_shop.brands (name) values ('Pirelli');

insert into online_shop.brands (name) values ('Volk Racing');

insert into online_shop.products(name, price, qty, image, description, brand_id, category_id)
values
    ('245 mm Front Disc Brakes Brembo', 40, 2, '81t1woAGIJL._AC_SL1500_.jpg', 'Original 245mm disc brakes from Brembo', 1, 1),
    ('200 mm Rear Disc Brakes Wilwood', 34, 2, 'ford-sierra-drilled-and-grooved-rear-brake-disks-for-wilwood-handbrake-caliper-247mm-pair-001_1.jpg', 'Original 200mm disc brakes from Wilwood', 1, 1),
    ('Front Brake Pads Powertech', 21, 2, 'blue-PV-car-brake-pad-with-blue-color-box.jpg', '-', 3, 1);

insert into online_shop.products (description, image, name, price, qty, brand_id, category_id)
values ('Sport tyres for all conditions: wet and dry', 'pzero-nero-torta-1505470088579.jpg', 'Pirelli P-ZERO NERO GT 245/40R19', 360, 4, 4, 2);

insert into online_shop.products (description, image, name, price, qty, brand_id, category_id)
values ('Be in control of your vehicle', 'gallery-base-side-4505517104947.jpg', 'Pirelli CINTURATO P7 (P7C2) 205/55R170', 340, 4, 4, 2);

insert into online_shop.products (description, image, name, price, qty, brand_id, category_id)
values ('Shining Black, 16" diameter, 5 1/2 J size, 27 mm hub clearance, 100 P.C.D', 'face_02.jpg', 'Volk Racing TE37 KCR Progressive Model', 600, 4, 5, 3);

insert into online_shop.products (description, image, name, price, qty, brand_id, category_id)
values ('Dark Gunmetal, 18" diameter, 10J size, FACE-2 face, 97 mm rim depth, 114.3 P.C.D', '271658308_10158424005675318_5264234742398847577_n.jpg', 'Volk Racing 21A', 620, 4, 5, 3);

insert into online_shop.products (description, image, name, price, qty, brand_id, category_id)
values ('Dark Gunmetal LLL, 18" diameter, 10 1/2 J size, FACE-3 face, 95 mm rim depth, 114.3 P.C.D', 'image_ff9f4d96-f3cd-4838-b776-5aed9bd20cfb_480x480.jpg', 'Volk Racing 21C', 340, 4, 4, 2);