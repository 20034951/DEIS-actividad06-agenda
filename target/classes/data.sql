-- Contactos para demo
INSERT INTO contacto (id, nombre) VALUES (1, 'Pablo Alfonso Vargas');
INSERT INTO contacto (id, nombre) VALUES (2, 'María Guadalupe Sandoval');

-- Direcciones asociadas
INSERT INTO direccion (id, valor, tipo, contacto_id) VALUES (1, 'Av. Reforma 3-12', 'CASA', 1);
INSERT INTO direccion (id, valor, tipo, contacto_id) VALUES (2, 'Zona 10, Torre Empresarial', 'TRABAJO', 1);
INSERT INTO direccion (id, valor, tipo, contacto_id) VALUES (3, '25 C. 12-24 Zona 5', 'CASA', 2);

-- Telefonos asociados
INSERT INTO telefono (id, valor, tipo, contacto_id) VALUES (1, '5555-1234', 'FIJO', 1);
INSERT INTO telefono (id, valor, tipo, contacto_id) VALUES (2, '5555-2345', 'MOVIL', 1);
INSERT INTO telefono (id, valor, tipo, contacto_id) VALUES (3, '5555-3456', 'FIJO', 2);
