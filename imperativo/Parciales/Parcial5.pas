program parcial5;

type

	registroLectura = record
		matricula: integer;
		DNI: integer;
		mes: integer;
		diagnostico: char;
	end;

	registroArbol = record
		DNI: integer; // se ordena por DNI
		diagnostico: char;
	end;
	
	arbol = ^nodo1;
	nodo1 = record
		dato: registroArbol;
		HI: arbol;
		HD: arbol;
	end;
	
	vector = array [1 .. 12] of arbol; // preferiria usar un rangoMes de 1 a 12 pero en la declaracion del codigo auxiliar no está
	
procedure leerAtencion (var atencion: registroLectura);
var
	v: array [1 .. 5] of char = ('L', 'M', 'N', 'O', 'P');
begin
	with atencion do begin
		matricula := random (10000);
		if (matricula <> 0) then
		begin
			DNI := random (5000) + 1000;
			mes := random (12) + 1;
			diagnostico := v[random (5) + 1];
		end;
	end;
end;

procedure inicializarArboles (var v: vector);
var
	i: integer;
begin
	for i := 1 to 12 do
		v[i] := nil;
end;

procedure agregarOrdenadoPorDNI (var a: arbol; DNI: integer; diagnostico: char);
begin
	if (a = nil) then
	begin
		new (a);
		a^.dato.DNI := DNI;
		a^.dato.diagnostico := diagnostico;
		a^.HI := nil;
		a^.HD := nil;
	end
	else if (DNI  >= a^.dato.DNI) then
		agregarOrdenadoPorDNI (a^.HD, DNI, diagnostico)
	else
		agregarOrdenadoPorDNI (a^.HI, DNI, diagnostico);
end;

procedure cargarDatos (var v: vector);
var
	atencion: registroLectura;
begin
	inicializarArboles(v);
	leerAtencion (atencion);
	while (atencion.matricula <> 0) do
	begin
		agregarOrdenadoPorDNI (v[atencion.mes], atencion.DNI, atencion.diagnostico);
		leerAtencion (atencion);
	end;
end;

function recorrerArbolIncisoB (a: arbol): integer;
begin
	if (a = nil) then
		recorrerArbolIncisoB := 0
	else
		recorrerArbolIncisoB := 1 + recorrerArbolIncisoB (a^.HI) + recorrerArbolIncisoB (a^.HD);
end;

procedure incisoB (v: vector; var mesMaximo: integer; pos: integer; var cantidadMaxima: integer);
var
	cantidadActual: integer;
begin
	if (pos <= 12) then
	begin
		cantidadActual := recorrerArbolIncisoB (v[pos]); // le estoy pasando un árbol
		if (cantidadActual > cantidadMaxima) then
		begin
			cantidadMaxima := cantidadActual;
			mesMaximo := pos;
		end;
		incisoB (v, mesMaximo, pos+1, cantidadMaxima);
	end;
end;

function recorrerArbol (a: arbol; DNIX: integer): boolean;
begin
	if (a = nil) then
		recorrerArbol := false
	else if (DNIX = a^.dato.DNI) then
		recorrerArbol := true
	else if (DNIX > a^.dato.DNI) then
		recorrerArbol := recorrerArbol (a^.HD, DNIX)
	else
		recorrerArbol := recorrerArbol (a^.HI, DNIX);
end;

function buscarDNI (v: vector; DNIX: integer): boolean;
var
	booleanAux: boolean;
	arbolNumero: integer;
begin
	booleanAux := false;
	arbolNumero := 1;
	while (booleanAux = false) and (arbolNumero < 13) do
	begin
		booleanAux := recorrerArbol (v[arbolNumero], DNIX);
		arbolNumero := arbolNumero + 1;
	end;
	buscarDNI := booleanAux;
end;

var
	v: vector;
	DNIX, mesMaximo, pos, cantidadMaxima: integer;
begin
	randomize;
	cargarDatos (v); // Inciso A
	mesMaximo := 0;
	cantidadMaxima := 0;
	pos := 1;
	incisoB (v, mesMaximo, pos, cantidadMaxima); // Inciso B
	writeln ('El mes con mayor cantidad de atenciones fue: ', mesMaximo); 
	writeln ('Ingrese el DNI a buscar: ');
	readln (DNIX);
	if (buscarDNI (v, DNIX)) then // Inciso C
		writeln ('El paciente con el DNI ', DNIX, ' fue atendido')
	else
		writeln ('El paciente con el DNI ', DNIX, ' no fue atendido');
end.
