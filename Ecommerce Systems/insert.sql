use ecommercedb;
INSERT INTO auction 
(auction_id, catalog_id, itemName, auction_type, start_price, end_date, highest_bid, highest_bidder) 
VALUES 
(200, 123, 'Artwork', 'Standard', 500.0, '2023-12-31', 550.0, 456);
INSERT INTO catalog 
(item_id, auction_duration, auction_end_date, auction_end_time, auction_start_date, auction_start_time, auction_type, expedited_shipping, initial_price, item_description, item_name, seller_username, shipping_price, shipping_time) 
VALUES 
(123, '02:00:00', '2023-12-31', '18:00:00', '2023-12-30', '16:00:00', 'Standard', 10.00, 500.0, 'A beautiful artwork', 'Artwork', 'seller123', 15.00, '3-5 days');