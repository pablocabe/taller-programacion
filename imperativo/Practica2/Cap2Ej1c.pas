program Cap2Ej1b;

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

procedure ImprimirVector (v: vector; dimL: integer);
var
	i: integer;
begin
	for i:= 1 to dimL do
		write ('-----');
	writeln;
	write (' ');
	for i:= 1 to dimL do begin
		write(v[i], ' | ');
	end;
	writeln;
	for i:= 1 to dimL do
		write ('-----');
	writeln;
	writeln;
end;     

procedure ImprimirVectorRecursivo (v: vector; dimL: integer);
var
	pos: integer;
begin
	if (dL < dF) then
		begin
			writeln (
			imprimirVectorRecursivo (v, dL);
		end;
end;

var
v: vector;
dimL: integer; 
begin
	CargarVector (v, dimL);
	writeln;
	if (dimL = 0) then
		writeln ('--- Vector sin elementos ---')
	else begin
		ImprimirVector (v, dimL);
		ImprimirVectorRecursivo (v, dimL);
	end;
end.

{1.- Implementar un programa que invoque a los siguientes modulos.
a. Un modulo recursivo que retorne un vector de a lo sumo 15 numeros enteros random mayores a 10 
y menores a 155 (incluidos ambos). La carga finaliza con el valor 20.
b. Un módulo no recursivo que reciba el vector generado en a) e imprima el contenido del
vector.
c. Un módulo recursivo que reciba el vector generado en a) e imprima el contenido del vector.}
