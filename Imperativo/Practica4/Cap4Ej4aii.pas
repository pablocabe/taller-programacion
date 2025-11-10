program Cap4Ej4aii; 

type
	rangoDias = 1 .. 31;
	rangoMeses = 1 .. 12;
	
	prestamoR1 = record
		ISBN: integer;
		socio: integer;
		dia: rangoDias;
		mes: rangoMeses;
		cantidad: integer;
	end;
	
	prestamoR2 = record
		socio: integer;
		dia: rangoDias;
		mes: rangoMeses;
		cantidad: integer;
	end;
	
	arbol1 = ^nodo1;
	nodo1 = record
		dato: prestamoR1;
		HI: arbol1;
		HD: arbol1;
	end;
	
	lista = ^nodo3;
	nodo3 = record
		dato: prestamoR2; // aca tengo que utilñizar un segundo registro muy similar o puedo guardar cada elemento suelto
		sig: lista;
	end;
	
	{listaPrestamos = ^nodo3;
	nodo3 = record
		socio: integer; // este seria el segundo caso, donde prescindiria de la creacion de prestamoR2
		dia: rangoDias;
		mes: rangoMeses;
		cantidad: integer;
		sig: listaPrestamos;
	end}
	
	arbol2R = record
		ISBN: integer;
		listaPrestamos: lista;
	end;
	
	arbol2 = ^nodo2;
	nodo2 = record
		dato: arbol2R;
		HI: arbol2;
		HD: arbol2;
	end;

procedure inicializarArboles (var a1: arbol1; var a2: arbol2);
begin
	a1 := nil;
	a2 := nil;
	writeln ('Los arboles fueron inciializados');
end;

procedure leerPrestamo (var prestamo: prestamoR1);
begin
	with prestamo do begin
		ISBN := random (1000);
		if (ISBN <> 0) then
			begin
				socio := random (1000);
				dia := random (31) + 1;
				mes := random (12) + 1;
				cantidad := random (31) + 1;
			end;
	end;
end;

function crearNodoArbol1 (prestamo: prestamoR1): arbol1; // es la primera vez que utilizo este modulo, chequear su carga despues
var
	a1: arbol1;
begin
	new (a1);
	a1^.dato := prestamo;
	a1^.HI := nil;
	a1^.HD := nil;
	crearNodoArbol1 := a1;
end;

procedure agregarOrdenado1 (var a1: arbol1; prestamo: prestamoR1);
begin
	if (a1 = nil) then
		begin
			a1 := crearNodoArbol1 (prestamo);
		end
	else if (prestamo.ISBN < a1^.dato.ISBN) then
		agregarOrdenado1 (a1^.HI, prestamo)
	else
		agregarOrdenado1 (a1^.HD, prestamo);
end;

procedure copiarValores (var nuevo: lista; prestamo: prestamoR1);
begin
	nuevo^.dato.socio := prestamo.socio;
	nuevo^.dato.dia := prestamo.dia;
	nuevo^.dato.mes := prestamo.mes;
	nuevo^.dato.cantidad := prestamo.cantidad;
end;

procedure agregarAdelante (var L: lista; prestamo: prestamoR1);
var
	nuevo: lista;
begin
	new (nuevo);
	copiarValores (nuevo, prestamo);
	nuevo^.sig := L;
	L := nuevo;
end;

procedure agregarOrdenado2 (var a2: arbol2; prestamo: prestamoR1);
begin
	if (a2 = nil) then
		begin
			new (a2);
			a2^.dato.ISBN := prestamo.ISBN;
			a2^.dato.listaPrestamos := nil;
			agregarAdelante (a2^.dato.listaPrestamos, prestamo);
			a2^.HI := nil;
			a2^.HD := nil;
		end
	else if (prestamo.ISBN = a2^.dato.ISBN) then
		agregarAdelante (a2^.dato.listaPrestamos, prestamo)
	else if (prestamo.ISBN < a2^.dato.ISBN) then
		agregarOrdenado2 (a2^.HI, prestamo)
	else
		agregarOrdenado2 (a2^.HD, prestamo);
end;

procedure cargarArboles (var a1: arbol1; var a2: arbol2);
var
	prestamo: prestamoR1;
begin
	leerPrestamo (prestamo);
	while (prestamo.ISBN <> 0) do
		begin
			agregarOrdenado1 (a1, prestamo);
			agregarOrdenado2 (a2, prestamo);
			leerPrestamo (prestamo);
		end;
	writeln ('Finalizo la carga de los arboles');
end;

var
	a1: arbol1;
	a2: arbol2;
begin
	inicializarArboles (a1, a2);
	randomize;
	cargarArboles (a1, a2);
end.

{4. Una biblioteca nos ha encargado procesar la información de los préstamos realizados
durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio, día
y mes del préstamo y cantidad de días prestados. Implementar un programa con:
a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
los préstamos. La lectura de los préstamos finaliza con ISBN 0. Las estructuras deben
ser eficientes para buscar por ISBN
i. En una estructura cada préstamo debe estar en un nodo. Los ISBN repetidos
insertarlos a la derecha.
ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.
(prestar atención sobre los datos que se almacenan).}
