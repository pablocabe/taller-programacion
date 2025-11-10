program Cap5Ej2a; 

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

procedure inicializarArboles (var a1: arbol1; var a2: arbol2);
begin
	a1 := nil;
	a2 := nil;
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

var
a1: arbol1;
a2: arbol2;
begin
	randomize;
	inicializarArboles (a1, a2);
	cargarArboles (a1, a2);
end.


{2. Una agencia dedicada a la venta de autos ha organizado su stock y, tiene la información de
los autos en venta. Implementar un programa que:
a) Genere la información de los autos (patente, año de fabricación (2010..2018), marca y
modelo, finalizando con marca ‘MMM’) y los almacene en dos estructuras de datos:
i. Una estructura eficiente para la búsqueda por patente.
ii. Una estructura eficiente para la búsqueda por marca. Para cada marca se deben
almacenar todos juntos los autos pertenecientes a ella.}
