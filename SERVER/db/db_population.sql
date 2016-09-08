INSERT INTO pm_to_portfolio
VALUES (33,1);

INSERT INTO pm_to_portfolio
VALUES (35,2);

INSERT INTO pm_to_portfolio
VALUES (35,3);

INSERT INTO pm_to_portfolio
VALUES (39,3);


INSERT INTO pm_order
VALUES (0,33,32);

INSERT INTO pm_order
VALUES (0,33,36);

INSERT INTO pm_order
VALUES (0,35,37);

INSERT INTO pm_order
VALUES (0,35,38);

INSERT INTO pm_order
VALUES (0,39,37);

INSERT INTO pm_order
VALUES (0,39,32);


INSERT INTO trader_block(block_id, t_id, b_id, symbol, quantity, order_type, price_executed, status)
VALUES(0, 32, 2, "DELL", 100, "Market", 0, "Pending");
INSERT INTO trader_block(block_id, t_id, b_id, symbol, quantity, order_type, price_executed, status) 
VALUES(0, 36, 3, "DELL", 100, "Market", 0, "Pending");
INSERT INTO trader_block(block_id, t_id, b_id, symbol, quantity, order_type, price_executed, status) 
VALUES(0, 37, 1, "AAPL", 100, "Market", 0, "Pending");
INSERT INTO trader_block(block_id, t_id, b_id, symbol, quantity, order_type, price_executed, status) 
VALUES(0, 38, 2, "AAPL", 100, "Market", 0, "Pending");
INSERT INTO trader_block(block_id, t_id, b_id, symbol, quantity, order_type, price_executed, status) 
VALUES(0, 37, 3, "SKODA", 100, "Market", 0, "Pending");
INSERT INTO trader_block(block_id, t_id, b_id, symbol, quantity, order_type, price_executed, status) 
VALUES(0, 32, 1, "SKODA", 100, "Market", 0, "Pending");

INSERT INTO single_order(sorder_id,p_id,order_id,block_id,symbol,quantity,action_type,order_type,account_type,stock_exchange,price_stop,price_limit,price_executed,status)
VALUES(0, 3, 5, 4, "SKODA", 250, "Buy", "Market", "credit", "lse", 0, 0, 0, "Executed" );
INSERT INTO single_order(sorder_id,p_id,order_id,block_id,symbol,quantity,action_type,order_type,account_type,stock_exchange,price_stop,price_limit,price_executed,status)
VALUES(0, 3, 5, 3, "AAPL", 150, "Sell", "Market", "credit", "nyse", 0, 0, 0, "Executed");
INSERT INTO single_order(sorder_id,p_id,order_id,block_id,symbol,quantity,action_type,order_type,account_type,stock_exchange,price_stop,price_limit,price_executed,status)
VALUES(0, 1, 6, 4, "AAPL", 150, "Sell", "Market", "credit", "nyse", 0, 0, 0, "Executed");



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
SELECT s.*, p.assigned_to
FROM single_order s
INNER JOIN pm_order p
ON s.order_id = p.order_id 
WHERE p.pm_id = (SELECT u_id FROM user WHERE username= "oriol")
ORDER BY s.sorder_id;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
This code looks for all the orders placed by a particular pm using his PM_ID.

//////////////////////////////////////////////////////////////////////


For Buy EOD:
/////////////////////////////////////////////////////////////////////////////////////////////////

SELECT single_order.p_id, single_order.symbol, single_order.quantity, single_order.price_executed 
FROM single_order
RIGHT JOIN pm_order
ON single_order.order_id = pm_order.order_id 
WHERE pm_order.pm_id = (SELECT u_id FROM user WHERE username= "pm2")
AND single_order.action_type="Buy" 
AND single_order.status="Executed"
AND CAST(single_order.date_pmorder AS DATE) = CURDATE();

/////////////////////////////////////////////////////////////////////////////////////////////////

For Sell EOD:
/////////////////////////////////////////////////////////////////////////////////////////////////
SELECT single_order.p_id, single_order.symbol, single_order.quantity, single_order.price_executed 
FROM single_order
RIGHT JOIN pm_order
ON single_order.order_id = pm_order.order_id 
WHERE pm_order.pm_id = (SELECT u_id FROM user WHERE username= "pm2")
AND single_order.action_type="Sell" 
AND single_order.status="Executed"
AND CAST(single_order.date_pmorder AS DATE) = CURDATE();
//////////////////////////////////////////////////////////////////////////////////////////////////



create table IF NOT EXISTS temp_link (
   uid varchar(32) not null,
   block_id BIGINT not null,
   PRIMARY KEY  (block_id),
   FOREIGN KEY (block_id) REFERENCES trader_block(block_id)
);

Insert into temp_link values("1234", 3);
Insert into temp_link values("qwer", 4);


SELECT s.* FROM single_order s INNER join pm_order o ON o.order_id = s.order_id WHERE date_bexecuted = (DATE_ADD(CURDATE(), INTERVAL 0 DAY)) and o.pm_id = (SELECT u_id FROM user WHERE username = "oriol" )




