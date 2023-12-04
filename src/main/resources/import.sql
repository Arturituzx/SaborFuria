INSERT INTO clientes(nombre,apellido,distrito,direccion,dni,correo,contraseña,edad,fecha_creacion,celular) VALUES('Jose','Fernandez','La Molina','Javier Prado, Av Javier Prado Este 1059,15034','10355035','joseFer@gmail.com','Usmp2023',21,'2023-09-15','955025436');
INSERT INTO clientes(nombre,apellido,distrito,direccion,dni,correo,contraseña,edad,fecha_creacion,celular) VALUES('Juan','Torvisco','Magdalena','Jirón Salaverry 610, Magdalena del Mar','80118420','juanTor@gmail.com','fiadata28',28,'2023-09-15','955025444');
INSERT INTO clientes(nombre,apellido,distrito,direccion,dni,correo,contraseña,edad,fecha_creacion,celular) VALUES('Arturo','Gonzales','San Luis','Av. San Luis 199, La Victoria 15019','07896352','arturoGon@gmail.com','aedi2023',35,'2023-09-15','960118936');

/*implementamos empleados*/
INSERT INTO empleados(nombre,apellido,numero_telefono,genero,direccion,salario,fecha_creacion) VALUES('Mario','Ruiz','955025436','masculino','calle Las hiedras','2500','2023-09-16');
INSERT INTO empleados(nombre,apellido,numero_telefono,genero,direccion,salario,fecha_creacion) VALUES('Jota','Fernandez','985025436','masculino','calle Las Hortencias','2000','2023-09-16');

/*Implementamos contactanos*/
INSERT INTO contactanos(fecha_envio,nombre,correo,mensaje) VALUES(NOW(),'Luis Gutierrez','luisGut@hotmail.com','Quisiera saber mas infromacion sobre los productos');
INSERT INTO contactanos(fecha_envio,nombre,correo,mensaje) VALUES(NOW(),'Paulo Martinez','PauloMartinez@hotmail.com','Hacen pedidos al por mayor , en caso quisiera un evento de 50 personas');
INSERT INTO contactanos(fecha_envio,nombre,correo,mensaje) VALUES(NOW(),'Antonio Ruiz','antonioRuiz@hotmail.com','Sus cremas ultizadas, ¿Son preparadas por ustedes mismo?');

/*Implementamos algunos productos*/
INSERT INTO productos(tipo_Menu,nombre_Menu,precio,fecha_Creacion) VALUES ('Hamburguesa','Hamburguesa Doble carne',18.2,NOW());
INSERT INTO productos(tipo_Menu,nombre_Menu,precio,fecha_Creacion) VALUES ('Hamburguesa','Hamburguesa Simple',13.5,NOW());
INSERT INTO productos(tipo_Menu,nombre_Menu,precio,fecha_Creacion) VALUES ('Hamburguesa','Hamburguesa  suprema',25.9,NOW());
INSERT INTO productos(tipo_Menu,nombre_Menu,precio,fecha_Creacion) VALUES ('Hamburguesa','Hamburguesa  vegana',25.9,NOW());
INSERT INTO productos(tipo_Menu,nombre_Menu,precio,fecha_Creacion) VALUES ('Hamburguesa','Hamburguesa  Triple',25.9,NOW());
INSERT INTO productos(tipo_Menu,nombre_Menu,precio,fecha_Creacion) VALUES ('Helados','Helado en cono',4.9,NOW());
INSERT INTO productos(tipo_Menu,nombre_Menu,precio,fecha_Creacion) VALUES ('Helados','Helado Oreo',6.9,NOW());
INSERT INTO productos(tipo_Menu,nombre_Menu,precio,fecha_Creacion) VALUES ('Helados','Helado sublime',6.9,NOW());
INSERT INTO productos(tipo_Menu,nombre_Menu,precio,fecha_Creacion) VALUES ('Bebidas','Agua San Mateo',3.5,NOW());
INSERT INTO productos(tipo_Menu,nombre_Menu,precio,fecha_Creacion) VALUES ('Bebidas','Coca Cola 500ml',3.5,NOW());
INSERT INTO productos(tipo_Menu,nombre_Menu,precio,fecha_Creacion) VALUES ('Bebidas','Inca Kola 500ml',3.5,NOW());
INSERT INTO productos(tipo_Menu,nombre_Menu,precio,fecha_Creacion) VALUES ('Bebidas','Fanta 500ml',3.5,NOW());
INSERT INTO productos(tipo_Menu,nombre_Menu,precio,fecha_Creacion) VALUES ('Complementos','Nuggets',10.9,NOW());
INSERT INTO productos(tipo_Menu,nombre_Menu,precio,fecha_Creacion) VALUES ('Complementos','Alitas',12.9,NOW());
INSERT INTO productos(tipo_Menu,nombre_Menu,precio,fecha_Creacion) VALUES ('Complementos','Mayonesa',2.0,NOW());

/*Creamos facturas*/
INSERT INTO facturas(fecha_Emision,descripcion,observacion,ruc,razon_Social,cliente_id) VALUES(NOW(),'Factura del restaurante SaborFuria','Buena compra','20552103816','AGROLIGHT PERU S.A.C.',1);
INSERT INTO detalle_factura(cantidad,producto_id,factura_id) VALUES(3,1,1);
INSERT INTO detalle_factura(cantidad,producto_id,factura_id) VALUES(4,4,1);
INSERT INTO detalle_factura(cantidad,producto_id,factura_id) VALUES(1,5,1);


INSERT INTO facturas(fecha_Emision,descripcion,observacion,ruc,razon_Social,cliente_id) VALUES(NOW(),'Factura del restaurante SaborFuria','Buena compra','20538856674','ARTROSCOPICTRAUMA S.A.C.',2);
INSERT INTO detalle_factura(cantidad,producto_id,factura_id) VALUES(1,3,2);
INSERT INTO detalle_factura(cantidad,producto_id,factura_id) VALUES(2,7,2);
INSERT INTO detalle_factura(cantidad,producto_id,factura_id) VALUES(1,8,2);


INSERT INTO facturas(fecha_Emision,descripcion,observacion,ruc,razon_Social,cliente_id) VALUES(NOW(),'Factura del restaurante SaborFuria','Buena compra','20553856451','BI GRAND CONFECCIONES S.A.C.',3);
INSERT INTO detalle_factura(cantidad,producto_id,factura_id) VALUES(1,5,3);
INSERT INTO detalle_factura(cantidad,producto_id,factura_id) VALUES(1,6,3);
INSERT INTO detalle_factura(cantidad,producto_id,factura_id) VALUES(1,4,3);




