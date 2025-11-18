program parcial6;

type
	
	registroLectura = record
		codigoComida: integer;
		codigoCliente: integer;
		categoriaEntrega: string;
	end;
	
	registroArbol = record
		codigoComida: integer;
		cantidadTotal: integer;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato: registroArbol;
		HI: arbol;
		HD: arbol;
	end;

	registroVector = record
		nombreCategoria: string;
		cantidad: integer;
	end;

	vector = array [1 .. 5] of registroVector;

procedure leerCompra (var compra: registroLectura);
var
	v: array [1 .. 5] of string = ('Full', 'Super', 'Media', 'Normal', 'Basica');
begin
	with compra do begin
		codigoCliente := random (200);
		if (codigoCliente <> 0) then
		begin
			codigoComida := random (200) + 1000;
			categoriaEntrega := v[random (5)+1];
		end;
	end;
end;

procedure inicializarVector (var v: vector);
var
	i: integer;
begin
	v[1].nombreCategoria := 'Full';
	v[2].nombreCategoria := 'Super';
	v[3].nombreCategoria := 'Media';
	v[4].nombreCategoria := 'Normal';
	v[5].nombreCategoria := 'Basica';
	for i := 1 to 5 do
		v[i].cantidad := 0;
end;

procedure agregarOrdenadoArbol (var a: arbol; codigoComida: integer);
begin
	if (a = nil) then
	begin
		new (a);
		a^.dato.codigoComida := codigoComida;
		a^.dato.cantidadTotal := 1;
		a^.HI := nil;
		a^.HD := nil;
	end
	else if (codigoComida = a^.dato.codigoComida) then
		a^.dato.cantidadTotal := a^.dato.cantidadTotal + 1
	else if (codigoComida > a^.dato.codigoComida) then
		agregarOrdenadoArbol (a^.HD, codigoComida)
	else
		agregarOrdenadoArbol (a^.HI, codigoComida)
end;

function convertirCategoria (categoriaEntrega: string): integer;
begin
	case categoriaEntrega of
		'Full': convertirCategoria := 1;
		'Super': convertirCategoria := 2;
		'Media': convertirCategoria := 3;
		'Normal': convertirCategoria := 4;
		'Basica': convertirCategoria := 5;
	end;
end;

procedure cargarDatos (var a: arbol; var v: vector);
var
	compra: registroLectura;
	numero: integer;
begin
	a := nil;
	inicializarVector (v);
	leerCompra (compra);
	while (compra.codigoCliente <> 0) do
	begin
		agregarOrdenadoArbol (a, compra.codigoComida);
		numero := convertirCategoria (compra.categoriaEntrega);
		v[numero].cantidad := v[numero].cantidad + 1; // no tiene sentido modularizar una linea de codigo sola
		leerCompra (compra);
	end;
end;

function calcularCantidad (a: arbol; codigoComidaX: integer): integer;
begin
	if (a = nil) then
		calcularCantidad := 0
	else if (codigoComidaX = a^.dato.codigoComida) then
		calcularCantidad := a^.dato.cantidadTotal
	else if (codigoComidaX > a^.dato.codigoComida) then
		calcularCantidad := calcularCantidad (a^.HD, codigoComidaX)
	else
		calcularCantidad := calcularCantidad (a^.HI, codigoComidaX);
end;

procedure ordenarVector (var v: vector; var categoriaMax: string);
var
	i, j, pos: integer;
	item: registroVector;
	dL: integer;
begin
	dL := 5;
	for i := 1 to (dL - 1) do
	begin
		pos := i;
		for j := (i+1) to dL do
			if (v[j].cantidad < v[pos].cantidad) then
				pos := j;
		item := v[pos];
		v[pos] := v[i];
		v[i] := item;
	end;
	categoriaMax := v[dL].nombreCategoria;
end;

procedure imprimirVector (v: vector; categoriaMax: string);
var
	i: integer;
begin
	for i := 1 to 5 do
	begin
		writeln ('La categoria de entrega es: ', v[i].nombreCategoria);
		writeln ('La cantidad es: ', v[i].cantidad);
	end;
	writeln ('La categoria maxima es: ', categoriaMax);
end;

var
	a: arbol;
	v: vector;
	codigoComidaX: integer;
	categoriaMax: string;
begin
	randomize;
	cargarDatos (a, v); // Inciso A
	writeln ('Ingrese un codigo de comida del cual se contabilizara su cantidad de compras: ');
	readln (codigoComidaX);
	writeln ('La cantidad de compras del codigo de comida ', codigoComidaX, ' es: ', calcularCantidad (a, codigoComidaX)); // Inciso B
	ordenarVector (v, categoriaMax); // Inciso C
	imprimirVector (v, categoriaMax); // Para controlar la ordenación del vector
end.
