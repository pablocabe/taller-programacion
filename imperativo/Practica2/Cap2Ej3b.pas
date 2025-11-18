program Cap2Ej3b;
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

procedure ordenarVector (var v: vector; dL: integer); // metodo de selección
var
	i, j, pos, item: integer;
begin
	writeln ('El vector sera ordenado de menor a mayor');
	for i := 1 to (dL -1) do
		begin
			pos := i;
			for j := (i+1) to dL do
				if (v[j]) < (v[pos]) then
					pos := j;
			item := v[pos];
			v[pos] := v[i];
			v[i] := item;
		end;
	writeln ('El vector fue ordenado de menor a mayor con exito');
end;

procedure recorrerVector (v: vector; dL: integer);
var
	i: integer;
begin
	for i := 1 to dL do
		writeln ('El numero de la posicion ', i, ' es: ', v[i]);
end;

var
	v: vector;
	dL: integer;
begin
	randomize;
	cargarVectorRecursivo (v, dL);
	writeln;
	ordenarVector (v, dL);
	writeln;
	recorrerVector (v, dL);
end.

{3.- Implementar un programa que invoque a los siguientes módulos.
a. Un módulo recursivo que retorne un vector de 20 números enteros “random” mayores a 300
y menores a 1550 (incluidos ambos).
b. Un módulo que reciba el vector generado en a) y lo retorne ordenado. (Utilizar lo realizado
en la práctica anterior)}
