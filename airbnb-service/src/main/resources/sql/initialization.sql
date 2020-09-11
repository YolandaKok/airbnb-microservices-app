insert into userdto values(1,'','yolanda');
insert into userdto values(2,'','eleni');

INSERT INTO unit(unit_id,title,description,cancelation_policy,score,image,region) VALUES (1,'Samos Apartments', 'Luxurious Apartments for rent in Vathi','FLEXIBLE',5,null,'Samos');
INSERT INTO unit(unit_id,title,description,cancelation_policy,score,image,region) VALUES (2,'Athens Loft', 'Loft in Koukaki, near Acropolis','MODERATE',5,null,'Athens');
INSERT INTO unit(unit_id,title,description,cancelation_policy,score,image,region) VALUES (3,'Peristeri Apartment', 'Near metro station','FLEXIBLE',3,null,'Peristeri');
INSERT INTO unit(unit_id,title,description,cancelation_policy,score,image,region) VALUES (4,'Kalithea Loft', 'Apartment in Thiseos Avenue','STRICT',4,null,'Athens');
INSERT INTO unit(unit_id,title,description,cancelation_policy,score,image,region) VALUES (5,'Santorini Villa', 'Luxurious Villa in Oia','FLEXIBLE',5,null,'Santorini');

INSERT INTO public.review
(id, "comment", score, unit_id, user_id)
VALUES(1, 'Great house', 4.5, 1, 1);

INSERT INTO public.review
(id, "comment", score, unit_id, user_id)
VALUES(2, 'Ok but far from the city center', 4.0, 2, 1);

INSERT INTO public.review
(id, "comment", score, unit_id, user_id)
VALUES(3, 'Ok but a bit old', 3.5, 3, 1);

INSERT INTO public.review
(id, "comment", score, unit_id, user_id)
VALUES(4, 'The view is amazing', 4.3, 4, 2);

INSERT INTO public.review
(id, "comment", score, unit_id, user_id)
VALUES(5, 'Close to the city centre', 4.8, 5, 2);