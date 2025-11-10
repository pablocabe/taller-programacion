program parcial4;

type
	rangoSucursal = 1 .. 10;
	
	registroLectura = record
		codigoCliente: integer;
		codigoSucursal: rangoSucursal;
		numeroFactura: integer;
		monto: real;
	end;

	registroLista = record
		codigoSucursal: rangoSucursal;
		numeroFactura: integer;
		monto: real;
	end;

	lista = ^nodo2;
	nodo2 = record
		dato: registroLista;
		sig: lista;
	end;
	
	registroArbol = record
		codigoCliente: integer;
		montoTotal: real;
		listaVentas: lista;
	end;
	
	arbol = ^nodo1;
	nodo1 = record
		dato: registroArbol;
		HI: arbol;
		HD: arbol;
	end;
	
	vector = array [rangoSucursal] of integer;
	
procedure leerCompra (var compra: registroLectura);
begin
	compra.codigoCliente := random (100) + 1;
	compra.codigoSucursal := random (10) + 1;
	compra.numeroFactura := random (10000) + 1;
	compra.monto := random (2000) / (random (10) + 1);
end;

procedure inicializarArbol (var a: arbol);
begin
	a := nil;
end;

procedure inicializarVectorContador (var vC: vector);
var
	i: rangoSucursal;
begin
	for i := 1 to 10 do
		vC[i] := 0;
end;

procedure agregarAdelante (var L: lista; codigoSucursal: rangoSucursal; numeroFactura: integer; monto: real);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato.codigoSucursal := codigoSucursal;
	nuevo^.dato.numeroFactura := numeroFactura;
	nuevo^.dato.monto := monto;
	nuevo^.sig := L;
	L := nuevo;
end;

procedure agregarOrdenado (var a: arbol; compra: registroLectura);
begin
	if (a = nil) then
	begin
		new (a);
		a^.dato.codigoCliente := compra.codigoCliente;
		a^.dato.montoTotal := compra.monto;
		a^.dato.listaVentas := nil;
		agregarAdelante (a^.dato.listaVentas, compra.codigoSucursal, compra.numeroFactura, compra.monto);
		a^.HI := nil;
		a^.HD := nil;
	end
	else if (compra.codigoCliente = a^.dato.codigoCliente) then
	begin
		a^.dato.montoTotal := a^.dato.montoTotal + compra.monto;
		agregarAdelante (a^.dato.listaVentas, compra.codigoSucursal, compra.numeroFactura, compra.monto);
	end
	else if (compra.codigoCliente > a^.dato.codigoCliente) then
		agregarOrdenado (a^.HD, compra)
	else
		agregarOrdenado (a^.HI, compra);
end;

procedure cargarDatos (var a: arbol; var vC: vector);
var
	compra: registroLectura;
begin
	repeat
		leerCompra (compra);
		agregarOrdenado (a, compra);
		vC [compra.codigoSucursal] := vC [compra.codigoSucursal] + 1 // no tiene sentido modularizar una línea de código
	until (compra.codigoCliente = 1);
end;

function recorrerLista (L: lista; montoM: real): integer; // no pide que sea recursivo, prefiero recorrerlo con un while
var
	cantidadAuxiliar: integer;
begin
	cantidadAuxiliar := 0;
	while (L <> nil) do
	begin
		if (L^.dato.monto > montoM) then
			cantidadAuxiliar := cantidadAuxiliar + 1;
		L := L^.sig;
	end;
	recorrerLista := cantidadAuxiliar;
end;

function calcularCantidad (a: arbol; montoM: real): integer;
begin
	if (a^.HI = nil) then // entonces estoy en el codigo menor
		calcularCantidad := recorrerLista (a^.dato.listaVentas, montoM)
	else // entonces no estoy en el codigo menor ni el árbol está vacío
		calcularCantidad := calcularCantidad (a^.HI, montoM);
end;

procedure ordenarVector (var vC: vector); // se pierde la identificación de las sucursales, que estaban ordenadas de 1 a 10, no importa según el enunciado
var
	i, j, pos, dL: rangoSucursal;
	item: integer;
begin
	dL := 10;
	for i := 1 to (dL - 1) do
	begin
		pos := i;
		for j := (i+1) to dL do
			if (vC[j] > vC[pos]) then
				pos := j;
		item := vC[pos];
		vC[pos] := vC[i];
		 vC[i] := item;
	end;
end;

procedure imprimirVector (vC: vector);
var
	i: rangoSucursal;
begin
	for i := 1 to 10 do
		writeln (vC[i]);
end;

var
	a: arbol;
	vC: vector;
	montoM: real;
begin
	inicializarArbol (a);
	inicializarVectorContador (vC);
	cargarDatos (a, vC); // inciso A
	writeln ('Ingrese un monto: ');
	readln (montoM);
	writeln ('La cantidad de facturas cuyo monto es superior a ', montoM:2:2, ' es: ', calcularCantidad (a, montoM)); // inciso B
	ordenarVector (vC); // inciso C
	imprimirVector (vC);
end.

// el incisoB es muy tramposo. Como la carga de datos termina de procesarse con el códigoCliente 1, siempre va a poseer una sola compra
// Dicho de otra forma, el incisoB solo puede retornar los valores 0 o 1 dependiendo de si la única compra cargada supera a montoM
// Además el árbol nunca va a estar vacío porque siempre se procesa al menos una compra
