program parcial7;

type
	
	registroLectura = record
		matricula: integer;
		DNI: integer;
		dia: integer;
		diagnostico: char;
	end;
	
	registroArbol = record
		matricula: integer;
		cantidad: integer;
	end;
	
	arbol = ^nodo1;
	nodo1 = record
		dato: registroArbol;
		HI: arbol;
		HD: arbol;
	end;
	
	lista = ^nodo2;
	nodo2 = record
		dato: integer; // es el DNI
		sig: lista;
	end;
	
	registroVector = record
		nombreGenero: string;
		listaDNI: lista;
	end;
	
	vector = array [1 .. 6] of registroVector;
	
procedure inicializarVector (var v: vector);
var
	i: integer;
begin
	v[1].nombreGenero := 'A';
	v[2].nombreGenero := 'B';
	v[3].nombreGenero := 'C';
	v[4].nombreGenero := 'D';
	v[5].nombreGenero := 'E';
	v[6].nombreGenero := 'F';
	for i := 1 to 6 do
		v[i].listaDNI := nil;
end;
	
procedure leerAtencion (var atencion: registroLectura);
var
	v: array [1 .. 6] of char = ('A', 'B', 'C', 'D', 'E', 'F');
begin
	with atencion do begin
		DNI := random (5000);
		if (DNI <> 0) then
		begin
			matricula := random (1000) + 2000;
			dia := random (31) + 1;
			diagnostico := v[random (6) + 1];
		end;
	end;
end;

procedure cargarOrdenadoArbol (var a: arbol; matricula: integer);
begin
	if (a = nil) then
	begin
		new (a);
		a^.dato.matricula := matricula;
		a^.dato.cantidad := 1;
		a^.HI := nil;
		a^.HD := nil;
	end
	else if (matricula = a^.dato.matricula) then
		a^.dato.cantidad := a^.dato.cantidad + 1
	else if (matricula > a^.dato.matricula) then
		cargarOrdenadoArbol (a^.HD, matricula)
	else
		cargarOrdenadoArbol (a^.HI, matricula);
end;

function convertirDiagnostico (diagnostico: char): integer;
begin
	case diagnostico of
		'A': convertirDiagnostico := 1;
		'B': convertirDiagnostico := 2;
		'C': convertirDiagnostico := 3;
		'D': convertirDiagnostico := 4;
		'E': convertirDiagnostico := 5;
		'F': convertirDiagnostico := 6;
	end;
end;

procedure agregarAdelante (var L: lista; DNI: integer);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato := DNI;
	nuevo^.sig := L;
	L := nuevo;
end;

procedure cargarDatos (var a: arbol; var v: vector);
var
	atencion: registroLectura;
	numero: integer;
begin
	a := nil;
	inicializarVector (v);
	leerAtencion (atencion);
	while (atencion.DNI <> 0) do
	begin
		cargarOrdenadoArbol (a, atencion.matricula);
		numero := convertirDiagnostico(atencion.diagnostico);
		agregarAdelante (v[numero].listaDNI, atencion.DNI);
		leerAtencion (atencion);
	end;
end;

var
	a: arbol;
	v: vector;
	matriculaX: integer;
begin
	cargarDatos (a, v); // IncisoA
	writeln ('Ingrese una matricula');
	readln (matriculaX);
	writeln ('La cantidad de atenciones realizadas por medicos con matriculas superiores a la matricula ', matriculaX, ' es: ', calcularIncisoB(a, matriculaX));
end.
