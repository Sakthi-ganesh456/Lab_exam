create table emp(id int, name varchar(10),salary int);
insert into emp values(1,'ram',2000);
insert into emp values(2,'sam',3000);
 declare
 Cursor emp_cur is
 select name,salary from emp;
 vname emp.name%type;
 vsalary emp.salary%type;
 begin
 open emp_cur;
 loop
 fetch emp_cur into vname,vsalary;
 exit when emp_cur%notfound;
 dbms_output.put_line('name'||vname||' '||'salary'||vsalary);
 end loop;
 close emp_cur;
 end;
 /
