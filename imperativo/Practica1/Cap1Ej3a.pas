program Cap1Ej3a; // es ineficiente el agregarAlFinal porque no utilizo en cada lista un puntero al último elemento

type
	rangoGeneros = 1 .. 8;

	peliculasR = record
			codigo: integer;
			genero: rangoGeneros;
			puntaje: real;
		end;
	
	listas = ^nodo;
	nodo = record
		dato: peliculasR;
		sig: listas;
	end;
	
	vectorGeneros =  array [rangoGeneros] of listas;
	
procedure inicializarVectorGeneros (var vG: vectorGeneros);
var
	i: rangoGeneros;
begin
	for i := 1 to 8 do
		vG[i] := nil;
end;

procedure leerPelicula (var pelicula: peliculasR);
begin
	with pelicula do begin
		writeln ('Ingrese el codigo de la pelicula');
		readln (codigo);
		while (codigo <> -1) do
			begin
				writeln ('Ingrese el codigo del genero de la pelicula');
				readln (genero);
				writeln ('Ingrese el puntaje de la critica');
				readln (puntaje);
			end;
	end;
end;

procedure agregarAlFinal (var L: listas; pelicula: peliculasR); // se utiliza el agregar atras
var
	nuevo, auxiliar: listas;
begin
	new (nuevo);
	nuevo^.dato := pelicula;
	nuevo^.sig := nil;
	if (L = nil) then
		L := nuevo
	else
		begin
			auxiliar := L;
			while (auxiliar^.sig <> nil) do
				auxiliar := auxiliar^.sig;
			auxiliar^.sig := nuevo;
		end;
end;

procedure cargarListas (var vG: vectorGeneros);
var
	pelicula: peliculasR;
begin
	inicializarVectorGeneros (vG); // es un vector de 8 listas
	leerPelicula (pelicula);
	while (pelicula.codigo <> -1) do
		begin
			agregarAlFinal (vG[pelicula.genero], pelicula);
			leerPelicula (pelicula);
		end;
end;

var
	vG: vectorGeneros;
begin
	cargarListas (vG);
end.

{ 3.- Netflix ha publicado la lista de películas que estarán disponibles durante el mes de
diciembre de 2022. De cada película se conoce: código de película, código de género (1: acción,
2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélico, 7: documental y 8: terror) y puntaje
promedio otorgado por las críticas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de películas, los almacene por orden de llegada y agrupados por código de
género, y retorne en una estructura de datos adecuada. La lectura finaliza cuando se lee el
código de la película -1. }
