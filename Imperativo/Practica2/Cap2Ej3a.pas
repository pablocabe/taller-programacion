program Cap2Ej3a;
const
	dF = 20;
type
	vector = array [1 .. dF] of integer;
	
procedure cargarVectorRecursivo (var v: vector; var dL: integer);
var
	numero: integer;
begin
	if (dL < dF) then
		begin
			numero := random (1249) + 301; // (1249)+1+300 = 301 a 1549
			dL := dL + 1;
			v[dL] := numero;
			writeln ('El vector cargo el numero ', numero, ' en la posicion ', dL);
			cargarVectorRecursivo (v, dL);
		end;
end;

var
	v: vector;
	dL: integer;
begin
	randomize;
	dL := 0;
	cargarVectorRecursivo (v, dL); // Ojo, preguntar en clase si es así o tengo que cargarVector y dentro cargarVectorRecursivo
end.

{3.- Implementar un programa que invoque a los siguientes módulos.
a. Un módulo recursivo que retorne un vector de 20 números enteros “random” mayores a 300
y menores a 1550 (incluidos ambos).}
