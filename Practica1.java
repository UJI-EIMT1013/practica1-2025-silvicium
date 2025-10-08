package practica1_2025_al448150;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.Set;
import java.util.HashSet;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos (Iterator<Integer> it) {
        Set<Integer> vistos = new Set<Integer>(); 
        Set<Integer> res = new Set<Integer>();

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

        Set<Integer> nuevoCuadrado = new HashSet<Integer>();
        Set<Integer> nuevoNoCuadrado = new HashSet<Integer>();

        
        for (Integer x : union) { 
            boolean anadido = false;
            
            for (Integer y : union) {
                long yy = y*y; 
                x.longValue(); //Convertimos x a long para tener suficiente espacio
             
                if ( yy == x.longValue() &&  !y.equals(x)) { //Gastamos .equals() para la comparacion de objetos
                    nuevoCuadrado.add(x); 
                    anadido = true;
                    break;

                }else if ( yy == x && y.equals(x)) {
                    if (cuadrados.contains(x) && noCuadrados.contains(x)) {
                        nuevoCuadrado.add(x);
                        anadido = true;
                        break;
                    }
                }
            }

            if(!anadido) {
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
                HashSet<T> nuevo = new HashSet<>();
                nuevo.add(elem);
                coleccion.add(nuevo);
            }

        }
        return coleccion;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u, ArrayList<Set<T>> col) {
        ArrayList<Set<T>> lista = new ArrayList<>();
        

        //Añadimos todos los subconjuntos que pueden formar u
        for (int i=0; i<col.size(); i++) {
            Set<T> conjunto = col.get(i);

            if (u.contains(conjunto)) {
                conjunto.add(conjunto);
            }
        }


        //Miramos si hemos podido formar una lista 
        boolean esIgual = true;
        if (!lista.equals(u)){
            return new ArrayList<>(); //Si no podemos formar conjuntos devolvemos una vacia
        }

        //Filtramos los subconjuntos repetidos
        for (int i=0; i<lista.size(); i++) { 
            Set<T> conjunto1 = lista.get(i);

            for(int x=i+1; x<lista.size(); x++) {
                Set<T> conjunto2 = lista.get(x);
                
                if (conjunto1.equals(conjunto2)) {//Esta repetido
                    lista.get(x).remove();
                }
            }
        }



        if (esIgual) {
            return lista;
        }
    }
}
