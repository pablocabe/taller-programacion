program Cap2Ej2b;

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
	numero := random (6);
	writeln ('Se asigno el numero random ', numero);
	if (numero <> 0) then
		begin		
			agregarAdelante(L, numero);
			cargarListaRecursiva(L); //  si invierto estos dos modulos recursivos se almacena en orden inverso a la asignación
		end;
end;

procedure imprimirListaRecursivo (L: lista);
begin
	if (L <> nil) then
		begin
			writeln ('El valor es ', L^.dato); // se imprime de adelante hacia atras, el ultimo numero guardado es el primero de la lista
			L := L^.sig;
			imprimirListaRecursivo (L);
		end;
end;


var
	L: lista;
begin
	randomize;
	L := nil;
	cargarListaRecursiva (L);
	writeln ('Avanzamos a la impresion de la lista en forma recursiva en el orden que estan almacenados');
	imprimirLIstaRecursivo (L);
end.

{2.- Escribir un programa que:
a. Implemente un módulo recursivo que genere y retorne una lista de números enteros
“random” en el rango 100-200. Finalizar con el número 100.
b. Un módulo recursivo que reciba la lista generada en a) e imprima los valores de la lista en el
mismo orden que están almacenados.}
