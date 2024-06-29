INSERT INTO tb_employee(name, registration, branch) VALUES ('Fabio Leite Morais', '1394', 'BELO_JARDIM');
INSERT INTO tb_employee(name, registration, branch) VALUES ('Xico', '1144', 'BELO_JARDIM');
INSERT INTO tb_employee(name, registration, branch) VALUES ('Zé', '1434', 'BELO_JARDIM');


INSERT INTO tb_meeting(topic, instructor, date) VALUES   ('Resgate em altura', 'Xico', TIMESTAMP WITH TIME ZONE '2024-06-29T07:10:00Z');

INSERT INTO tb_attendance(moment, location, img_url, employee_id, meeting_id) VALUES (TIMESTAMP WITH TIME ZONE '2024-06-29T07:30:28Z', '-8.234567, -36.123445', 'teste', 1, 1);
INSERT INTO tb_attendance(moment, location, img_url, employee_id, meeting_id) VALUES (TIMESTAMP WITH TIME ZONE '2024-06-29T07:30:11Z', '-8.234567, -36.123445', 'teste', 2, 1);
INSERT INTO tb_attendance(moment, location, img_url, employee_id, meeting_id) VALUES (TIMESTAMP WITH TIME ZONE '2024-06-29T07:30:34Z', '-8.234567, -36.123445', 'teste', 3, 1);