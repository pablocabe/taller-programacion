program Cap5Ej2e; 

type
	rangoAnios = 2010 .. 2018;
	
	autosR1 = record // es para el arbol1
		patente: integer;
		anio: rangoAnios;
		marca: string;
		modelo: integer;
	end;
	
	autosR2 = record // es para la lista del arbol2
		patente: integer;
		anio: rangoAnios;
		modelo: integer;
	end;
	
	autosR3 = record
		patente: integer;
		marca: string;
		modelo: integer;
	end;

	arbol1 = ^nodo1;
	nodo1 = record
		dato: autosR1; // creo que esto está bien porque es eficiente de igual forma para la búsqueda por patente, se puede acceder a ella
		HI: arbol1;
		HD: arbol1;
	end;

	lista = ^nodo3;
	nodo3 = record
		dato: autosR2;
		sig: lista;
	end;

	arbol2R = record // este es el registro del arbol2, que contiene una marca y todos los autos pertenecientes a ella en una lista
		marca: string;
		autosLista: lista;
	end;
	
	arbol2 = ^nodo2;
	nodo2 = record
		dato: arbol2R;
		HI: arbol2;
		HD: arbol2;
	end;
	
	listaD = ^nodo5;
	nodo5 = record
		dato: autosR3;
		sig: listaD;
	end;
	
	arbol3R = record
		anio: rangoAnios;
		aniosLista: listaD;
	end;
	
	arbol3 = ^nodo4;
	nodo4 = record
		dato: arbol3R;
		HI: arbol3;
		HD: arbol3;
	end;

procedure inicializarArboles (var a1: arbol1; var a2: arbol2; var a3: arbol3);
begin
	a1 := nil;
	a2 := nil;
	a3 := nil;
end;

procedure leerAuto (var auto: autosR1);
begin
	writeln ('---------------');
	with auto do begin
		writeln ('Ingrese la marca del auto');
		readln (marca);
		if (marca <> 'MMM') then
		begin
			writeln ('La marca ingresada es: ', marca);
			patente := random (1000);
			writeln ('La patente ingresada es: ', patente);
			anio := random (9) + 2010;
			writeln ('El anio ingresado es: ', anio);
			modelo := random (1000);
			writeln ('El modelo ingresado es: ', modelo);
		end;
	end;
end;

procedure agregarOrdenadoArbol1 (var a1: arbol1; auto: autosR1);
begin
	if (a1 = nil) then
	begin
		new (a1);
		a1^.dato := auto;
		a1^.HI := nil;
		a1^.HD := nil;
	end
	else if (auto.patente < a1^.dato.patente) then
		agregarOrdenadoArbol1 (a1^.HI, auto)
	else 
		agregarOrdenadoArbol1 (a1^.HD, auto);
end;

procedure copiarValores (var autosLista: autosR2; auto: autosR1);
begin
	autosLista.patente := auto.patente;
	autosLista.anio := auto.anio;
	autosLista.modelo := auto.modelo;
end;

procedure agregarAdelanteArbol2 (var L: lista; autosLista: autosR2);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato := autosLista;
	nuevo^.sig := L;
	L := nuevo;
end;

procedure agregarOrdenadoArbol2 (var a2: arbol2; marca: string; autosLista: autosR2);
begin
	if (a2 = nil) then
	begin
		new (a2);
		a2^.dato.marca := marca;
		a2^.dato.autosLista := nil;
		agregarAdelanteArbol2 (a2^.dato.autosLista, autosLista);
		a2^.HI := nil;
		a2^.HD := nil;
	end
	else if (marca = a2^.dato.marca) then
		agregarAdelanteArbol2 (a2^.dato.autosLista, autosLista)
	else if (marca > a2^.dato.marca) then
		agregarOrdenadoArbol2 (a2^.HD, marca, autosLista)
	else
		agregarOrdenadoArbol2 (a2^.HI, marca, autosLista)
end;

procedure cargarArboles (var a1: arbol1; var a2: arbol2);
var
	auto: autosR1;
	autosLista: autosR2;
begin
	leerAuto (auto);
	while (auto.marca <> 'MMM') do
	begin
		agregarOrdenadoArbol1 (a1, auto);
		copiarValores (autosLista, auto);
		agregarOrdenadoArbol2 (a2, auto.marca, autosLista);
		leerAuto (auto);
	end;
end;

function incisoB (a1: arbol1; marcaX: string): integer;
begin
	if (a1 = nil) then 
		incisoB := 0
	else begin
		incisoB := 0;
		if (marcaX = a1^.dato.marca) then
			incisoB := incisoB + 1;
		incisoB := incisoB + incisoB (a1^.HI, marcaX);
		incisoB := incisoB + incisoB (a1^.HD, marcaX);
	end;
end;

function recorrerLista (L: lista): integer;
begin
	recorrerLista := 0;
	while (L <> nil) do
	begin
		recorrerLista := recorrerLista + 1;
		L := L^.sig;
	end;
end;

function incisoC (a2: arbol2; marcaX: string): integer;
begin
	if (a2 = nil) then
		incisoC := 0
	else begin
		incisoC := 0;
		if (marcaX = a2^.dato.marca) then
			incisoC := recorrerLista (a2^.dato.autosLista)
		else if (marcaX > a2^.dato.marca) then
			incisoC := incisoC (a2^.HD, marcaX)
		else
			incisoC := incisoC (a2^.HI, marcaX);
	end;
end;

procedure copiarValores3 (auto: autosR1; var auto3: autosR3);
begin
	auto3.patente := auto.patente;
	auto3.marca := auto.marca;
	auto3.modelo := auto.modelo;
end;

procedure agregarAdelanteArbol3 (var L: listaD; auto3: autosR3);
var
	nuevo: listaD;
begin
	new (nuevo);
	nuevo^.dato := auto3;
	nuevo^.sig := L;
	L := nuevo;
end;

procedure agregarOrdenadoArbol3 (var a3: arbol3; auto3: autosR3; anioActual: rangoAnios);
begin
	if (a3 = nil) then
	begin
		new (a3);
		a3^.dato.aniosLista := nil;
		a3^.dato.anio := anioActual;
		agregarAdelanteArbol3 (a3^.dato.aniosLista, auto3);
		a3^.HI := nil;
		a3^.HD := nil;
	end
	else if (anioActual = a3^.dato.anio) then
		agregarAdelanteArbol3 (a3^.dato.aniosLista, auto3)
	else if (anioActual > a3^.dato.anio) then
		agregarOrdenadoArbol3 (a3^.HD, auto3, anioActual)
	else
		agregarOrdenadoArbol3 (a3^.HI, auto3, anioActual)
end;

procedure cargarArbol3 (a1: arbol1; var a3: arbol3);
var
	auto3: autosR3;
begin
	if (a1 <> nil) then
	begin
		cargarArbol3 (a1^.HI, a3);
		copiarValores3 (a1^.dato, auto3);
		agregarOrdenadoArbol3 (a3, auto3, a1^.dato.anio);
		cargarArbol3 (a1^.HD, a3);
	end;
end;

function incisoE (a1: arbol1; patenteX: integer): integer;
begin
	if (a1 = nil) then
		incisoE := -1 // si la patente no existe devuelve -1
	else if (patenteX = a1^.dato.patente) then
		incisoE := a1^.dato.modelo
	else if (patenteX > a1^.dato.patente) then
		incisoE := incisoE (a1^.HD, patenteX)
	else
		incisoE := incisoE (a1^.HI, patenteX);
end;

var
a1: arbol1;
a2: arbol2;
a3: arbol3;
marcaX: string;
patenteX: integer;
begin
	randomize;
	inicializarArboles (a1, a2, a3);
	cargarArboles (a1, a2);
	writeln ('Ingrese la marca de la cual se buscara la cantidad de autos que posee');
	readln (marcaX);
	writeln ('La cantidad de autos de la marca ', marcaX, ' es: ', incisoB (a1, marcaX));
	writeln ('Ingrese otra marca de la cual se buscara la cantidad de autos que posee');
	readln (marcaX);
	writeln ('La cantidad de autos de la marca ', marcaX, ' es: ', incisoC (a2, marcaX));
	cargarArbol3 (a1, a3);
	writeln ('El tercer arbol fue cargado con exito');
	writeln ('Ingrese la patente de cual se informara su modelo de auto');
	readln (patenteX);
	writeln ('El modelo del auto de la patente ', patenteX, ' es: ', incisoE (a1, patenteX));
end.


{2. Una agencia dedicada a la venta de autos ha organizado su stock y, tiene la información de
los autos en venta. Implementar un programa que:
a) Genere la información de los autos (patente, año de fabricación (2010..2018), marca y
modelo, finalizando con marca ‘MMM’) y los almacene en dos estructuras de datos:
i. Una estructura eficiente para la búsqueda por patente.
ii. Una estructura eficiente para la búsqueda por marca. Para cada marca se deben
almacenar todos juntos los autos pertenecientes a ella.
b) Invoque a un módulo que reciba la estructura generado en a) i y una marca y retorne la
cantidad de autos de dicha marca que posee la agencia.
c) Invoque a un módulo que reciba la estructura generado en a) ii y una marca y retorne
la cantidad de autos de dicha marca que posee la agencia.
d) Invoque a un módulo que reciba el árbol generado en a) i y retorne una estructura con
la información de los autos agrupados por año de fabricación.
e) Invoque a un módulo que reciba el árbol generado en a) i y una patente y devuelva el
modelo del auto con dicha patente.}
