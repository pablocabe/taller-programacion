program Cap1Ej3d; // es ineficiente el agregarAlFinal porque no utilizo en cada lista un puntero al último elemento
const
	dF = 8;
type
	rangoGeneros = 1 .. dF;

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
	vectorMayoresPuntajes = array [rangoGeneros] of peliculasR;
	
procedure inicializarVectorGeneros (var vG: vectorGeneros);
var
	i: rangoGeneros;
begin
	for i := 1 to dF do
		vG[i] := nil;
end;

procedure leerPelicula (var pelicula: peliculasR);
begin
	with pelicula do begin
		writeln ('Ingrese el codigo de la pelicula');
		codigo := random (101) - 1;
		writeln ('El codigo de la pelicula es: ', codigo);
		if (codigo <> -1) then
			begin
				writeln ('Ingrese el codigo del genero de la pelicula');
				genero :=  random (dF) + 1;
				writeln ('El codigo del genero es: ', genero);
				writeln ('Ingrese el puntaje de la critica');
				puntaje := random * 9.99;
				writeln ('El puntaje de la pelicula es: ', puntaje: 2: 2);
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
	writeln ('---------------------------------------------------------------------------------------'); 
	writeln ('El programa esta cargando las 8 listas y leyendo sus respectivas peliculas hasta encontrar el codigo -1'); 
	inicializarVectorGeneros (vG); // es un vector de 8 listas
	leerPelicula (pelicula);
	while (pelicula.codigo <> -1) do
		begin
			agregarAlFinal (vG[pelicula.genero], pelicula);
			leerPelicula (pelicula);
		end;
end;

procedure inicializarVectorPuntajes (var vMP: vectorMayoresPuntajes);
var
	i: rangoGeneros;
begin
	for i := 1 to dF do
		begin
			vMP[i].codigo := 0;
			vMP[i].genero := i;
			vMP[i].puntaje := 0;
		end;
end;

procedure buscarMayoresPuntajesGenero (L: listas; var generoEspecifico: peliculasR); // esto me mareó mucho, aca le pase una posicion del vMP = un género
begin
	while (L <> nil) do
		begin
			if (L^.dato.puntaje > generoEspecifico.puntaje) then
				begin
					generoEspecifico.codigo := L^.dato.codigo;
					generoEspecifico.puntaje := L^.dato.puntaje;
				end;
			L := L^.sig;
		end;
end;

procedure buscarMayoresPuntajes (vG: vectorGeneros; var vMP: vectorMayoresPuntajes);
var
	i: integer;
begin
	inicializarVectorPuntajes (vMP);
	writeln ('---------------------------------------------------------------------------------------'); 
	writeln ('El programa esta buscando la pelicula con mayor puntaje de cada genero'); 
	for i := 1 to dF do
		begin
			buscarMayoresPuntajesGenero (vG[i], vMP[i]);
			writeln ('El codigo de la pelicula del tipo de genero ', i, ' con mayor puntaje es:  ', vMP[i].codigo, '  porque su puntaje es: ', vMP[i].puntaje: 2: 2);
		end;
end;

procedure ordenarMayoresPuntajes (var vMP: vectorMayoresPuntajes); // metodo de selección
var
	i, j, pos: integer;
	item: peliculasR;
begin
	writeln ('---------------------------------------------------------------------------------------'); 
	writeln ('El programa esta ordenando las 8 peliculas seleccionadas (una por genero) de acuerdo a su puntaje, de menor a mayor'); 
	for i := 1 to (dF-1) do
		begin
			pos := i;
			for j := (i+1) to (dF) do
				if vMP[j].puntaje < vMP[pos].puntaje then
					pos := j;
			item := vMP[pos];
			vMP[pos] := vMP[i];
			vMP[i] := item;
		end;
end;

procedure imprimirMaxMin (vMP: vectorMayoresPuntajes);
begin
	writeln ('---------------------------------------------------------------------------------------'); 
	writeln ('El programa imprimira el codigo de las peliculas con mayor y menor puntaje'); 
	writeln ('El codigo de la pelicula con mayor puntaje entre las 8 seleccionadas es: ', vMP[8].codigo, ' porque su puntaje es: ', vMP[8].puntaje: 2: 2);
	writeln ('El codigo de la pelicula con menor puntaje entre las 8 seleccionadas es: ', vMP[1].codigo, ' porque su puntaje es: ', vMP[1].puntaje: 2: 2);
	// está bien este modulo porque una cosa es el codigo mayor y otra el puntaje mayor
end;

var
	vG: vectorGeneros;
	vMP: vectorMayoresPuntajes;
begin
	randomize;
	cargarListas (vG);
	buscarMayoresPuntajes (vG, vMP);
	ordenarMayoresPuntajes (vMP);
	imprimirMaxMin (vMP);
end.

{ 3.- Netflix ha publicado la lista de películas que estarán disponibles durante el mes de
diciembre de 2022. De cada película se conoce: código de película, código de género (1: acción,
2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélico, 7: documental y 8: terror) y puntaje
promedio otorgado por las críticas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de películas, los almacene por orden de llegada y agrupados por código de
género, y retorne en una estructura de datos adecuada. La lectura finaliza cuando se lee el
código de la película -1.
b. Genere y retorne en un vector, para cada género, el código de película con mayor puntaje 
obtenido entre todas las críticas, a partir de la estructura generada en a). 
c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos 
métodos vistos en la teoría. 
d. Muestre el código de película con mayor puntaje y el código de película con menor puntaje, 
del vector obtenido en el punto c). }
