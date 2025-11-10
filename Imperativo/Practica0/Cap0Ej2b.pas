program Cap0Ej2b;
	const
		dF = 50;
	type
		vector = array [1 .. dF] of integer;
	procedure cargarVector (var v: vector; var dL: integer; minimo, maximo: integer);
		var
			numero: integer;
		begin
			randomize;
			dL := 0;
			numero := random (maximo - minimo + 1);
			while (numero <> 0) and (dL < dF) do
				begin
					dL := dL + 1;
					v[dL] := numero;
					writeln ('El valor ingresado en la posicion ', dL, ' es: ' , numero);
					numero := random (maximo - minimo + 1);
				end;
		end;
	procedure imprimirVector1 (v: vector; dL: integer);
		var
			i: integer;
		begin
			for i := 1 to dL do
				writeln ('El valor almacenado en la posicion ', i,  ' es: ', v[i]);
		end;
	procedure imprimirVector2 (v: vector; dL: integer);
		var
			i: integer;
		begin
			for i := dL downto 1 do
				writeln ('El valor almacenado en la posicion ', i,  ' es: ', v[i]);
		end;
	var
		v: vector;
		dL, maximo, minimo: integer;
	begin
		writeln ('Ingrese un valor minimo');
		readln (minimo);
		writeln ('Ingrese un valor maximo');
		readln (maximo);
		cargarVector (v, dL, minimo, maximo);
		imprimirVector1 (v, dL);
		imprimirVector2 (v, dL);
	end.

[a. Implemente un módulo CargarVector que cree un vector de enteros 
con a lo sumo 50 valores aleatorios. Los valores, generados 
aleatoriamente (entre un mínimo y máximo recibidos por parámetro), 
deben ser almacenados en el vector en el mismo orden que se 
generaron, hasta que se genere el cero.

b. Implemente un módulo ImprimirVector que reciba el vector generago 
en a) e imprima todos los valores del vector en el mismo orden que 
están almacenados. Qué cambiaría para imprimir en orden inverso?]
