insert into Company(id,name) values (0, 'Company A');
insert into Company(id, name) values (1, 'Company B');
insert into Categorie(id,name) values (0,'Technology');
insert into Categorie(id,name) values (1, 'Car');
insert into Product(id,name, company_id, price, stock) values (0,'Tesla Model 3', 0, 50000.2, 10 );
insert into Product(id,name, company_id, price, stock) values (1,'Phone', 0, 599.99, 50);
insert into Product(id,name, company_id, price, stock) values (2,'Twingo', 1,  2500.5,20);
insert into Categories(product_id, categorie_id) values (0,0);
insert into Categories(product_id, categorie_id) values (0,1);
insert into Categories(product_id, categorie_id) values (1,0);
insert into Categories(product_id, categorie_id) values (2,0);

