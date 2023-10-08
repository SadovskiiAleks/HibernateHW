select product_name from orders
join customers ON customers.id = orders.customers_id
where lower(customers.name) = lower(:name);