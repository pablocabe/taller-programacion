program Parcial1;
const
	dF = 12;
type
	
	rangoDias = 1 .. 31;
	rangoMeses = 1 .. 12;
	
	compraR = record
		codigoV: integer;
		codigoC: integer; // el arbol se ordenara por este elemento de menor a mayor
		dia: rangoDias;
		mes: rangoMeses;
	end;

	arbol = ^nodo1;
	nodo1 = record
		dato: compraR;
		HI: arbol;
		HD: arbol;
	end;

	vectorContador = array [rangoMeses] of integer;
	
	lista = ^nodo2;
	nodo2 = record
		dato: compraR; // ACÁ TENGO QUE PREGUNTAR SI VOLVER A USAR ESTE, ES INEFICIENTE PORQUE REPITE EL CODIGO
		sig: lista;
	end;
	
procedure inicializarTodo (var vC: vectorContador; var a: arbol; var L: lista);
var
	i: rangoMeses;
begin
	a := nil;
	L := nil;
	for i := 1 to dF do
		vC [i] := 0;
end;

procedure leerCompra (var compra: compraR);
begin
	compra.codigoC := random (100);
	if (compra.codigoC <> 0) then
		begin
			with compra do begin
				dia := random (31) + 1;
				mes := random (12) + 1;
				codigoV := random (20000) + 1;
			end;
		end;
end;

procedure cargarArbol (var a: arbol; compra: compraR);
begin
	if (a = nil) then
		begin
			new (a);
			a^.dato := compra;
			a^.HI := nil;
			a^.HD := nil;
		end
	else if (compra.codigoC > a^.dato.codigoC) then
		cargarArbol (a^.HD, compra)
	else 
		cargarArbol (a^.HI, compra); // si se repite el codigo de cliente se ordena hacia la izquierda
end;

procedure sumarVector (var vC: vectorContador; mes: rangoMeses); // sumo una compra al mes correspondiente
begin
	vC [mes] := vC [mes] + 1;
end;

procedure puntoA (var a: arbol; var vC: vectorContador);
var
	compra: compraR;
begin
	leerCompra (compra);
	if (compra.codigoC <> 0) then
		begin
			cargarArbol (a, compra);
			sumarVector (vC, compra.mes);
			puntoA (a, vC);
		end;
end;

procedure agregarAdelante (var L: lista; compra: compraR);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato := compra;
	nuevo^.sig := L;
	L := nuevo;
end;

procedure puntoB (a: arbol; codigoCliente: integer; var L: lista);
begin
	if (a <> nil) then
		begin
			if (codigoCliente = a^.dato.codigoC) then
				begin
					agregarAdelante (L, a^.dato);
					puntoB (a^.HI, codigoCliente, L); //por si hay un codigo de cliente repetido debe ir hacia la izquierda hasta encontrar nil
				end
			else if (codigoCliente > a^.dato.codigoC) then
				puntoB (a^.HD, codigoCliente, L)
			else
				puntoB (a^.HI, codigoCliente, L) // como ultima opcion si no es nil, ni el mismo, ni mayor, entonces es menor
		end;
end;

procedure puntoC (var vC: vectorContador);
var
	i, j, pos: integer;
	item: integer;
begin
	for i := 1 to (dF - 1) do
		begin
			pos := i;
			for j := (i+1) to dF do
				if (vC[j] > vC[pos]) then
					pos := j;
			item := vC[pos];
			vC[pos] := vC[i];
			vC[i] := item;
		end;
end;

var
	vC: vectorContador;
	a: arbol;
	L: lista;
	codigoCliente: integer;
begin
	inicializarTodo(vC, a, L);
	PuntoA (a, vC);
	writeln ('Ingrese un codigo de cliente, del cual se buscaran todas sus compras');
	readln (codigoCliente);
	puntoB (a, codigoCliente, L);
	puntoC (vC);
end.

