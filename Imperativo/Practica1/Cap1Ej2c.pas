program Cap1Ej2c;
	const
		dF = 300;
	type
		rangoVector1 = 1 .. dF;
		oficinaR = record
			codigo: integer;
			DNI: integer;
			valor: real;
		end;
		vector1 = array [rangoVector1] of oficinaR;
	procedure leerOficina (var oficinaActual: oficinaR);
		begin
			with oficinaActual do begin
				writeln ('Avanzamos con la siguiente oficina');
				writeln ('Ingrese el codigo de identificacion');
				readln (codigo);
				if (codigo <> -1) then
					begin
						writeln ('Ingrese el DNI del propietario');
						readln (DNI);
						writeln ('Ingrese el valor de las expensas');
						readln (valor);
					end;
			end;
		end;
	procedure cargarVector1 (var v1: vector1; var dL: integer);
		var
			oficinaActual: oficinaR;
		begin
			dL := 0;
			leerOficina (oficinaActual);
			while ((dL < dF) and (oficinaActual.codigo <> -1)) do
				begin
					dL := dL + 1;
					v1 [dL] := oficinaActual;
					leerOficina (oficinaActual);
				end;
		end;
	procedure ordenarVector (var v1: vector1; dL: integer); // metodo de selección
		var
			i, j, pos: integer;
			item: oficinaR;
		begin
			for i := 1 to (dL -1) do
				begin
					pos := i;
					for j := (i+1) to dL do
						if (v1 [j].codigo) < (v1 [pos].codigo) then
							pos := j;
						item := v1 [pos];
						v1 [pos] := v1 [i];
						v1 [i] := item;
				end;
		end;
	procedure recorrerVector (v1: vector1; dL: integer);
			var
				i: integer;
			begin
				for i := 1 to dL do
					begin
						writeln ('En la posicion ', i , ' el codigo es: ', v1 [i].codigo);
						writeln ('En la posicion ', i, ' el DNI es: ', v1 [i].DNI);
						writeln ('En la posicion ', i, ' el valor de las expensas es $:', v1 [i].valor: 2 : 2);
					end;
			end; 
	var
		v1: vector1;
		dL: integer;
	begin
		cargarVector1 (v1, dL);
		ordenarVector (v1, dL);
		recorrerVector (v1, dL);
	end.

{2.- El administrador de un edificio de oficinas cuenta, en papel, con la información del pago de
las expensas de dichas oficinas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra. De cada oficina
se ingresa el código de identificación, DNI del propietario y valor de la expensa. La lectura
finaliza cuando se ingresa el código de identificación -1, el cual no se procesa. 
b. Ordene el vector, aplicando el método de inserción, por código de identificación de la
oficina
c. Ordene el vector aplicando el método de selección, por código de identificación de la oficina.}
