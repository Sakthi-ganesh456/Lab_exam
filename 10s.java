CREATE TABLE student_marks (
student_id NUMBER PRIMARY KEY,
student_name VARCHAR2(50),
m1 NUMBER,
m2 NUMBER,
m3 NUMBER
);
INSERT INTO student_marks VALUES (1, 'Rahul', 80, 75, 90);
INSERT INTO student_marks VALUES (2, 'Anita', 65, 70, 60);
COMMIT;
CREATE OR REPLACE PROCEDURE student_result(p_id NUMBER)
IS
total NUMBER;
avg NUMBER;
BEGIN
SELECT (m1+m2+m3), (m1+m2+m3)/3
INTO total, avg
FROM student
WHERE id = p_id;
DBMS_OUTPUT.PUT_LINE('Total = ' || total);
DBMS_OUTPUT.PUT_LINE('Average = ' || avg);
/ END;
SET SERVEROUTPUT ON;
BEGIN
student_result(1);
/ END;
