program Cap3Ej2aII;

type

	rangoDias=  1 .. 31;
	rangoMeses= 1 .. 12;
	rangoAnios= 1 .. 2024;
	
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

procedure inicializarArboles (var a1: arbol1; var a2: arbol2);
begin
	a1 := nil;
	a2 := nil;
end;

procedure leerFecha (var fecha: fechaR);
begin
	with fecha do begin
		writeln ('Ingrese el dia de la venta');
		dia := random (31) + 1;
		writeln ('Ingrese el mes de la venta');
		mes := random (12) + 1;
		writeln ('Ingrese el anio de la venta');
		anio := random (2024) + 1;
	end;
end;

procedure leerVenta (var venta1: ventaR1);
begin
	writeln ('---------------');
	writeln ('Avanzamos con un nuevo producto');
	with venta1 do begin
		writeln ('Ingrese el codigo del producto');
		codigo := random (100);
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

procedure cargarArboles (var a1: arbol1; var a2: arbol2);
var
	venta1: ventaR1;
begin
	leerVenta (venta1);
	if (venta1.codigo <> 0) then
		begin
			agregarOrdenado1 (a1, venta1);
			agregarOrdenado2 (a2, venta1.codigo, venta1.cantidad);
			cargarArboles (a1, a2);
		end;
end;

procedure recorrerArbol1 (a1: arbol1);
begin
  if (a1 <> nil) then
	begin
		recorrerArbol1 (a1^.HI);
		writeln (a1^.dato.codigo);
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

var
a1: arbol1;
a2: arbol2;
begin
	randomize;
	inicializarArboles (a1, a2);
	cargarArboles (a1, a2);
	writeln ('---------------');
	writeln ('Se empieza a recorrer el arbol ordenado por codigo de menor a mayor');
	recorrerArbol1 (a1); // compruebo que se ordenó bien
	writeln ('---------------');
	writeln ('Se empieza a recorrer el arbol con las cantidades totales');
	recorrerArbol2 (a2); // compruebo que se sumaron bien las cantidades
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

Es mejor cargar el segundo arbol a la par, para no recorrer
todo el primer arbol cargando el segundo mas adelante}
