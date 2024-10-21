# Product Management SQL Commands

## Create Table: Categories
CREATE TABLE categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL
);


## Create Table: Products
CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL DEFAULT 0,
    category_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);


## Insert Categories
INSERT INTO categories (category_name) VALUES
    ('Electronics'),
    ('Clothing'),
    ('Books'),
    ('Home Goods'),
    ('Toys'),
    ('Groceries'),
    ('Beauty'),
    ('Sports'),
    ('Office Supplies'),
    ('Jewelry');


## Insert Products
INSERT INTO products (product_name, description, price, quantity, category_id) VALUES
    ('Smartphone', 'Latest model with advanced features', 599.99, 50, 1),
    ('Laptop', 'Lightweight and powerful laptop', 899.99, 30, 1),
    ('Wireless Headphones', 'Noise-cancelling wireless headphones', 199.99, 100, 1),
    ('T-shirt', 'Cotton T-shirt available in various colors', 19.99, 200, 2),
    ('Jeans', 'Slim fit denim jeans', 49.99, 150, 2),
    ('Sneakers', 'Comfortable running shoes', 79.99, 100, 2),
    ('Fiction Book', 'Best-selling fiction novel', 14.99, 75, 3),
    ('Cookbook', 'Healthy recipes for everyday meals', 24.99, 80, 3),
    ('Desk Chair', 'Ergonomic office chair', 129.99, 25, 4),
    ('Sofa', 'Comfortable 3-seater sofa', 599.99, 10, 4),
    ('Action Figure', 'Collectible action figure', 29.99, 90, 5),
    ('Dollhouse', 'Wooden dollhouse with furniture', 79.99, 40, 5),
    ('Organic Vegetables', 'Fresh and organic vegetables', 9.99, 300, 6),
    ('Shampoo', 'Nourishing hair shampoo', 12.99, 120, 7),
    ('Lipstick', 'Matte finish long-lasting lipstick', 9.99, 180, 7),
    ('Soccer Ball', 'Standard size soccer ball', 24.99, 80, 8),
    ('Yoga Mat', 'Eco-friendly yoga mat', 39.99, 50, 8),
    ('Notebook', 'Hardcover lined notebook', 4.99, 500, 9),
    ('Pen Set', 'Luxury ballpoint pen set', 14.99, 300, 9),
    ('Gold Necklace', 'Elegant gold necklace', 999.99, 5, 10),
    ('Smartwatch', 'Fitness tracking smartwatch', 249.99, 40, 1),
    ('Tablet', 'High-resolution display tablet', 399.99, 20, 1),
    ('Bluetooth Speaker', 'Portable Bluetooth speaker', 99.99, 150, 1),
    ('Dress', 'Summer floral dress', 39.99, 120, 2),
    ('Jacket', 'Waterproof winter jacket', 79.99, 90, 2),
    ('Running Shoes', 'Breathable running shoes', 59.99, 140, 2),
    ('Mystery Novel', 'Gripping mystery novel', 19.99, 100, 3),
    ('Children\'s Book', 'Illustrated children\'s storybook', 9.99, 250, 3),
    ('Dining Table', 'Wooden dining table for 6', 499.99, 15, 4),
    ('Lamp', 'Modern table lamp', 39.99, 60, 4),
    ('Board Game', 'Popular family board game', 29.99, 85, 5),
    ('Toy Car', 'Remote control car', 49.99, 120, 5),
    ('Organic Fruit', 'Fresh organic fruit', 12.99, 350, 6),
    ('Body Lotion', 'Moisturizing body lotion', 14.99, 100, 7),
    ('Face Cream', 'Anti-aging face cream', 29.99, 50, 7),
    ('Tennis Racket', 'Professional tennis racket', 79.99, 40, 8),
    ('Basketball', 'Official size basketball', 29.99, 90, 8),
    ('Printer Paper', '500 sheets of printer paper', 9.99, 400, 9),
    ('Desk Organizer', 'Multi-compartment desk organizer', 19.99, 200, 9),
    ('Diamond Ring', 'Brilliant diamond engagement ring', 4999.99, 3, 10),
    ('Digital Camera', 'High-resolution DSLR camera', 899.99, 25, 1),
    ('Monitor', '4K Ultra HD monitor', 399.99, 45, 1),
    ('Gaming Mouse', 'Precision gaming mouse', 49.99, 100, 1),
    ('Skirt', 'Pleated midi skirt', 29.99, 90, 2),
    ('Leather Jacket', 'Genuine leather jacket', 199.99, 30, 2),
    ('Sandals', 'Casual beach sandals', 19.99, 200, 2),
    ('Science Fiction Book', 'Award-winning science fiction', 24.99, 70, 3),
    ('Biography', 'Inspiring biography of a famous person', 19.99, 80, 3),
    ('Bookshelf', 'Modern wooden bookshelf', 159.99, 20, 4),
    ('Coffee Table', 'Glass top coffee table', 199.99, 10, 4),
    ('Puzzle', '1000-piece jigsaw puzzle', 19.99, 75, 5),
    ('Toy Robot', 'Interactive toy robot', 69.99, 50, 5),
    ('Organic Milk', 'Fresh organic milk', 4.99, 400, 6),
    ('Conditioner', 'Nourishing hair conditioner', 11.99, 150, 7),
    ('Perfume', 'Luxury fragrance', 49.99, 60, 7),
    ('Golf Clubs', 'Complete set of golf clubs', 499.99, 10, 8),
    ('Baseball Glove', 'Leather baseball glove', 49.99, 40, 8),
    ('Stapler', 'Heavy-duty stapler', 14.99, 180, 9),
    ('File Cabinet', '4-drawer file cabinet', 129.99, 15, 9),
    ('Silver Bracelet', 'Elegant silver bracelet', 199.99, 20, 10),
    ('Earrings', 'Diamond stud earrings', 799.99, 8, 10),
    ('TV', '55-inch 4K Smart TV', 599.99, 25, 1),
    ('Wireless Charger', 'Fast wireless charging pad', 29.99, 150, 1),
    ('Sweater', 'Wool blend sweater', 49.99, 110, 2),
    ('Hoodie', 'Casual cotton hoodie', 39.99, 130, 2),
    ('Sneakers', 'Casual everyday sneakers', 59.99, 160, 2),
    ('Romance Novel', 'Heartwarming romance story', 14.99, 90, 3),
    ('Travel Guide', 'Comprehensive travel guidebook', 19.99, 50, 3),
    ('Curtains', 'Light-blocking curtains', 69.99, 30, 4),
    ('Rug', 'Large area rug', 199.99, 20, 4),
    ('Building Blocks', 'Educational building blocks for kids', 39.99, 120, 5),
    ('Board Puzzle', 'Wooden board puzzle', 29.99, 80, 5),
    ('Organic Eggs', 'Fresh organic eggs', 5.99, 500, 6),
    ('Hand Cream', 'Moisturizing hand cream', 9.99, 160, 7),
    ('Lip Balm', 'Hydrating lip balm', 4.99, 250, 7),
    ('Running Shoes', 'Lightweight running shoes', 89.99, 70, 8),
    ('Camping Tent', '4-person waterproof camping tent', 149.99, 25, 8),
    ('Calculator', 'Scientific calculator', 19.99, 100, 9),
    ('Binder', '3-ring binder', 6.99, 250, 9),
    ('Pearl Necklace', 'Elegant pearl necklace', 499.99, 12, 10),
    ('Watch', 'Luxury Swiss watch', 3999.99, 5, 10),
    ('Bluetooth Earbuds', 'Wireless Bluetooth earbuds', 59.99, 90, 1),
    ('Tablet Case', 'Protective tablet case', 19.99, 150, 1),
    ('Denim Jacket', 'Classic denim jacket', 59.99, 100, 2),
    ('Dress Shoes', 'Formal leather dress shoes', 99.99, 40, 2),
    ('Fantasy Novel', 'Epic fantasy adventure', 29.99, 80, 3),
    ('History Book', 'Detailed history of ancient civilizations', 24.99, 60, 3),
    ('Bookshelf', 'Compact wall-mounted bookshelf', 99.99, 40, 4);


## SELECT
SELECT
    p.product_id AS 'Product ID',
    p.product_name AS 'Product Name',
    c.category_name AS 'Category',
    CONCAT('₹', FORMAT(p.price, 2)) AS 'Price (INR)',
    p.quantity AS 'Available Quantity',
    DATE_FORMAT(p.created_at, '%M %d, %Y') AS 'Created Date',
    DATE_FORMAT(p.updated_at, '%M %d, %Y') AS 'Last Updated'
FROM
    products p
INNER JOIN
    categories c ON p.category_id = c.category_id
WHERE
    p.quantity > 0
ORDER BY
    p.created_at DESC, p.product_name ASC
LIMIT 20;
