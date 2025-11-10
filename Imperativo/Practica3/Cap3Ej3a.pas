program Cap3Ej3a;

type
	rangoDias = 1 .. 31;
	rangoMeses = 1 .. 12;
	rangoAnios = 2010 .. 2024;
	
	fechaR = record
		dia: rangoDias;
		mes: rangoMeses;
		anio: rangoAnios;
	end;
	
	finalR = record
		codigo: integer;
		fechas: fechaR;
		nota: real;
	end;
	
	lista = ^nodo2;
	nodo2 = record
		dato: finalR;
		sig: lista;
	end;
	
	alumnoR = record
		legajo: integer;
		listaFinales: lista;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato: alumnoR;
		HI: arbol;
		HD: arbol;
	end;
	
procedure leerFinal (var examen: finalR ; var legajo: integer);
begin
	legajo := random (100);
	if (legajo <> 0) then
		begin
			with examen do begin
				codigo := random (100) + 1;
				fechas.dia := random (31) + 1;
				fechas.mes := random (12) + 1;
				fechas.anio := random (2024) + 1;
				nota := random () * 9;
			end;
		end;
end;

procedure agregarAdelante (var L: lista; examen: finalR);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato := examen; 
	nuevo^.sig := L;
	L := nuevo;
end;

procedure agregarOrdenado (var a: arbol; examen: finalR; legajo: integer);
begin
	if (a = nil) then
		begin
			new (a);
			a^.dato.legajo := legajo;
			a^.dato.listaFinales := nil;
			agregarAdelante (a^.dato.listaFinales, examen);
			a^.HI := nil;
			a^.HD := nil;
		end
	else if (legajo = a^.dato.legajo) then
		agregarAdelante (a^.dato.listaFinales, examen)
	else if (legajo > a^.dato.legajo) then
		agregarOrdenado (a^.HD, examen, legajo)
	else
		agregarOrdenado (a^.HI, examen, legajo);
end;

procedure cargarArbol (var a: arbol);
var
	examen: finalR;
	legajo: integer;
begin
	leerFinal (examen, legajo);
	while (legajo <> 0) do
		begin
			agregarOrdenado (a, examen, legajo);
			leerFinal (examen, legajo);
		end;
	writeln ('Se ingreso el legajo 0');
end;

procedure recorrerArbol (a: arbol);
begin
	if (a <> nil) then
		begin
			recorrerArbol (a^.HI);
			writeln (a^.dato.legajo);
			recorrerArbol (a^.HD);
		end;
end;

var
	a: arbol;
begin
	a := nil;
	cargarArbol (a);
	recorrerArbol (a); // para verificar que se ordenaron los legajos
end.

{3. Implementar un programa que contenga:
a. Un módulo que lea información de los finales rendidos por los alumnos de la Facultad de
Informática y los almacene en una estructura de datos. La información que se lee es legajo,
código de materia, fecha y nota. La lectura de los alumnos finaliza con legajo 0. La estructura
generada debe ser eficiente para la búsqueda por número de legajo y para cada alumno deben
guardarse los finales que rindió en una lista.}
