program Cap1Ej1a;

const 
	dimF = 50;

type 
	
	dias = 0..31;
	rango1 = 0..15;
	rango2 = 1..99;
	rango3 = 0..dimF;
	
	venta = record
		dia: dias;
		codigoP: rango1;
		cantidad: rango2;
	end;
	
	vector = array [1..dimF] of venta;

procedure LeerVenta (var v: venta);
begin
	write ('Dia: ');
	v.dia:= random(32);
	writeln (v.dia);
	if (v.dia <> 0) then
		begin
			write ('Codigo de producto: ');
			v.codigoP:= random(16) + 1;
			writeln (v.codigoP);
			write ('Ingrese cantidad (entre 1 y 99): ');
			v.cantidad := random (99) + 1;
		end;
end;

procedure AlmacenarInformacion (var v: vector; var dimL: rango3);
var 
	unaVenta: venta;
begin
	Randomize;
    dimL := 0;
    LeerVenta (unaVenta);
    while (unaVenta.dia <> 0)  and ( dimL < dimF ) do 
    begin
       dimL := dimL + 1;
       v[dimL]:= unaVenta;
       LeerVenta (unaVenta);
    end;
end;

var
	v: vector;
	dimL: rango3;
begin
	AlmacenarInformacion (v, dimL);
	writeln;
	if (dimL = 0) then
		writeln ('--- Vector sin elementos ---')
	else
		writeln ('--- Vector ingresado --->');
end.

{1.- Descargar el programa ImperativoEjercicioClase1.pas que contiene parte del código del 
siguiente enunciado a resolver. Implementar lo indicado en el código.
Se desea procesar la información de las ventas de productos de un comercio (como máximo  50). 
Implementar un programa que invoque los siguientes módulos:
a. Un módulo que retorne la información de las ventas en un vector. De cada venta se conoce 
el día de la venta, código del producto (entre 1 y 15) y cantidad vendida (como máximo 99 
unidades). El código debe generarse automáticamente (random) y la cantidad se debe leer. El 
ingreso de las ventas finaliza con el día de venta 0 (no se procesa).}
