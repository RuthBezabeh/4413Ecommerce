-- Populate User Table
INSERT INTO user (firstname, lastname, street_name, street_number, postal_code, city, country, username, password)
VALUES
  ('John', 'Doe', 'Main St', 123, '12345', 'City1', 'Country1', 'user1', 'password1'),
  ('Jane', 'Smith', 'Oak St', 456, '67890', 'City2', 'Country2', 'user2', 'password2'),
  ('Alice', 'Johnson', 'Maple St', 789, '54321', 'City3', 'Country3', 'user3', 'password3'),
  ('Bob', 'Williams', 'Cedar St', 101, '98765', 'City4', 'Country4', 'user4', 'password4'),
  ('Eva', 'Davis', 'Pine St', 202, '56789', 'City5', 'Country5', 'user5', 'password5'),
  ('Michael', 'Brown', 'Elm St', 303, '45678', 'City6', 'Country6', 'user6', 'password6'),
  ('Olivia', 'Martinez', 'Birch St', 404, '34567', 'City7', 'Country7', 'user7', 'password7'),
  ('David', 'Rodriguez', 'Cypress St', 505, '23456', 'City8', 'Country8', 'user8', 'password8'),
  ('Sophia', 'Garcia', 'Chestnut St', 606, '65432', 'City9', 'Country9', 'user9', 'password9'),
  ('William', 'Lee', 'Sycamore St', 707, '87654', 'City10', 'Country10', 'user10', 'password10');

-- Populate Catalog Table
INSERT INTO catalog (item_name, seller_username, auction_type, shipping_price, expedited_shipping, auction_duration, item_description, shipping_time, initial_price, auction_start_time)
VALUES
  ('Item1', 'user1', 'Auction', 5.0, 10.0, '12:00:00', 'Description1', '3 days', 20.0, CURRENT_TIMESTAMP),
  ('Item2', 'user2', 'Auction', 6.0, 12.0, '24:00:00', 'Description2', '5 days', 25.0, CURRENT_TIMESTAMP),
  ('Item3', 'user3', 'Auction', 7.0, 14.0, '36:00:00', 'Description3', '7 days', 30.0, CURRENT_TIMESTAMP),
  ('Item4', 'user4', 'Auction', 8.0, 16.0, '48:00:00', 'Description4', '2 days', 35.0, CURRENT_TIMESTAMP),
  ('Item5', 'user5', 'Auction', 9.0, 18.0, '60:00:00', 'Description5', '4 days', 40.0, CURRENT_TIMESTAMP),
  ('Item6', 'user6', 'Auction', 10.0, 20.0, '72:00:00', 'Description6', '6 days', 45.0, CURRENT_TIMESTAMP),
  ('Item7', 'user7', 'Auction', 11.0, 22.0, '84:00:00', 'Description7', '1 day', 50.0, CURRENT_TIMESTAMP),
  ('Item8', 'user8', 'Auction', 12.0, 24.0, '96:00:00', 'Description8', '8 days', 55.0, CURRENT_TIMESTAMP),
  ('Item9', 'user9', 'Auction', 13.0, 26.0, '108:00:00', 'Description9', '9 days', 60.0, CURRENT_TIMESTAMP),
  ('Item10', 'user10', 'Auction', 14.0, 28.0, '120:00:00', 'Description10', '10 days', 65.0, CURRENT_TIMESTAMP);

-- Populate Auction Table
INSERT INTO auction (auction_type, catalog_id, end_date, highest_bid, highest_bidder, itemname, start_price, auctioned_item_id, highest_bidder_name, highest_price, auction_end_time)
VALUES
    ('Auction', 1, '2023-01-01 12:00:00.000000', 50.0, 1, 'Item1', 30.0, 101, 'User1', 50.0, '2023-01-01 14:00:00.000000'),
    ('Auction', 2, '2023-01-02 12:00:00.000000', 40.0, 2, 'Item2', 25.0, 102, 'User2', 40.0, '2023-01-02 14:00:00.000000'),
    ('Auction', 3, '2023-01-03 12:00:00.000000', 35.0, 3, 'Item3', 20.0, 103, 'User3', 35.0, '2023-01-03 14:00:00.000000'),
    ('Auction', 4, '2023-01-04 12:00:00.000000', 45.0, 4, 'Item4', 28.0, 104, 'User4', 45.0, '2023-01-04 14:00:00.000000'),
    ('Auction', 5, '2023-01-05 12:00:00.000000', 60.0, 5, 'Item5', 40.0, 105, 'User5', 60.0, '2023-01-05 14:00:00.000000'),
    ('Auction', 6, '2023-01-06 12:00:00.000000', 55.0, 6, 'Item6', 35.0, 106, 'User6', 55.0, '2023-01-06 14:00:00.000000'),
    ('Auction', 7, '2023-01-07 12:00:00.000000', 70.0, 7, 'Item7', 45.0, 107, 'User7', 70.0, '2023-01-07 14:00:00.000000'),
    ('Auction', 8, '2023-01-08 12:00:00.000000', 80.0, 8, 'Item8', 55.0, 108, 'User8', 80.0, '2023-01-08 14:00:00.000000'),
    ('Auction', 9, '2023-01-09 12:00:00.000000', 65.0, 9, 'Item9', 38.0, 109, 'User9', 65.0, '2023-01-09 14:00:00.000000'),
    ('Auction', 10, '2023-01-10 12:00:00.000000', 75.0, 10, 'Item10', 48.0, 110, 'User10', 75.0, '2023-01-10 14:00:00.000000');

-- Populate Payment Table
INSERT INTO payment (card_expire_date, card_fname, card_lname, card_number, item_id, security_code, total, user_id, user_name)
VALUES
    ('12/25', 'John', 'Doe', '1234-5678-9012-3456', 101, '123', 50.0, 1, 'User1'),
    ('11/24', 'Jane', 'Smith', '2345-6789-0123-4567', 102, '456', 40.0, 2, 'User2'),
    ('10/23', 'Alice', 'Johnson', '3456-7890-1234-5678', 103, '789', 35.0, 3, 'User3'),
    ('09/22', 'Bob', 'Williams', '4567-8901-2345-6789', 104, '012', 45.0, 4, 'User4'),
    ('08/21', 'Eva', 'Davis', '5678-9012-3456-7890', 105, '345', 60.0, 5, 'User5'),
    ('07/20', 'Michael', 'Brown', '6789-0123-4567-8901', 106, '678', 55.0, 6, 'User6'),
    ('06/19', 'Olivia', 'Martinez', '7890-1234-5678-9012', 107, '901', 70.0, 7, 'User7'),
    ('05/18', 'David', 'Rodriguez', '8901-2345-6789-0123', 108, '234', 80.0, 8, 'User8'),
    ('04/17', 'Sophia', 'Garcia', '9012-3456-7890-1234', 109, '567', 65.0, 9, 'User9'),
    ('03/16', 'William', 'Lee', '0123-4567-8901-2345', 110, '890', 75.0, 10, 'User10');
