program Cap1Ej4e;
const
	dF1 = 8;
	dF2 = 30;
type
	rangoRubros = 1 .. dF1;
	rangoVector3 = 1 .. dF2;
	
	productoR = record
		codigo: integer;
		rubro: rangoRubros;
		precio: real;
	end;
	
	listas = ^nodo;
	nodo = record
		dato: productoR;
		sig: listas;
	end;
	
	vectorL = array  [rangoRubros] of listas; // declaramos un vector de 8 listas
	vector3 = array [rangoVector3] of productoR; // declaramos un vector para el inciso C
	
procedure inicializarListas (var vL: vectorL);
var
	i: rangoRubros;
begin
	for i := 1 to dF1 do
		vL[i] := nil;
end;

procedure leerProducto (var producto: productoR);
begin
	with producto do begin
		writeln ('Ingrese el precio del producto');
		precio := random (1000) * 1 ;
		writeln ('El precio del producto es ', precio: 2: 2);
		if (precio <> 0) then
			begin
				writeln ('Ingrese el codigo del producto');
				codigo := random (1000) + 1;
				writeln ('El codigo del producto es ', codigo);
				writeln ('Ingrese el codigo del rubro');
				rubro := random (dF1) + 1;
				writeln ('El rubro del producto es ', rubro);
			end;
	end;
end;

procedure agregarOrdenado (var L: listas; producto: productoR); // agrupamos cada producto en su respectiva lista de forma ordenada
var
	anterior, nuevo, actual: listas;
begin
	new (nuevo);
	nuevo^.dato := producto;
	anterior:= L;
	actual:= L;
	while(actual <> nil) and (producto.codigo > actual^.dato.codigo) do //ascendente
		begin
		anterior := actual;
		actual := actual^.sig;
		end;
	if(actual = anterior) then //principio o lista vacia
		L := nuevo
	else // al medio o al final
	begin
		anterior^.sig:= nuevo;
		nuevo^.sig:= actual;
	end;
end;

procedure cargarListas (var vL: vectorL);
var
	producto: productoR;
begin
	randomize;
	writeln ('---------------------------------------------------------------------------------------'); 
	writeln ('El programa empezo a cargar sus listas'); 
	inicializarListas (vL); // inicializamos en nil las 8 listas
	leerProducto (producto);
	while (producto.precio <> 0) do
		begin
			agregarOrdenado (vL[producto.rubro], producto);
			leerProducto (producto);
		end;
end;

procedure imprimirListaIndividual (L: listas);
begin
	if (L = nil) then
		writeln ('La lista esta vacia'); 
	while (L <> nil) do
		begin
			writeln ('Codigo del producto: ', L^.dato.codigo);
			L := L^.sig;
		end;
end;

procedure imprimirListas (var vL: vectorL);
var
	i: rangoRubros;
begin
	writeln ('---------------------------------------------------------------------------------------'); 
	writeln ('El programa imprimira los codigos de cada lista'); 
	for i := 1 to dF1 do
		begin
			writeln ('---------------------------------------------------------------------------------------'); 
			writeln ('El programa imprimira los codigos de la lista ', i); 
			imprimirListaIndividual (vL[i]);
		end;
end;

procedure cargarVector3 (var v3: vector3; L: listas; var dL: integer);
begin
	dL := 0;
	while (dL < dF2) and (L <> nil)  do
		begin
			dL := dL + 1;
			v3[dL] := L^.dato;
			L := L^.sig;
		end;
	if (L = nil) then
		writeln ('La carga del Vector3 finalizo porque se termino la lista')
	else
		writeln ('La carga del Vector3 finalizo porque se completo la capacidad del vector'); 
end;

procedure ordenarVector3 (var v3: vector3; dL: integer);
var
	i, j, pos: integer;
	item: productoR;
begin
	writeln ('---------------------------------------------------------------------------------------'); 
	writeln ('El programa esta ordenando los productos por precio de menor a mayor');
	for i := 1 to (dL-1) do
		begin
			pos := i;
			for j := (i+1) to (dL) do
				if v3[j].precio < v3[pos].precio then
					pos := j;
			item := v3[pos];
			v3[pos] := v3[i];
			v3[i] := item;
		end;
end;

procedure imprimirVector3 (v3: vector3; dL: integer);
var
	pos: integer;
begin
	pos := 0;
	writeln ('---------------------------------------------------------------------------------------'); 
	writeln ('El programa imprimira los precios del vector 3');
    while (pos < dL) do // (v3[pos].rubro = 3) no lo toma
		begin
			pos := pos + 1;
			writeln ('El precio del producto ubicado en la ', pos, ' del vector 3 es: ', v3[pos].precio: 2: 2);
		end;
end;

var
	vL: vectorL;
	v3: vector3;
	dL: integer;
begin
	cargarListas (vL);
	imprimirListas (vL);
	cargarVector3 (v3, vL[3], dL); // probar con rangoVector3
	ordenarVector3 (v3, dL);
	imprimirVector3 (v3, dL);
end. 

{4.- Una librería requiere el procesamiento de la información de sus productos. De cada 
producto se conoce el código del producto, código de rubro (del 1 al 8) y precio. 
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de los productos y los almacene ordenados por código de producto y 
agrupados por rubro, en una estructura de datos adecuada. El ingreso de los productos finaliza 
cuando se lee el precio 0
b. Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro.
c. Genere un vector (de a lo sumo 30 elementos) con los productos del rubro 3. Considerar que 
puede haber más o menos de 30 productos del rubro 3. Si la cantidad de productos del rubro 3 
es mayor a 30, almacenar los primeros 30 que están en la lista e ignore el resto. 
d. Ordene, por precio, los elementos del vector generado en c) utilizando alguno de los dos 
métodos vistos en la teoría. 
e. Muestre los precios del vector resultante del punto d).}
