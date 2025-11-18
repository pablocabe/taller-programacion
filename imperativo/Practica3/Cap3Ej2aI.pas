program Cap3Ej2aI;

type

	rangoDias=  1 .. 31;
	rangoMeses= 1 .. 12;
	rangoAnios= 0 .. 2024;
	
	fechaR = record
		dia: rangoDias;
		mes: rangoMeses;
		anio: rangoAnios;
	end;
	
	ventaR = record
		codigo: integer;
		fechas: fechaR;
		cantidad: integer; 
	end;

	 arbol = ^nodo;
	 nodo = record
		dato: ventaR;
		HI: arbol;
		HD: arbol;
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
procedure leerVenta (var venta: ventaR);
begin
	writeln ('---------------');
	writeln ('Avanzamos con un nuevo producto');
	with venta do begin
		writeln ('Ingrese el codigo del producto');
		codigo := random (100);
		if (codigo <> 0) then
			begin
				leerFecha (venta.fechas);
				writeln ('Ingrese la cantidad de unidades vendidas');
				cantidad := random (100);
			end;
	end;
end;

procedure agregarOrdenado (var a: arbol; venta: ventaR);
begin
	if (a = nil) then
		begin
			new (a);
			 a^.dato := venta;
			 a^.HI := nil;
			 a^.HD := nil;
		end
	else
		if (venta.codigo < a^.dato.codigo) then
			agregarOrdenado (a^.HI, venta)
		else
			agregarOrdenado (a^.HD, venta)
end;

procedure cargarArbol (var a: arbol);
var
	venta: ventaR;
begin
	leerVenta (venta);
	if (venta.codigo <> 0) then
		begin
			agregarOrdenado (a, venta);
			cargarArbol (a);
		end;
end;

procedure recorrerArbol (a: arbol);
begin
  if (a <> nil) then
	begin
		recorrerArbol (a^.HI);
		writeln (a^.dato.codigo);
		recorrerArbol (a^.HD);
	end;
end;

var
a: arbol;
begin
	randomize;
	a := nil;
	cargarArbol (a);
	writeln ('---------------');
	writeln ('Se empieza a recorrer el arbol ordenado por codigo de menor a mayor');
	recorrerArbol (a); // compruebo que se ordenó bien
end.

{2. Escribir un programa que:
a. Implemente un módulo que genere aleatoriamente información de ventas de un comercio.
Para cada venta generar código de producto, fecha y cantidad de unidades vendidas. Finalizar
con el código de producto 0. Un producto puede estar en más de una venta. Se pide:
i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de
producto. Los códigos repetidos van a la derecha.}
