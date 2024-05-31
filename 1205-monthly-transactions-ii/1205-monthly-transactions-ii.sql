# Write your MySQL query statement below

with tcs as (
    select id, country, state, amount, date_format(trans_date, '%Y-%m') as month
    from transactions
    where state = 'approved'
    
    union all
    
    select trans_id, country, 'chargeback' as state, amount, date_format(c.trans_date, '%Y-%m') as month
    from chargebacks c
    left join transactions t
    on c.trans_id = t.id
)

select month, country,
       sum(case when state='approved' then 1 else 0 end) as approved_count,
       sum(case when state='approved' then amount else 0 end) as approved_amount,
       sum(case when state='chargeback' then 1 else 0 end) as chargeback_count,
       sum(case when state='chargeback' then amount else 0 end) as chargeback_amount
from tcs
group by month, country;