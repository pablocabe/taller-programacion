program Cap4Ej4ai; 

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
	
	arbol1 = ^nodo1;
	nodo1 = record
		dato: prestamoR1;
		HI: arbol1;
		HD: arbol1;
	end;

procedure inicializarArboles (var a1: arbol1);
begin
	a1 := nil;
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

procedure agregarOrdenado1 (var a1: arbol1; prestamo: prestamoR1);
begin
	if (a1 = nil) then
		begin
			new (a1);
			a1^.dato := prestamo;
			a1^.HI := nil;
			a1^.HD := nil;
		end
	else if (prestamo.ISBN < a1^.dato.ISBN) then
		agregarOrdenado1 (a1^.HI, prestamo)
	else
		agregarOrdenado1 (a1^.HD, prestamo);
end;

procedure cargarArboles (var a1: arbol1);
var
	prestamo: prestamoR1;
begin
	leerPrestamo (prestamo);
	while (prestamo.ISBN <> 0) do
		begin
			agregarOrdenado1 (a1, prestamo);
			leerPrestamo (prestamo);
		end;
	writeln ('Finalizo la carga de los arboles');
end;

var
	a1: arbol1;
begin
	inicializarArboles (a1);
	randomize;
	cargarArboles (a1);
end.

{4. Una biblioteca nos ha encargado procesar la información de los préstamos realizados
durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio, día
y mes del préstamo y cantidad de días prestados. Implementar un programa con:
a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
los préstamos. La lectura de los préstamos finaliza con ISBN 0. Las estructuras deben
ser eficientes para buscar por ISBN
i. En una estructura cada préstamo debe estar en un nodo. Los ISBN repetidos
insertarlos a la derecha.}
