> set serveroutput on;
 CREATE OR REPLACE FUNCTION factorial(n NUMBER)
RETURN NUMBER IS
fact NUMBER := 1;
BEGIN
FOR i IN 1..n LOOP
fact := fact * i;
END LOOP;
RETURN fact;
END;
/
Function created.
SQL> SELECT factorial(5) FROM dual;
