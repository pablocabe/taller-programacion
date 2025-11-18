program parcial3; 
	
type
	rangoSocios = 1 .. 1500;
	rangoMeses = 1 .. 12;
	
	registroLectura = record
		codigoSocio: rangoSocios;
		codigoLibro: integer;
		mes: rangoMeses;
	end;

	arbol1 = ^nodo1;
	nodo1 = record
		dato: registroLectura; // no es necesario crear un registroArbol, se utilizan los mismos campos que en la lectura 
		HI: arbol1;
		HD: arbol1;
	end;
	
	registroVector = record
		codigoSocio: rangoSocios;
		codigoLibro: integer;
	end;
	
	lista = ^nodo2;
	nodo2 = record
		dato: registroVector;
		sig: lista;
	end;
	
	vector = array [rangoMeses] of lista;

procedure inicializarArbol (var a1: arbol1);
begin
	a1 := nil;
end;

procedure leerPrestamo (var prestamo: registroLectura);
begin
	prestamo.codigoLibro := random (30001);
	if (prestamo.codigoLibro <> 0) then
	begin
		prestamo.codigoSocio := random (1500) + 1;
		prestamo.mes :=  random (12) + 1;
	end;
end;

procedure agregarOrdenado (var a1: arbol1; prestamo: registroLectura);
begin
	if (a1 = nil) then
	begin
		new (a1);
		a1^.dato := prestamo;
		a1^.HI := nil;
		a1^.HD := nil;
	end
	else if (prestamo.codigoSocio < a1^.dato.codigoSocio) then
		agregarOrdenado (a1^.HI, prestamo)
	else
		agregarOrdenado (a1^.HD, prestamo);
end;

procedure cargarArbol (var a1: arbol1);
var
	prestamo: registroLectura;
begin
	leerPrestamo (prestamo);
	while (prestamo.codigoLibro <> 0) do
	begin
		agregarOrdenado (a1, prestamo);
		leerPrestamo (prestamo);
	end;
end;

procedure inicializarListas (var v: vector);
var
	i: rangoMeses;
begin
	for i := 1 to 12 do
		v[i] := nil;
end;

procedure agregarAdelante (var L: lista; codigoSocio: rangoSocios; codigoLibro: integer);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato.codigoSocio := codigoSocio;
	nuevo^.dato.codigoLibro := codigoLibro;
	nuevo^.sig := L;
	L := nuevo;
end;

procedure recorrerArbol (a1: arbol1; codigoX: integer; var v: vector);
begin
	if (a1 <> nil) then
	begin
		if (a1^.dato.codigoSocio > codigoX) then
		begin	
			agregarAdelante (v[a1^.dato.mes], a1^.dato.codigoSocio, a1^.dato.codigoLibro); // agrego al mes correspondiente
			recorrerArbol (a1^.HI, codigoX, v);
		end;
		recorrerArbol (a1^.HD, codigoX, v);
	end;
end;

procedure cargarVector (a1: arbol1; codigoX: integer; var v: vector);
begin
	inicializarListas (v);
	recorrerArbol (a1, codigoX, v);
end;

function calcularPrestamosMes (L: lista): integer; // el enunciado me pide enviar la estructura generada en B y un mes, está bien?
begin
	if (L = nil) then
		calcularPrestamosMes := 0
	else
		calcularPrestamosMes :=  calcularPrestamosMes (L^.sig) + 1;
end;

var
	a1: arbol1;
	v: vector; // es un vector de 12 listas
	codigoX: rangoSocios;
	mesX: rangoMeses;
begin
	randomize;
	inicializarArbol (a1);
	cargarArbol (a1); // Inciso A
	writeln ('Ingrese un codigo de socio: ');
	readln (codigoX);
	cargarVector (a1, codigoX, v); // inciso B
	writeln ('Ingrese un mes: ');
	readln (mesX);
	writeln ('La cantidad de prestamos realizados en el mes ', mesX, ' fue: ', calcularPrestamosMes (v[mesX])); // inciso C
end.
