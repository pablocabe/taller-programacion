program Cap2Ej1a;

const 
	dimF = 15;
	min = 10;
	max = 155;
	
type
	vector = array [1 .. dimF] of integer;

procedure CargarVectorRecursivo (var v: vector; var dimL: integer);
var
	valor: integer;
begin
	valor:= min + random (max - min + 1);
	if ((valor <> 20 ) and (dimL < dimF)) then
		begin
			dimL:= dimL + 1;
			v[dimL]:= valor;
			CargarVectorRecursivo (v, dimL);
		end;
end;

procedure CargarVector (var v: vector; var dimL: integer);
begin
	dimL:= 0;
	CargarVectorRecursivo (v, dimL);
end;

var
v: vector;
dimL: integer; 
begin
	CargarVector (v, dimL);
end.

{1.- Implementar un programa que invoque a los siguientes modulos.
a. Un modulo recursivo que retorne un vector de a lo sumo 15 numeros enteros random mayores a 10 
y menores a 155 (incluidos ambos). La carga finaliza con el valor 20.}
