program Cap0Ej3b;
	type
		lista1 = ^nodo1;
		nodo1 = record
			numero: integer;
			sig: lista1
		end;
	procedure agregarAdelante (var L1: lista1; aleatorio: integer);
		var
			nuevo: Lista1;
		begin
			new (nuevo);
			nuevo^.numero := aleatorio;
			nuevo^.sig := L1;
			L1 := nuevo;
		end;
	procedure cargarLista (var L1: lista1);
		var
			aleatorio: integer;
		begin
			randomize;
			aleatorio := random (150-99) + 100;
			writeln ('El numero aleatorio ingresado es: ', aleatorio);
			while (aleatorio <> 120) do
				begin
					agregarAdelante (L1, aleatorio);
					aleatorio := random (150-99) + 100;
					if (aleatorio <> 120) then
						writeln ('El numero aleatorio ingresado es: ', aleatorio)
					else
						writeln ('El numero aleatorio es 120 por lo que finalizo la carga de la lista');
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
		cargarLista (L1);
		writeln ('Empezamos a imprimir la lista');
		imprimirLista (L1);
	end.

[a. Implemente un módulo CargarLista que cree una lista de enteros y 
le agregue valores aleatorios entre el 100 y 150, hasta que se genere el 120.

b. Implemente un módulo ImprimirLista que reciba una lista generada en a) 
e imprima todos los valores de la lista en el mismo orden que están almacenados.]
