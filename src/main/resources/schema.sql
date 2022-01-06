drop table if exists classes;
create table classes(
                        c_id int primary key auto_increment,
                        c_number varchar(11),
                        c_name varchar(50),
                        c_status int(1),
                        c_create_user varchar(30),
                        c_create_time datetime,
                        c_operator_user varchar(30),
                        c_operator_time datetime
);

# 插入班级信息
delimiter //
create procedure insert_class()
begin
    declare i int default 1;
    while
            i < 6 do
            insert into classes(c_number,c_name)
            values(CONCAT('CL',YEAR(CURDATE()),DATE_FORMAT(CURDATE(),'%m'),'0','0',i),CONCAT('CLASS',i));
            set i = i+1;
        end while;
end //

#插入学生信息
delimiter //
create procedure insert_student()
begin
    declare i int default 1;
    declare j int default 1;
    while j < 6 do
            while
                    i < 10 do
                    insert into students(s_number, s_name, s_sex, s_birthday, s_address, s_tel, c_id)
                    values(CONCAT('SN',YEAR(CURDATE()),DATE_FORMAT(CURDATE(),'%m'),'0000',i),
                           CONCAT('STU',j,i),
                           case i
                               when 2 then 'M'
                               when 4 then 'M'
                               when 6 then 'M'
                               when 8 then 'M'
                               else 'F'
                               end
                              ,
                           CONCAT('2003-',i,'-',j),
                           CONCAT('No.',j,i,', Haidian District',',Shuangqing Road'),
                           CONCAT('130',j,j,j,i,i,i,i),
                           j
                          );
                    set i = i+1;
                end while;
            set i=1;
            set j=j+1;
        end while;
end //

call insert_student();
select * from students order by s_name;
drop procedure insert_student;

call insert_class();
drop procedure insert_class;

# 插入成绩信息
insert into scores(s_id) select s_id from students;
update scores set sc_chinese=Floor(60+RAND()*41), sc_math=Floor(60+RAND()*41),sc_english=Floor(60+RAND()*41) where sc_status is null;

drop table if exists students;
create table students(
                         s_id int primary key auto_increment,
                         s_number varchar(13),
                         s_name varchar(30),
                         s_sex enum('F', 'M'),
                         s_birthday date,
                         s_address varchar(100),
                         s_tel varchar(20),
                         c_id int,
                         s_status int(1),
                         s_create_user varchar(30),
                         s_create_time datetime,
                         s_operator_user varchar(30),
                         s_operator_time datetime
);

drop table if exists scores;
create table scores(
                       sc_id int primary key ,
                       sc_chinese int,
                       sc_math int,
                       sc_english int,
                       s_id int,
                       sc_status int(1),
                       sc_create_user varchar(30),
                       sc_create_time datetime,
                       sc_operator_user varchar(30),
                       sc_operator_time datetime
);

select avg(sc_chinese) sc,avg(sc_math) sc ,avg(sc_english) sc from scores sc left join students s on sc.s_id = s.s_id left join classes c on s.c_id = c.c_id
group by c.c_id;

select * from scores where sc_chinese between 80 and 89;

select s_number from students order by s_number desc limit 1

insert into students(s_number) values('xxx');