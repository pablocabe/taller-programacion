program Cap3Ej2a;

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
		readln (dia);
		writeln ('Ingrese el mes de la venta');
		readln (mes);
		writeln ('Ingrese el anio de la venta');
		readln (anio);
	end;
end;
procedure leerVenta (var venta: ventaR);
var
	fecha: fechaR;
begin
	writeln ('---------------');
	writeln ('Avanzamos con un nuevo producto');
	with venta do begin
		writeln ('Ingrese el codigo del producto');
		readln (codigo);
		if (codigo <> 0) then
			begin
				writeln ('El codigo del producto es distinto a 1');
				leerFecha (fecha);
				writeln ('Ingrese la cantidad de unidades vendidas');
				readln (cantidad);
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
	a := nil;
	leerVenta (venta);
	while (venta.codigo <> 0) do
		begin
			agregarOrdenado (a, venta);
			leerVenta (venta);
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
	cargarArbol (a);
	writeln ('Se empieza a recorrer el arbol ordenado por codigo de menor a mayor');
	recorrerArbol (a); // compruebo que se ordenó bien
end.

{2. Escribir un programa que:
a. Implemente un módulo que genere aleatoriamente información de ventas de un comercio.
Para cada venta generar código de producto, fecha y cantidad de unidades vendidas. Finalizar
con el código de producto 0. Un producto puede estar en más de una venta. Se pide:
i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de
producto. Los códigos repetidos van a la derecha.}
