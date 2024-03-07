select numberofluggage
from payment_refund
where numberofluggage >= any(select numberofluggage from LUGGAGE_RULE);

select numberofluggage
from LUGGAGE_RULE
where numberofluggage >=  (select numberofluggage from payment_refund where number =1 ) and  numberofluggage <=  (select numberofluggage from payment_refund where number =1 ) ;
