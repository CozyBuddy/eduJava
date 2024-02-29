create table CAR_RENTAL_COMPANY_CAR ( CAR_ID INTEGER,
CAR_TYPE	VARCHAR(255),
DAILY_FEE	INTEGER	,OPTIONS VARCHAR(255)	);

create table CARRENTALCOMPANYRENTALHISTORY( 
HISTORY_ID	INTEGER,
CAR_ID	INTEGER,
START_DATE	DATE,
END_DATE	DATE);

create table CARRENTALCOMPANYDISCOUNTPLAN(
PLAN_ID	INTEGER	,
CAR_TYPE	VARCHAR(255),
DURATION_TYPE	VARCHAR(255),
DISCOUNT_RATE	INTEGER);

substr(c.duration_type,1,instr(duration_type,'일')-1)

select * 
from (select a.car_id,a.car_type
from CAR_RENTAL_COMPANY_CAR a,CAR_RENTAL_COMPANY_RENTAL_HISTORY b,CAR_RENTAL_COMPANY_DISCOUNT_PLAN c 

where a.car_id = b.car_id and a.car_type=c.car_type and 

case when to_char(b.end_date,'DDD') - to_char(b.start_date,'DDD') >=90 then 90 when to_char(b.end_date,'DDD') - to_char(b.start_date,'DDD')  >=30 then 30 when to_char(b.end_date,'DDD') - to_char(b.start_date,'DDD') >=7 then 7 end = (substr(c.duration_type,1,instr(c.duration_type,'일')-1)) and not( b.start_date <= to_date('2022-11-30','yyyy-mm-dd')  and b.end_date >= to_date('2022-11-1','yyyy-mm-dd')) group by a.car_id,a.car_type) a 








select a.car_id,a.car_type,a.daily_fee
from CAR_RENTAL_COMPANY_CAR a,CAR_RENTAL_COMPANY_RENTAL_HISTORY b,CAR_RENTAL_COMPANY_DISCOUNT_PLAN c 

where a.car_id = b.car_id and a.car_type=c.car_type and 

(case when to_char(b.end_date,'DDD') - to_char(b.start_date,'DDD')  >=30 and  to_char(b.end_date,'DDD') - to_char(b.start_date,'DDD')  <90 then 30 end) = (substr(c.duration_type,1,instr(c.duration_type,'일')-1)) and not( b.start_date <= to_date('2022-11-30','yyyy-mm-dd')  and b.end_date >= to_date('2022-11-1','yyyy-mm-dd')) ;