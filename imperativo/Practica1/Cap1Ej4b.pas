program Cap1Ej4b;
const
	dF = 8;
type
	rangoRubros = 1 .. dF;
	
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
	
procedure inicializarListas (var vL: vectorL);
var
	i: rangoRubros;
begin
	for i := 1 to dF do
		vL[i] := nil;
end;

procedure leerProducto (var producto: productoR);
begin
	with producto do begin
		writeln ('Ingrese el precio del producto');
		readln (precio);
		writeln ('El precio del producto es ', precio: 2: 2);
		if (precio <> 0) then
			begin
				writeln ('Ingrese el codigo del producto');
				codigo := random (1000) + 1;
				writeln ('El codigo del producto es ', codigo);
				writeln ('Ingrese el codigo del rubro');
				rubro := random (dF) + 1;
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
	for i := 1 to dF do
		begin
			writeln ('---------------------------------------------------------------------------------------'); 
			writeln ('El programa imprimira los codigos de la lista ', i); 
			imprimirListaIndividual (vL[i]);
		end;
end;

var
	vL: vectorL;
begin
	cargarListas (vL);
	imprimirListas (vL);
end. 

{4.- Una librería requiere el procesamiento de la información de sus productos. De cada 
producto se conoce el código del producto, código de rubro (del 1 al 8) y precio. 
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de los productos y los almacene ordenados por código de producto y 
agrupados por rubro, en una estructura de datos adecuada. El ingreso de los productos finaliza 
cuando se lee el precio 0
b. Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro.}
