CREATE OR REPLACE FUNCTION pay_bill(basic NUMBER)
RETURN NUMBER IS
hra NUMBER;
da NUMBER;
total NUMBER;
BEGIN
hra := basic * 0.20;
da := basic * 0.10;
total := basic + hra + da;
RETURN total;
END;
/

 select pay_bill(20000) from dual;
