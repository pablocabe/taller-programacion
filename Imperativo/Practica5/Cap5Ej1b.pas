program Cap5Ej1b; 

const
	dF = 300;

type
	oficinaR = record
		codigo: integer;
		DNI: longint;
		expensas: real;
	end;
	
	vector = array [1 .. dF] of oficinaR;
	
procedure leerOficina (var oficina: oficinaR);
begin
	with oficina do begin
		writeln ('Ingrese el codigo de identificacion de la oficina');
		readln (codigo);
		if (codigo <> 0) then
			begin
				writeln ('Ingrese el DNI del propietario de la oficina');
				readln (DNI);
				writeln ('Ingrese el valor de las expensas');
				readln (expensas);
			end;
	end;
end;

procedure cargarVector (var v: vector; var dL: integer);
var
	oficina: oficinaR;
begin
	dL := 0;
	leerOficina (oficina);
	while (oficina.codigo <> 0) and (dL < dF) do
		begin
			dL := dL + 1;
			v[dL] := oficina;
			leerOficina (oficina);
		end;
end;

procedure ordenarVector (var v: vector; dL: integer);
var
	i, j, pos: integer;
	item: oficinaR;
begin
	for i := 1 to (dL - 1) do
		begin
			pos := i;
			for j := (i+1) to dL do
				if (v[j].codigo < v[pos].codigo) then
					pos := j;
			item := v[pos];
			v[pos] := v[i];
			v[i] :=item;
		end;
end;

var
	v: vector;
	dL: integer;
begin
	cargarVector (v, dL);
	ordenarVector (v, dL);
end.


{1. El administrador de un edificio de oficinas tiene la información del pago de las expensas
de dichas oficinas. Implementar un programa con:
a) Un módulo que retorne un vector, sin orden, con a lo sumo las 300 oficinas que
administra. Se deben cargar, para cada oficina, el código de identificación, DNI del
propietario y valor de la expensa. La lectura finaliza cuando llega el código de
identificación 0.
b) Un módulo que reciba el vector retornado en a) y retorne dicho vector ordenado por
código de identificación de la oficina. Ordenar el vector aplicando uno de los métodos
vistos en la cursada.}
