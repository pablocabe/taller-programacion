program parcial2; 

type
	rangoMeses = 1 .. 12;
	
	alquilerR = record // por qué junto al enunciado, en los codigos auxiliares, te dan este registro declarado acá pero en realidad va separado?
		DNI: integer;
		mes: rangoMeses;
		anio: integer;
	end;
	
	lista = ^nodo2;
	nodo2 = record
		dato: alquilerR;
		sig: lista;
	end;
	
	arbolR = record
		patente: integer;
		listaAlquileres: lista;
	end;
	
	arbol = ^nodo1;
	nodo1 = record
		dato: arbolR;
		HI: arbol;
		HD: arbol;
	end;

procedure inicializarArbol (var a: arbol);
begin
	a := nil;
end;

procedure leerAlquiler (var alquiler: alquilerR; var patenteAux: integer);
begin
	patenteAux := random (200);
	writeln ('La patente asignada fue: ', patenteAux);
	if (patenteAux <> 0) then
		begin
			alquiler.dni := random (100) + 1;
			alquiler.mes := random (12) + 1;
			alquiler.anio := random (24) + 2000;
			writeln ('El año asignado fue: ', alquiler.anio);
		end;
end;

procedure agregarAdelante (var L: lista; alquiler: alquilerR);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato := alquiler;
	nuevo^.sig := L;
	L := nuevo;
end;

procedure agregarOrdenado (var a: arbol; alquiler: alquilerR; patenteAux: integer);
begin
	if (a = nil) then
		begin
			new (a);
			a^.dato.listaAlquileres := nil;
			a^.dato.patente := patenteAux;
			agregarAdelante (a^.dato.listaAlquileres, alquiler);
			a^.HI := nil;
			a^.HD := nil;
		end
	else if (patenteAux = a^.dato.patente) then
		agregarAdelante (a^.dato.listaAlquileres, alquiler)
	else if (patenteAux > a^.dato.patente) then
		agregarOrdenado (a^.HD, alquiler, patenteAux)
	else
		agregarOrdenado (a^.HI, alquiler, patenteAux);
end;

procedure cargarArbol (var a: arbol);
var
	alquiler: alquilerR;
	patenteAux: integer; // esta patenteAux es necesaria?
begin
	leerAlquiler (alquiler, patenteAux);
	while (patenteAux <> 0) do
		begin
			agregarOrdenado (a, alquiler, patenteAux);
			leerAlquiler (alquiler, patenteAux);
		end;
end;

function cantidad (L: lista; DNIX: integer): integer;
begin
	cantidad := 0;
	while (L <> nil) do
		begin
			if (L^.dato.DNI = DNIX) then
				cantidad := cantidad + 1;
			L := L^.sig;
		end;
end;

function incisoB (a: arbol; DNIX: integer): integer;
var
	sumoLista: integer;
begin
	if (a = nil) then // está bien esto o es mejor preguntar si es distinto de nil?
		incisoB := 0 
	else
		begin
			incisoB := 0;
			sumoLista := cantidad (a^.dato.listaAlquileres, DNIX);
			incisoB := incisoB + sumoLista;
			incisoB := incisoB + incisoB (a^.HI, DNIX);
			incisoB := incisoB  + incisoB (a^.HD, DNIX);
		end;
end;

procedure ingresoDatosIncisoC (var anioX, patenteA, patenteB: integer);
begin
	writeln ('Ingrese un anio');
	readln (anioX);
	writeln ('Ingrese la patente A');
	readln (patenteA);
	writeln ('Ingrese la patente B');
	readln (patenteB);
end;

function cantidadAlquileresLista (L: lista; anioX: integer): integer;
begin
	cantidadAlquileresLista := 0;
	while (L <> nil) do
		begin
			if (L^.dato.anio = anioX) then
				cantidadAlquileresLista := cantidadAlquileresLista + 1;
			L := L^.sig;
		end;
end;

function incisoC (a: arbol; patenteA, patenteB, anioX: integer): integer;
begin
	if (a = nil) then
		incisoC := 0
	else
		begin
			incisoC := 0; // siempre hay que inicializar en 0 la función sumadora
			if (a^.dato.patente >= patenteA) and (a^.dato.patente <= patenteB) then
				incisoC := cantidadAlquileresLista (a^.dato.listaAlquileres, anioX);
			if (a^.dato.patente > patenteA) then
				incisoC := incisoC + incisoC (a^.HI, patenteA, patenteB, anioX);
			if (a^.dato.patente < patenteB) then
				incisoC := incisoC + incisoC (a^.HD, patenteA, patenteB, anioX);
		end;
end;

var
	a: arbol;
	DNIX, anioX, patenteA, patenteB: integer;
begin
	randomize;
	inicializarArbol (a);
	cargarArbol (a);
	writeln ('Ingrese el DNI del cual se informara la cantidad de alquileres realizados');
	readln (DNIX);
	writeln ('La cantidad de alquileres realizados por el DNI ', DNIX, ' es : ', incisoB (a, DNIX));
	ingresoDatosIncisoC (anioX, patenteA, patenteB); // está bien hacer este módulo aunque el último renglón del enunciado no lo pida?
	writeln ('La cantidad de alquileres realizados para las patentes entre ', patenteA, ' y ', patenteB, ' durante el anio ', anioX, ' fue: ', incisoC (a, patenteA, patenteB, anioX));
end.
