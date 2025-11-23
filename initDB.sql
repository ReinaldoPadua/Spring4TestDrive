CREATE TABLE IF NOT EXISTS animals (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(100) NOT NULL,
    family VARCHAR(100) NOT NULL,
    weight DECIMAL(10,2) NOT NULL
    );

INSERT INTO animals(name, family, weight) VALUES
                                              ('Dog', 'Canidae', 20.00),
                                              ('Cat', 'Felidae', 5.00),
                                              ('Pig', 'Suinae', 200.00);
