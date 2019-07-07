Oracle Step to create Nested Table of custom Data type

Step 1 
CREATE TYPE address_t AS OBJECT (
   city  VARCHAR2(30),
   state    VARCHAR2(20)
   );
Step 2
CREATE TYPE address_tab IS TABLE OF address_t;
Step 3
CREATE TABLE customers (
   id  NUMBER,
   street VARCHAR2(30),
   address address_tab )
NESTED TABLE address STORE AS customer_addresses;

Step 4

INSERT INTO customers VALUES (1,'Velankani',
            address_tab(
              address_t('Bangalore', 'Karnataka'),
              address_t('Mangalore', 'Karnataka')
            )                );
			
Step 5
select c.id, c.street, u.*  from customers c, table (c.address) u