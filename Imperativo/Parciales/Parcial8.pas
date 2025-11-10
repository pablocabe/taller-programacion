program parcial8;

type
	subMaterial = 1 .. 8;
	
	registroLectura = record
		DNI: integer;
		codArtesania: integer;
		material: subMaterial;
	end;
	
	registroVector = record
		material: subMaterial; // acá no se si lo declaré así o puse codigo o codArtesanía
		cantidad: integer;
	end;
	
	registroArbol = record
		DNI: integer;
		cantidadTotal: integer;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato: registroArbol;
		HI: arbol;
		HD: arbol;
	end;
	
	vector = array [subMaterial] of registroVector;

procedure inicializarVector (var v: vector);
var
	i: subMaterial;
begin
	for i := 1 to 8 do
	begin
		v[i].material := i;
		v[i].cantidad := 0;
	end;
end;

procedure leerArtesania (var artesania: registroLectura);
begin
	with artesania do begin
		DNI := random (10000);
		if (DNI <> 0) then
		begin
			codArtesania := random (100) + 2000;
			material := random (8) + 1;
		end;
	end;
end;

procedure cargarArbolOrdenado (var a: arbol; DNI: integer);
begin
	if (a = nil) then
	begin
		new (a);
		a^.dato.DNI := DNI;
		a^.dato.cantidadTotal := 1;
		a^.HI := nil;
		a^.HD := nil;
	end
	else if (DNI = a^.dato.DNI) then
		a^.dato.cantidadTotal := a^.dato.cantidadTotal + 1
	else if (DNI > a^.dato.DNI) then
		cargarArbolOrdenado (a^.HD, DNI)
	else
		cargarArbolOrdenado (a^.HI, DNI);
end;

procedure cargarDatos (var a: arbol; var v: vector);
var
	artesania: registroLectura;
begin
	a := nil;
	inicializarVector (v);
	leerArtesania (artesania);
	while (artesania.DNI <> 0) do
	begin
		cargarArbolOrdenado (a, artesania.DNI);
		v[artesania.material].cantidad := v[artesania.material].cantidad + 1;
		leerArtesania (artesania);
	end;
end;

function calcularCantidad (a: arbol; DNIX: integer): integer;
begin
	if (a = nil) then
		calcularCantidad := 0
	else if (DNIX > a^.dato.DNI) then // acá no se si pregunté así o DNIX < a^.dato.DNI
		calcularCantidad := 1 + calcularCantidad (a^.HI, DNIX) + calcularCantidad (a^.HD, DNIX)
	else
		calcularCantidad := calcularCantidad (a^.HI, DNIX);
end;

function convertirNumero (codigo: integer): string;
begin
	case codigo of
		1: convertirNumero := 'Madera';
		2: convertirNumero := 'Yeso';
		3: convertirNumero := 'Ceramica';
		4: convertirNumero := 'Vidrio';
		5: convertirNumero := 'Acero';
		6: convertirNumero := 'Porcelana';
		7: convertirNumero := 'Lana';
		8: convertirNumero := 'Carton';
	end;
end;

procedure ordenarVector (var v: vector; var materialMax: string);
var
	i, j, pos, dL: integer;
	item: registroVector;
begin
	dL := 8;
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
	materialMax := convertirNumero (v[dL].material);
end;
var
	a: arbol;
	v: vector;
	materialMax: string;
	DNIX: integer;
begin
	randomize;
	cargarDatos (a, v);
	writeln ('Ingrese el DNI del cual se buscara la cantidad de artesanos con DNI menor al ingresado: ');
	readln (DNIX);
	writeln ('La cantidad de artesanos con DNI menor al ', DNIX, ' es: ', calcularCantidad (a, DNIX));
	ordenarVector (v, materialMax);
	writeln ('El material base con mayor cantidad de artesanias es: ', materialMax); 
end.

{Diferencia clave ChatGPT:
En el primer código, verificas si DNIX > a^.dato.DNI (lo cual es equivalente a a^.dato.DNI < DNIX del segundo código). 
Ambas expresiones lógicas son equivalentes y deberían dar el mismo resultado. Sin embargo, el orden de los operandos es diferente.
El segundo código compara si el DNI del nodo es menor al DNI buscado, mientras que el primero lo hace al revés, 
verificando si el DNI buscado es mayor que el del nodo.
Matemáticamente ambos son equivalentes, y no debería haber diferencias en el comportamiento del programa en términos de resultados. 
 Sin embargo, es posible que la confusión provenga del flujo o de cómo está estructurado el árbol, 
pero conceptualmente ambas versiones deberían funcionar de manera idéntica.

function calcularCantidad (a: arbol; DNIX: integer): integer;
begin
	if (a = nil) then
		calcularCantidad := 0
	else if (DNIX > a^.dato.DNI) then
		calcularCantidad := 1 + calcularCantidad (a^.HI, DNIX) + calcularCantidad (a^.HD, DNIX)
	else
		calcularCantidad := calcularCantidad (a^.HI, DNIX);
end;

function calcularCantidad (a: arbol; DNIX: integer): integer;
begin
    if (a = nil) then
        calcularCantidad := 0
    else if (a^.dato.DNI < DNIX) then
        calcularCantidad := 1 + calcularCantidad (a^.HI, DNIX) + calcularCantidad (a^.HD, DNIX)
    else
        calcularCantidad := calcularCantidad (a^.HI, DNIX); 
end;}
