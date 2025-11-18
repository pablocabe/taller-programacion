program Cap3Ej2b;

type

	rangoDias=  1 .. 31;
	rangoMeses= 1 .. 12;
	rangoAnios= 2020 .. 2024;
	
	fechaR = record
		dia: rangoDias;
		mes: rangoMeses;
		anio: rangoAnios;
	end;
	
	ventaR1 = record
		codigo: integer;
		fechas: fechaR;
		cantidad: integer; 
	end;

	ventaR2 = record
		codigo: integer;
		cantidadTotal: integer;
	end;
	
	 arbol1 = ^nodo1;
	 nodo1 = record
		dato: ventaR1;
		HI: arbol1;
		HD: arbol1;
	 end;
	 
	 arbol2 = ^nodo2;
	 nodo2 = record
		dato: ventaR2;
		HI: arbol2;
		HD: arbol2;
	 end;
	
	lista = ^nodo4;
	nodo4 = record
		dato: ventaR1;
		sig: lista;
	end;
	
	arbol3R = record
		codigo: integer;
		listaVentas: lista;
	end;
	
	arbol3 = ^nodo3;
	nodo3 = record
		dato: arbol3R; // dentro de arbol3R se almacenarán el codigo y cada venta
		HI: arbol3;
		HD: arbol3
	end;

procedure inicializarArboles (var a1: arbol1; var a2: arbol2; var a3: arbol3);
begin
	a1 := nil;
	a2 := nil;
	a3 := nil;
end;

procedure leerFecha (var fecha: fechaR);
begin
	with fecha do begin
		writeln ('Ingrese el dia de la venta');
		dia := random (31) + 1;
		writeln ('Ingrese el mes de la venta');
		mes := random (12) + 1;
		writeln ('Ingrese el anio de la venta');
		anio := random (5) + 2020;
		writeln ('La fecha ingresada es: ', dia, '/', mes, '/', anio);
	end;
end;

procedure leerVenta (var venta1: ventaR1);
begin
	writeln ('---------------');
	writeln ('Avanzamos con un nuevo producto');
	with venta1 do begin
		writeln ('Ingrese el codigo del producto');
		codigo := random (1000);
		if (codigo <> 0) then
			begin
				leerFecha (venta1.fechas);
				writeln ('Ingrese la cantidad de unidades vendidas');
				cantidad := random (100);
			end;
	end;
end;

procedure agregarOrdenado1 (var a1: arbol1; venta1: ventaR1);
begin
	if (a1 = nil) then // sería útil modularizar la creación de los nodos para los arboles
		begin
			new (a1);
			 a1^.dato := venta1;
			 a1^.HI := nil;
			 a1^.HD := nil;
		end
	else if (venta1.codigo < a1^.dato.codigo) then
		agregarOrdenado1 (a1^.HI, venta1)
		else
			agregarOrdenado1 (a1^.HD, venta1)
end;

procedure agregarOrdenado2 (var a2: arbol2; codigo, cantidad: integer);
begin
	if (a2 = nil) then
		begin
			new (a2);
			a2^.dato.codigo := codigo;
			a2^.dato.cantidadTotal := cantidad; // basicamente si el codigo no existe inicializas la cantidadTotal
			a2^.HI := nil;
			a2^.HD := nil;
		end
		else if (codigo < a2^.dato.codigo) then
			agregarOrdenado2 (a2^.HI, codigo, cantidad)
		else if (codigo > a2^.dato.codigo) then
			agregarOrdenado2 (a2^.HD, codigo, cantidad)
		else
			a2^.dato.cantidadTotal := a2^.dato.cantidadTotal + cantidad; // si el codigo existe sumas a la cantidadTotal
end;

procedure agregarAdelante (var L: lista; venta1: ventaR1);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato := venta1;
	nuevo^.sig := L;
	L := nuevo;
	writeln ('Se agrego una venta al codigo de producto ', venta1.codigo);
end;

procedure agregarOrdenado3 (var a3: arbol3; venta1: ventaR1);
begin
	if (a3 = nil) then
		begin
			new (a3);
			a3^.dato.codigo := venta1.codigo;
			a3^.dato.listaVentas := nil;
			agregarAdelante (a3^.dato.listaVentas, venta1);
			a3^.HI := nil;
			a3^.HD := nil;
		end
		else if (venta1.codigo < a3^.dato.codigo) then
			agregarOrdenado3 (a3^.HI, venta1)
		else if (venta1.codigo > a3^.dato.codigo) then
			agregarOrdenado3 (a3^.HD, venta1)
		else
			agregarAdelante (a3^.dato.listaVentas, venta1);
end;

procedure cargarArboles (var a1: arbol1; var a2: arbol2; var a3: arbol3);
var
	venta1: ventaR1;
begin
	leerVenta (venta1);
	if (venta1.codigo <> 0) then
		begin
			agregarOrdenado1 (a1, venta1);
			agregarOrdenado2 (a2, venta1.codigo, venta1.cantidad);
			agregarOrdenado3 (a3, venta1);
			cargarArboles (a1, a2, a3);
		end;
end;

procedure recorrerArbol1 (a1: arbol1);
begin
  if (a1 <> nil) then
	begin
		recorrerArbol1 (a1^.HI);
		writeln (a1^.dato.codigo);
		writeln (a1^.dato.fechas.dia, '/', a1^.dato.fechas.mes, '/', a1^.dato.fechas.anio);
		recorrerArbol1 (a1^.HD);
	end;
end;

procedure recorrerArbol2 (a2: arbol2);
begin
	if (a2 <> nil) then
		begin
			recorrerArbol2 (a2^.HI);
			writeln ('El codigo es ', a2^.dato.codigo);
			writeln ('La cantidad total es ', a2^.dato.cantidadTotal);
			writeln;
			recorrerArbol2 (a2^.HD);
		end;
end;

procedure recorrerLista (L: lista);
begin
	if (L<> nil) then
		begin
			writeln ('El codigo de la lista actual es: ', L^.dato.codigo); // le pido que repita el codigo la cantidad de veces que almaceno ventas en la lista
			recorrerLista (L^.sig);
		end;
end;

procedure recorrerArbol3 (a3: arbol3);
begin
	if (a3 <> nil) then
		begin
			recorrerArbol3 (a3^.HI);
			recorrerLista (a3^.dato.listaVentas);
			recorrerArbol3 (a3^.HD);
		end;
end;

function modulo2B (a1: arbol1; fecha: fechaR): integer;
begin
	if (a1 = nil) then
		modulo2B := 0
	else if (a1^.dato.fechas.dia = fecha.dia) and (a1^.dato.fechas.mes = fecha.mes) and (a1^.dato.fechas.anio = fecha.anio) then
		modulo2B := a1^.dato.cantidad + modulo2B (a1^.HI, fecha) + modulo2B (a1^.HD, fecha)
	else
		modulo2B := modulo2B (a1^.HI, fecha) + modulo2B (a1^.HD, fecha);
end;

var
a1: arbol1;
a2: arbol2;
a3: arbol3;
fecha: fechaR;
begin
	randomize;
	inicializarArboles (a1, a2, a3);
	cargarArboles (a1, a2, a3); // retorna tres árboles
	writeln ('---------------');
	writeln ('Se empieza a recorrer el arbol ordenado por codigo de menor a mayor');
	recorrerArbol1 (a1); // compruebo que se ordenó bien
	writeln ('---------------');
	writeln ('Se empieza a recorrer el arbol con las cantidades totales');
	recorrerArbol2 (a2); // compruebo que se sumaron bien las cantidades
	writeln ('---------------');
	writeln ('Se empieza a recorrer el tercer arbol con sus respectivas listas');
	recorrerArbol3 (a3); // compruebo que se armaron bien las listas
	writeln ('---------------');
	writeln ('Ingrese una fecha:');
	writeln ('Ingrese un dia:');
	readln (fecha.dia);
	writeln ('Ingrese un mes:');
	readln (fecha.mes);
	writeln ('Ingrese un anio:');
	readln (fecha.anio);
	writeln ('La cantidad de productos vendidos en la fecha es: ', modulo2B (a1, fecha));
end.

{2. Escribir un programa que:
a. Implemente un módulo que genere aleatoriamente información de ventas de un comercio.
Para cada venta generar código de producto, fecha y cantidad de unidades vendidas. Finalizar
con el código de producto 0. Un producto puede estar en más de una venta. Se pide:
i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de
producto. Los códigos repetidos van a la derecha.
ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
código de producto. Cada nodo del árbol debe contener el código de producto y la
cantidad total de unidades vendidas.
iii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
código de producto. Cada nodo del árbol debe contener el código de producto y la lista de
las ventas realizadas del producto
b. Implemente un módulo que reciba el árbol generado en i. y una fecha y retorne la cantidad
total de productos vendidos en la fecha recibida}
