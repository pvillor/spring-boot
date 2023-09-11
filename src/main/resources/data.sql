INSERT INTO "users" ("name", "cpf", "email", "password", "type")
VALUES
    ('Ayanokoji', '12345678910', 'ayanokoji@kenzie.com', '1234', 'COMMON'),
    ('Kiyotaka', '12345678911', 'kiyotaka@kenzie.com', '1234', 'SELLER');

INSERT INTO "transactions" ("payer_id", "payee_id", "value")
VALUES
    ('1', '2', 10.0);