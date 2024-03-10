-- while 문 가로 출력
set serveroutput on;
    declare 
    a number :=2;
    b number :=1;
    result varchar2(100);
    begin
    while ( a<=9)
    loop
 
        while ( b<=9)
        loop
        result :=result ||  to_char(a) || '*'||to_char(b)|| '='||to_char(a*b) || ' ' ;
        b:=b+1;
        end loop;
        dbms_output.put_line ( result);
        result := ' ';
        b:=1;
        a:=a+1;
        end loop;
        
    end;
    
-- for 문 구구단 세로 출력
    declare 
   
    begin
    
    for j in 2..9 loop
        for i in 1..9 loop
        dbms_output.put_line( j || '*'|| i || '='|| j*i );
        end loop;
        end loop;
        
    end;
ACCEPT pno PROMPT '카드번호?'
DECLARE
  vno NUMBER:=&pno;
BEGIN

    DBMS_OUTPUT.PUT_LINE (VNO);
    IF vno =1   THEN
    DBMS_OUTPUT.PUT_LINE(' 성공 ' );
    
    ELSE
    DBMS_OUTPUT.PUT_LINE(' 실패 ' );
    END IF;
END;