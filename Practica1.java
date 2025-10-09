package practica1_2025_al448150;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos (Iterator<Integer> it) {
        Set<Integer> vistos = new HashSet< Integer>();
        Set<Integer> res = new  HashSet<Integer>();

        while (it.hasNext()) {
            int numActual = it.next();

            if (numActual == 0) continue;

            for (Integer numVist : vistos) {

                if ((numActual % numVist) == 0) { //Si numActual/numVist el resto es 0, es multiplo
                    res.add(numActual);
                }else if ( (numVist % numActual) == 0) { //Si numVist/numActual el resto es 0, es multiplo
                    res.add(numVist);
                }
            }
            vistos.add(numActual);
        }
        return res;
    }

    //EJERCICIO2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {

        Set<Integer> union = new HashSet<Integer>();
        union.addAll(cuadrados); //Añadimos cuadrados a union
        union.addAll(noCuadrados); //Añadimos noCuadrados a union

        Set<Integer> nuevoCuadrado = new HashSet<>();
        Set<Integer> nuevoNoCuadrado = new HashSet<>();


        for (Integer x : union) {
            boolean anadido = false; //Booleano para saber si se ha añadido

            for (Integer y : union) {
                long yy = y*y;  //Numero maximo de int 2.147.483.647 y 10^10 = 10.000.000.000

                // .longValue() es un metodo que devuelve un long
                if ( yy == x.longValue() &&  !y.equals(x)) { //Gastamos .equals() para la comparacion de objetos
                    anadido = true;
                    break;

                }else if ( yy == x && y.equals(x)) { //Comprobacion de que si el numero x=y y esta contenido en ambos se añade
                    if (cuadrados.contains(x) && noCuadrados.contains(x)) {
                        anadido = true;
                        break;
                    }
                }
            }

            //Comprobacion de que lista tiene que ir el numero
            if(anadido) {
                nuevoCuadrado.add(x);
            }else {
                nuevoNoCuadrado.add(x);
            }
        }

        //Vaciamos los antiguos
        cuadrados.clear();
        noCuadrados.clear();

        //Añadimos los nuevos numeros
        cuadrados.addAll(nuevoCuadrado);
        noCuadrados.addAll(nuevoNoCuadrado);
    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        //Podemos usar un ArrayList<> pq es una implementacion de la interfaz Collection<>
        //Set<T> no ordenado, no se puede repeticiones
        ArrayList<Set<T>> coleccion = new ArrayList<>();

        while (it.hasNext()) {
            T elem = it.next();
            boolean colocado = false;

            for (Set<T> s : coleccion) {
                if (!s.contains(elem)) {
                    s.add(elem);
                    colocado = true;
                    break;
                }
            }

            if (!colocado) {
                Set<T> nuevo = new HashSet<>();
                nuevo.add(elem);
                coleccion.add(nuevo);
            }

        }
        return coleccion;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {

        Set<Set<T>> resultadoUnion = new HashSet<>();

        for (int i = 0; i < col.size(); i++) {
            Set<T> primero = col.get(i);

            if (!primero.equals(u)) // Si hay algun conjunto de col que sea igual a u lo ignoramos

                for (int j = i+1; j < col.size(); j++) {
                    Set<T> segundo = col.get(j);

                    if (!segundo.equals(u)) { //Ignoramos culaquier conjunto igual a u
                        //Creamos la union y añadimos los elementos
                        Set<T> unionElementos = new HashSet<>();
                        unionElementos.addAll(primero);
                        unionElementos.addAll(segundo);

                        if (unionElementos.equals(u)) { //Set redefine el metodo equals en el cual importa el contenido
                            resultadoUnion.add(primero);
                            resultadoUnion.add(segundo);
                        }
                    }
                }
        }
        return resultadoUnion;
    }
}
