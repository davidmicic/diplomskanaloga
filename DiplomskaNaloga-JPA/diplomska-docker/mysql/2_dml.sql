
insert into diplomskanaloga.vrstastudija (code, vrsta) VALUES ("0", "REDNO");
insert into diplomskanaloga.vrstastudija (code, vrsta) VALUES ("5", "IZREDNO");

insert into diplomskanaloga.zavod (code, zavod) VALUES ("1231", "ŠOLSKI CENTER KRANJ");
insert into diplomskanaloga.zavod (code, zavod) VALUES ("1222", "TEHNIŠKI ŠOLSKI CENTER KRANJ");
insert into diplomskanaloga.zavod (code, zavod) VALUES ("1146", "ESIC");

insert into diplomskanaloga.program (code, vrsta) VALUES ("026", "EKN");
insert into diplomskanaloga.program (code, vrsta) VALUES ("005", "ENE");
insert into diplomskanaloga.program (code, vrsta) VALUES ("019", "INF");
insert into diplomskanaloga.program (code, vrsta) VALUES ("022", "MEH");
insert into diplomskanaloga.program (code, vrsta) VALUES ("025", "OSM");
insert into diplomskanaloga.program (code, vrsta) VALUES ("009", "PS");
insert into diplomskanaloga.program (code, vrsta) VALUES ("035", "VAR");

insert into diplomskanaloga.profesor (imePriimek) VALUES ("Belič Zvonko");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Bogataj Ambrož");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Jarc Kovačič Branka"); 
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Mizerit Leon");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Debeljak Zdravko");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Grilc Boris");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Štular Tomaž");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Pučko Marjeta");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Šink Janko");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Kepic Domen");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Starman Andrej");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Uhan Janko");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Marn Janez");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Beznik Nastja");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Uranič Srečko");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Rehberger Roman");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Balantič Branka");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Canjuga Tomislav");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Humar Iztok");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Simović Srećko");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Vehovec Borut");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Šifrer Robert");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Vehovec Andreja");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Bizant Sašo");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Kurent Primož");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Šubic Marija");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Krajnc Gabrijela");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Javeršek Mirko");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Rakovec Gorazd");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Lončarič Tea");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Kavčič Anton");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Križnar Branko");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Radkovič Robert");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Jerala Franci");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Miklavčič Marjan");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Debeljak Krištof");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Lokar Matija");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Aljaž Tomaž");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Pogačnik Borut");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Jarc Srečko");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Štefe Erna");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Majcen Praprotnik Apolonija"); 
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Kos Dejan");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Grmek Alenka");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Grmek Zupanc Lidija"); 
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Stare Viktor");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Majes Natalija");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Bajželj Jelka");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Povše Helena");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Nagode Branka");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Rakovec Bodnaruk Janja"); 
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Hauptman Gabrijela");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Debeljak Jože");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Rauch Robert");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Zdravje Peter");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Dekleva Janez");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Bizjan Barbara");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Stanojev Sašo");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Pustotnik Nataša");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Grmek Košnik Irena"); 
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Šenk Ileršič Ivanka"); 
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Grünfeld Tanja");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Kovačik Anita");
insert into diplomskanaloga.profesor (imePriimek) VALUES ("Žun Štefan");

INSERT INTO `role`
(id, ime)
VALUES(1, 'add_diploma');
INSERT INTO `role`
(id, ime)
VALUES(2, 'change_diploma');
INSERT INTO `role`
(id, ime)
VALUES(3, 'add_sifrant');
INSERT INTO `role`
(id, ime)
VALUES(4, 'change_sifrant');
INSERT INTO `role`
(id, ime)
VALUES(5, 'add_user');
INSERT INTO `role`
(id, ime)
VALUES(6, 'change_user');

INSERT INTO diplomskanaloga.uporabnik
(username, password)
VALUES('admin', 'admin');


INSERT INTO diplomskanaloga.uporabnik_role
(id, username, id_role)
VALUES(1, 'admin', 1);
INSERT INTO diplomskanaloga.uporabnik_role
(id, username, id_role)
VALUES(2, 'admin', 2);
INSERT INTO diplomskanaloga.uporabnik_role
(id, username, id_role)
VALUES(34, 'admin', 3);
INSERT INTO diplomskanaloga.uporabnik_role
(id, username, id_role)
VALUES(36, 'admin', 5);
INSERT INTO diplomskanaloga.uporabnik_role
(id, username, id_role)
VALUES(37, 'admin', 6);
INSERT INTO diplomskanaloga.uporabnik_role
(id, username, id_role)
VALUES(39, 'admin', 4);

