-- Broker
create table IF NOT EXISTS broker (
   b_id BIGINT not null AUTO_INCREMENT,
   name VARCHAR (8) not null,
   email VARCHAR (254) not null,
   PRIMARY KEY (b_id)
);

-- User-related information

create table IF NOT EXISTS user (
   u_id BIGINT not null AUTO_INCREMENT,
   name VARCHAR(20) not null, 
   username VARCHAR (8) not null UNIQUE,
   password VARCHAR (64) not null,
   PRIMARY KEY (u_id)
);

-- Portfolio Manager

create table IF NOT EXISTS portfolio_manager (
   pm_id BIGINT not null,
   PRIMARY KEY  (pm_id),
   FOREIGN KEY (pm_id) REFERENCES user(u_id)
);

-- Admin

create table IF NOT EXISTS admin (
   adm_id BIGINT not null,
   PRIMARY KEY  (adm_id),
   FOREIGN KEY (adm_id) REFERENCES user(u_id)
);

-- Portfolio

create table IF NOT EXISTS portfolio (
   p_id BIGINT not null AUTO_INCREMENT,
   PRIMARY KEY (p_id)
);

-- Trader 

create table IF NOT EXISTS trader (
   t_id BIGINT not null,
   PRIMARY KEY  (t_id),
   FOREIGN KEY (t_id) REFERENCES user(u_id)
);


-- Portfolio Managers portfolios

create table IF NOT EXISTS pm_to_portfolio (
   pm_id BIGINT not null,
   p_id BIGINT not null,
   PRIMARY KEY  (pm_id, p_id),
   FOREIGN KEY (pm_id) REFERENCES portfolio_manager(pm_id),
   FOREIGN KEY (p_id) REFERENCES portfolio(p_id)
);

-- Trade related operations

create table IF NOT EXISTS trader_block (
   block_id BIGINT not null AUTO_INCREMENT,
   symbol CHAR (6) not null,
   quantity int not null,
   order_type VARCHAR(8) not null,
   price_executed DECIMAL(18, 4),
   status VARCHAR(8) not null, 
   t_id BIGINT not null,
   b_id BIGINT not null,
   PRIMARY KEY(block_id),
   FOREIGN KEY(t_id) REFERENCES trader(t_id),
   FOREIGN KEY(b_id) REFERENCES broker(b_id)
);

-- Order related info

create table IF NOT EXISTS pm_order (
   order_id BIGINT not null AUTO_INCREMENT,
   p_id  BIGINT not null,
   pm_id BIGINT not null,
   assigned_to  BIGINT not null,
   PRIMARY KEY(order_id),
   FOREIGN KEY(p_id) REFERENCES portfolio(p_id),
   FOREIGN KEY(pm_id) REFERENCES portfolio_manager(pm_id),
   FOREIGN KEY(assigned_to) REFERENCES trader(t_id)
);

create table IF NOT EXISTS single_order (
   sorder_id BIGINT not null,
   p_id BIGINT not null,
   order_id BIGINT not null,
   block_id BIGINT,
   symbol CHAR (6) not null,
   quantity double not null,
   action_type VARCHAR(15) not null, 
   order_type VARCHAR(10) not null,
   account_type double not null,
   stock_exchange VARCHAR(8) not null,
   price_stop DECIMAL(18, 4),
   price_limit DECIMAL(18, 4),
   price_executed DECIMAL(18, 4),
   status VARCHAR(15) not null,
   date_pmorder TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
   date_trequest TIMESTAMP DEFAULT '0000-00-00 00:00:00',
   date_bexecuted TIMESTAMP DEFAULT '0000-00-00 00:00:00',
   PRIMARY KEY(sorder_id),
   FOREIGN KEY(p_id) REFERENCES pm_order(p_id),
   FOREIGN KEY(order_id) REFERENCES pm_order(order_id),
   FOREIGN KEY(block_id) REFERENCES trader_block(block_id)
);
