program Cap0Ej4b;
	type
		lista1 = ^nodo1;
		nodo1 = record
			numero: integer;
			sig: lista1;
		end;
	procedure agregarOrdenado (var L1: lista1; aleatorio: integer);
		var
			anterior, nuevo, actual: lista1;
		begin
			new (nuevo);
			nuevo^.numero := aleatorio;
			actual := L1;
			while (actual <> nil ) and (aleatorio > actual^.numero) do
				begin
					anterior := actual;
					actual := actual^.sig;
				end;
			if (L1 = actual) then
				L1 := nuevo
			else
				anterior^.sig := nuevo;
			nuevo^.sig := actual;
		end;
	procedure cargarListaOrdenada (var L1: lista1);
		var
			aleatorio: integer;
		begin
			randomize;
			aleatorio := random (150-99) + 100;
			writeln ('El numero aleatorio ingresado es: ', aleatorio);
			while (aleatorio <> 120) do
				begin
					agregarOrdenado (L1, aleatorio);
					aleatorio := random (150-99) + 100;
					writeln ('El numero aleatorio ingresado es: ', aleatorio);
				end;
		end;
	procedure imprimirLista (L1: lista1);
		begin
			while (L1 <> nil) do
				begin
					writeln ('El numero aleatorio ingresado es: ', L1^.numero);
					L1 := L1^.sig;
				end;
		end;
	var
		L1: lista1;
	begin
		L1 := nil;
		cargarListaOrdenada (L1);
		writeln ('Pasamos a imprimir la lista');
		imprimirLista (L1);
	end.

[a.Implemente un módulo CargarListaOrdenada que cree una lista de 
enteros y le agregue valores aleatorios entre el 100 y 150, hasta que se 
genere el 120. Los valores dentro de la lista deben quedar ordenados 
de menor a mayor. 

b. Reutilice el módulo ImprimirLista que reciba una lista generada en a) e
imprima todos los valores de la lista en el mismo orden que están
almacenados.]
