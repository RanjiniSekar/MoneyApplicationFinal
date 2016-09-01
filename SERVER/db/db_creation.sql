-- Broker
create table broker (
   b_id BIGINT not null AUTO_INCREMENT,
   name VARCHAR (8) not null,
   email VARCHAR (254) not null,
   PRIMARY KEY (b_id)
);

-- User-related information

create table user (
   u_id BIGINT not null AUTO_INCREMENT,
   username VARCHAR (8) not null,
   password VARCHAR (64) not null,
   PRIMARY KEY (u_id)
);

-- Portfolio Manager

create table portfolio_manager (
   pm_id BIGINT not null,
   PRIMARY KEY  (pm_id),
   FOREIGN KEY (pm_id) REFERENCES user(u_id)
);

-- Portfolio

create table portfolio (
   p_id BIGINT AUTO_INCREMENT
);

-- Trader 

create table trader (
   t_id BIGINT not null,
   PRIMARY KEY  (t_id)
);


-- Portfolio Managers portfolios

create table pm_to_portfolio (
   pm_id BIGINT not null,
   p_id BIGINT not null,
   PRIMARY KEY  (pm_id, p_id),
   FOREIGN KEY (pm_id) REFERENCES portfolio_manager(pm_id),
   FOREIGN KEY (p_id) REFERENCES portfolio(p_id)
);

-- Trade related operations

create table trade_block (
   block_id BIGINT not null AUTO_INCREMENT,
   symbol VARCHAR (8) not null,
   quantity int not null,
   order_type int not null,
   stop_price double not null,
   limit_price double not null,
   status int not null, 
   t_id BIGINT not null,
   b_id BIGINT not null,
   PRIMARY KEY(block_id),
   FOREIGN KEY(t_id),
   FOREIGN KEY(b_id) REFERENCES broker(b_id)
);

-- Order related info

create table pm_order (
   order_id BIGINT not null AUTO_INCREMENT,
   p_id  BIGINT not null,
   pm_id BIGINT not null,
   assigned_to  BIGINT not null,
   PRIMARY KEY(order_id),
   FOREIGN KEY(p_id) REFERENCES portfolio(p_id),
   FOREIGN KEY(pm_id) REFERENCES portfolio_manager(pm_id),
   FOREIGN KEY(assigned_to) REFERENCES trader(t_id)
);

create table single_order (
   sorder_id BIGINT not null,
   p_id BIGINT not null,
   order_id BIGINT not null,
   block_id BIGINT not null,
   symbol CHAR(6) not null,
   quantity double not null,
   action VARCHAR(15) not null, 
   price_stop DECIMAL(18, 4) not null,
   price_limit DECIMAL(18, 4) not null,
   price_purchase DECIMAL(18, 4) not null,
   stock_exchange int not null,
   account_type double not null,
   order_type int not null,
   status int not null,
   PRIMARY KEY(sorder_id),
   FOREIGN KEY(p_id) REFERENCES pm_order(p_id),
   FOREIGN KEY(order_id) REFERENCES pm_order(order_id),
   FOREIGN KEY(block_id) REFERENCES trade_block(block_id)
);
