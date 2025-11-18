program Cap0Ej1a;

var ale: integer;

begin
     randomize; {Elige una semilla distinta cada vez que se ejecuta el programa.}
                {La semilla sirve para generar series de números aleatorios distintos.}
                {Sin la llamada al procedimiento randomize, en todas las ejecuciones
                 del programa se elige siempre la misma serie de números aleatorios.}
     
     ale := random (100); {devuelve un valor aleatorio en el intervalo 0 a 99}

     writeln ('El numero aleatorio generado es: ', ale);

	 writeln ('Presione cualquier tecla para finalizar');
     readln;
end.
