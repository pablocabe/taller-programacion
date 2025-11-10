program Cap2Ej2a;

type
	lista = ^nodo;
	nodo = record
		dato: integer;
		sig: lista;
	end;

procedure agregarAdelante (var L: lista; var numero: integer);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato := numero;
	nuevo^.sig := L;
	L := nuevo;
	writeln ('Se agrego el numero ', L^.dato, ' a la lista');
end;

procedure cargarListaRecursiva (var L: lista);
var
	numero: integer;
begin
	numero := random (10);
	writeln ('Se asigno el numero random ', numero);
	if (numero <> 0) then
		begin		
			agregarAdelante (L, numero);
			cargarListaRecursiva (L);
		end;
end;

var
	L: lista;
begin
	randomize;
	L := nil;
	cargarListaRecursiva (L);
end.

{2.- Escribir un programa que:
a. Implemente un módulo recursivo que genere y retorne una lista de números enteros
“random” en el rango 100-200. Finalizar con el número 100.}
