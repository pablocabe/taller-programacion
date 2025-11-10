program Cap5Ej4a; 

type

	registroLectura = record
		codigo: integer;
		DNI: integer;
		anio: integer;
		tipoReclamo: integer;
	end;
	
	registroLista = record
		codigo: integer;
		anio: integer;
		tipoReclamo: integer;
	end;
	
	lista = ^nodo2;
	nodo2 = record
		dato: registroLista;
		sig: lista;
	end;

	registroArbol = record
		DNI: integer;
		cantidadReclamos: integer;
		listaReclamos: lista;
	end;
	
	arbol = ^nodo1;
	nodo1 = record
		dato: registroArbol;
		HI: arbol;
		HD: arbol;
	end;

procedure inicializarArbol (var a: arbol);
begin
	a := nil;
end;

procedure leerReclamo (var reclamo: registroLectura);
begin
	with reclamo do begin
		codigo := random (1000);
		if (codigo <> 0) then
		begin
			DNI := random (30000);
			anio := random (2024) + 1;
			tipoReclamo := random (10) + 1;
		end;
	end;
end;

procedure agregarAdelante (var L: lista; codigo: integer; anio: integer; tipoReclamo: integer);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato.codigo := codigo;
	nuevo^.dato.anio := anio;
	nuevo^.dato.tipoReclamo := tipoReclamo;
	nuevo^.sig := L;
	L := nuevo;
end;

procedure crearNodo (var a: arbol; reclamo: registroLectura);
begin
	new (a);
	a^.dato.DNI := reclamo.DNI;
	a^.dato.listaReclamos := nil;
	a^.dato.cantidadReclamos := 1;
	agregarAdelante (a^.dato.listaReclamos, reclamo.codigo, reclamo.anio, reclamo.tipoReclamo);
	a^.HI := nil;
	a^.HD := nil;
end;

procedure agregarOrdenado (var a: arbol; reclamo: registroLectura);
begin
	if (a = nil) then
	begin
		crearNodo (a, reclamo);
	end
	else if (reclamo.DNI = a^.dato.DNI) then
	begin
		a^.dato.cantidadReclamos := a^.dato.cantidadReclamos + 1;
		agregarAdelante (a^.dato.listaReclamos, reclamo.codigo, reclamo.anio, reclamo.tipoReclamo);
	end
	else if (reclamo.DNI > a^.dato.DNI) then
		agregarOrdenado (a^.HD, reclamo)
	else
		agregarOrdenado (a^.HI, reclamo);
end;

procedure cargarArbol (var a: arbol);
var
	reclamo: registroLectura;
begin
	leerReclamo (reclamo);
	while (reclamo.codigo <> 0) do
	begin
		agregarOrdenado (a, reclamo);
		leerReclamo (reclamo);
	end;
end;

var
	a: arbol;
begin
	randomize;
	inicializarArbol (a);
	cargarArbol (a);
end.

{4. Una oficina requiere el procesamiento de los reclamos de las personas. De cada reclamo
se ingresa código, DNI de la persona, año y tipo de reclamo. El ingreso finaliza con el
código de igual a 0. Se pide:
a) Un módulo que retorne estructura adecuada para la búsqueda por DNI. Para cada DNI
se deben tener almacenados cada reclamo y la cantidad total de reclamos que realizó.}
