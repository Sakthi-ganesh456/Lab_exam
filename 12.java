CREATE OR REPLACE TRIGGER student_trigger
BEFORE INSERT ON student
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('New student record inserted');
END;
/
 INSERT INTO student VALUES (1, 'John', 20);
