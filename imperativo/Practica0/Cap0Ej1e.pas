program Cap0Ej1e;
var 
	aleatorio, F, A, B: integer;
begin
     randomize; 
     writeln ('Ingrese un numero que debe encontrarse:');
     readln (F);
     writeln ('Ingrese el rango de los numeros aleatorios:');
     readln (A);
     readln (B);
     aleatorio := random (B-A+1)+A;
     while  (aleatorio <> F) do
		begin 
			writeln ('El numero aleatorio generado es: ', aleatorio);			
			aleatorio := random (B-A+1)+A;
		end;
end.

[e. Modifique el programa para que imprima números aleatorios en el rango (A,B) 
hasta que se genere un valor igual a F, el cual no debe imprimirse. 
F, A y B son números enteros que se leen por teclado.]
