program Cap0Ej1d;
var 
	aleatorio, i, N, A, B: integer;
begin
     randomize; 
     writeln ('Ingrese la cantidad de numeros aleatorios a imprimir:');
     readln (N); // 6
     writeln ('Ingrese el rango de los numeros aleatorios:');
     readln (A); // 4
     readln (B); // 8
     for i := 1 to N do
		begin
			aleatorio := random (B-A+1)+A; 
			writeln ('El numero aleatorio generado es: ', aleatorio);
		end;
	writeln ('Presione cualquier tecla para finalizar');
	readln;
end.

[d) Modifique el programa para que imprima N números aleatorios en el rango (A,B), 
donde N, A y B son números enteros que se leen por teclado.]
