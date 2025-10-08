package practica1_2025_al448150;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

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
                }

                if ( (numVist % numActual) == 0) { //Si numVist/numActual el resto es 0, es multiplo
                    res.add(numVist);
                }
            }
            vistos.add(numActual);
        }
        return res;
    }

    //EJERCICIO2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {
        
    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        //TODO
        return null;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {
        //TODO
        return null;
    }


}
