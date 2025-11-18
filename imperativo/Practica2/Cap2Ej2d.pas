program Cap2Ej2d;

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
	numero := random (20);
	writeln ('Se asigno el numero random ', numero);
	if (numero <> 0) then
		begin		
			agregarAdelante(L, numero); // si invierto estos dos modulos recursivos se almacena en orden inverso a la asignación
			cargarListaRecursiva(L);
		end;
end;

procedure imprimirListaRecursivo (L: lista);
begin
	if (L <> nil) then
		begin
			writeln ('El valor es ', L^.dato);
			L := L^.sig;
			imprimirListaRecursivo (L);
		end;
end;

procedure imprimirListaRecursivoInverso (L: lista);
begin
	if (L <> nil) then
	begin
		imprimirListaRecursivoInverso (L^.sig);
		writeln ('El valor es ', L^.dato);
	end;
end;

procedure buscarMinimoRecursivo (L: lista; var minimo: integer);
begin
	if (L <> nil) then
		begin
			if (L^.dato < minimo) then
				minimo := L^.dato;
			buscarMinimoRecursivo (L^.sig, minimo);
		end;
end;

var
	L: lista;
	minimo: integer;
begin
	randomize;
	L := nil;
	cargarListaRecursiva (L);
	writeln ('Avanzamos a la impresion de la lista en forma recursiva en el orden que estan almacenados');
	imprimirLIstaRecursivo (L);
	writeln ('--------------');
	writeln ('Avanzamos a la impresion de la lista en forma recursiva en el orden inverso al almacenado');
	imprimirListaRecursivoInverso (L);
	writeln ('Avanzamos a la impresion del numero minimo de la lista');
	minimo := 9999;
	buscarMinimoRecursivo (L, minimo);
	writeln ('El valor minimo de la lista recursiva es: ', minimo);
end.

{2.- Escribir un programa que:
a. Implemente un módulo recursivo que genere y retorne una lista de números enteros
“random” en el rango 100-200. Finalizar con el número 100.
b. Un módulo recursivo que reciba la lista generada en a) e imprima los valores de la lista en el
mismo orden que están almacenados.
c. Implemente un módulo recursivo que reciba la lista generada en a) e imprima los valores de
la lista en orden inverso al que están almacenados.
d. Implemente un módulo recursivo que reciba la lista generada en a) y devuelva el mínimo
valor de la lista.}
