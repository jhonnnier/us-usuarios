INSERT INTO usuarios (nombre, email, password)
VALUES ('Jhonnier', 'jhonnier@example.com', '1234')
    ON CONFLICT (email) DO NOTHING;

INSERT INTO usuarios (nombre, email, password)
VALUES ('Ana', 'ana@example.com', 'abcd')
    ON CONFLICT (email) DO NOTHING;

INSERT INTO usuarios (nombre, email, password)
VALUES ('Carlos', 'carlos@example.com', 'qwerty')
    ON CONFLICT (email) DO NOTHING;
