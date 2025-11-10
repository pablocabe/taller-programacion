program Cap5Ej3b; 

type
	rangoRubros = 1 .. 10;
	
	registroLectura = record
		codigo: integer;
		rubro: rangoRubros;
		stock: integer;
		precioUnitario: real;
	end;

	registroArbol = record
		codigo: integer;
		stock: integer;
		precioUnitario: real;
	end;
	
	arbol = ^nodo1;
	nodo1 = record
		dato: registroArbol;
		HI: arbol;
		HD: arbol;
	end;
	
	vector = array [rangoRubros] of arbol;

procedure inicializarArboles (var v: vector);
var
	i: rangoRubros;
begin
	for i:= 1 to 10 do
		v[i] := nil;
end;

procedure leerProducto (var producto: registroLectura);
begin
	with producto do begin
		codigo := random (1000);
		if (codigo <> 0) then
		begin
			rubro := random (10) + 1;
			stock := random (1000);
			precioUnitario := random () * 9;
		end;
	end;
end;

procedure agregarOrdenado (var a: arbol; codigo, stock: integer; precioUnitario: real);
begin
	if (a = nil) then
	begin
		new (a);
		a^.dato.codigo := codigo;
		a^.dato.stock := stock;
		a^.dato.precioUnitario := precioUnitario;
		a^.HI := nil;
		a^.HD := nil;
	end
	else if (codigo < a^.dato.codigo) then
		agregarOrdenado (a^.HI, codigo, stock, precioUnitario)
	else
		agregarOrdenado (a^.HD, codigo, stock, precioUnitario); // los codigos repetidos van hacia la derecha
end;

procedure cargarDatos (var v: vector);
var
	producto: registroLectura;
begin
	inicializarArboles (v);
	leerProducto (producto);
	while (producto.codigo <> 0) do
	begin
		agregarOrdenado (v[producto.rubro], producto.codigo, producto.stock, producto.precioUnitario);
		leerProducto (producto);
	end;
end;

var
	v: vector;
	rubroX: rangoRubros;
	codigoX: integer;
begin
	cargarDatos (v);
	writeln ('Ingrese un rubro: ');
	readln (rubroX);
	writeln ('Ingrese un codigo de producto: ');
	readln (codigoX);
end.

{3.Un supermercado requiere el procesamiento de sus productos. De cada producto se
conoce código, rubro (1..10), stock y precio unitario. Se pide:
a) Generar una estructura adecuada que permita agrupar los productos por rubro. A su
vez, para cada rubro, se requiere que la búsqueda de un producto por código sea lo
más eficiente posible. El ingreso finaliza con el código de producto igual a 0.
b) Implementar un módulo que reciba la estructura generada en a), un rubro y un código
de producto y retorne si dicho código existe o no para ese rubro.}
