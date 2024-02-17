package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	int[] CopiaEnteros = arregloEnteros.clone();
        return CopiaEnteros;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String[]CopiaCadenas = arregloCadenas.clone();
        return CopiaCadenas;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	int CantidadEnteros = arregloEnteros.length;
        return CantidadEnteros;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	int CantidadCadenas = arregloCadenas.length;
        return CantidadCadenas;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int nuevoTamanio = arregloEnteros.length + 1;
    	int[] nuevoArreglo = new int[nuevoTamanio];
    	for(int i = 0; i<arregloEnteros.length;i++) {
    		nuevoArreglo[i]=arregloEnteros[i];
    	}
    	
    	nuevoArreglo[nuevoTamanio-1]=entero;
    	arregloEnteros = nuevoArreglo;
    	
    }


    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	int nuevoTamanio1 = arregloCadenas.length + 1;
    	String [] nuevoArreglo = new String[nuevoTamanio1];
    	for (int i = 0; i<arregloCadenas.length;i++) {
    		nuevoArreglo[i] = arregloCadenas[i];
    	}
    	nuevoArreglo[nuevoTamanio1 -1] = cadena;
    	arregloCadenas = nuevoArreglo;
    	
    }


    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero(int valor) {
        ArrayList<Integer> nuevoArreglo = new ArrayList<>();

        for (int elemento : arregloEnteros) {
            if (elemento != valor) {
                nuevoArreglo.add(elemento);
            }
        }

        // Actualiza el arreglo original con el nuevo contenido
        arregloEnteros = new int[nuevoArreglo.size()];
        for (int i = 0; i < nuevoArreglo.size(); i++) {
            arregloEnteros[i] = nuevoArreglo.get(i);
        }
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena(String cadena) {
        ArrayList<String> nuevoArreglo = new ArrayList<>();

        for (String elemento : arregloCadenas) {
            if (!elemento.equals(cadena)) {
                nuevoArreglo.add(elemento);
            }
        }

        arregloCadenas = nuevoArreglo.toArray(new String[0]);
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero(int entero, int posicion) {
        int nuevoTamanio = arregloEnteros.length + 1;

        // Ajusta la posición si es menor a 0 o mayor que el tamaño del arreglo
        posicion = Math.max(0, Math.min(posicion, arregloEnteros.length));

        int[] nuevoArreglo = new int[nuevoTamanio];

        // Copia los elementos antes de la posición de inserción
        System.arraycopy(arregloEnteros, 0, nuevoArreglo, 0, posicion);

        // Inserta el nuevo entero en la posición especificada
        nuevoArreglo[posicion] = entero;

        // Copia los elementos después de la posición de inserción
        System.arraycopy(arregloEnteros, posicion, nuevoArreglo, posicion + 1, arregloEnteros.length - posicion);

        // Actualiza el arreglo original con el nuevo arreglo
        arregloEnteros = nuevoArreglo;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion(int posicion) {
        if (posicion < 0 || posicion >= arregloEnteros.length) {
            return;
        }

        int nuevoTamanio = arregloEnteros.length - 1;
        int[] nuevoArreglo = new int[nuevoTamanio];

        
        System.arraycopy(arregloEnteros, 0, nuevoArreglo, 0, posicion);

        
        System.arraycopy(arregloEnteros, posicion + 1, nuevoArreglo, posicion, arregloEnteros.length - posicion - 1);

        
        arregloEnteros = nuevoArreglo;
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros(double[] valores) {

        int[] nuevoArreglo = new int[valores.length];

        for (int i = 0; i < valores.length; i++) {
            int numeroRedondeado = (int) Math.round(valores[i]);
            nuevoArreglo[i] = numeroRedondeado;
        }

   
        arregloEnteros = nuevoArreglo;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	int nuevoTamanio = objetos.length;
    	String[]nuevoArreglo = new String[nuevoTamanio];
    	for (int i = 0; i<objetos.length;i++) {
    		nuevoArreglo[i] = objetos[i].toString();
    	}
    	arregloCadenas = nuevoArreglo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int nuevoTamanio = arregloEnteros.length;
    	int[]nuevoArreglo = new int[nuevoTamanio];
    	for (int i = 0; i<nuevoTamanio;i++) {
    		if (arregloEnteros[i]<0) {
    			nuevoArreglo[i] = arregloEnteros[i]*(-1);
    		}
    		else {
    			nuevoArreglo[i] = arregloEnteros[i];
    		}
    		
    	}
    	arregloEnteros = nuevoArreglo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	Arrays.sort(arregloEnteros);
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Arrays.sort(arregloCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param string El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones1( int valor )
    {
        int contador = 0;
        for (int i = 0; i<arregloEnteros.length;i++) {
        	if (arregloEnteros[i]== valor) {
        		contador++;
        	}
        }
        return contador;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones2(String cadena) {
        int contador = 0;

        for (int i = 0; i < arregloCadenas.length; i++) {
            if (arregloCadenas[i].equalsIgnoreCase(cadena)) {
                contador++;
            }
        }

        return contador;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero(int valor) {
        int numeroApariciones = 0;

        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                numeroApariciones++;
            }
        }

        int[] nuevoArreglo = new int[numeroApariciones];

        int indicePosiciones = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                nuevoArreglo[indicePosiciones] = i;
                indicePosiciones++;
            }
        }

        return nuevoArreglo;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros() {
        if (arregloEnteros == null || arregloEnteros.length == 0) {
            int[] arregloVacio = new int[0];
            return arregloVacio;
        }

        int rango = 2;
        int[] nuevoArreglo = new int[rango];
        int minimo = arregloEnteros[0];
        int maximo = arregloEnteros[0];

        for (int i = 1; i < arregloEnteros.length; i++) {
            if (minimo > arregloEnteros[i]) {
                minimo = arregloEnteros[i];
            }
            if (maximo < arregloEnteros[i]) {
                maximo = arregloEnteros[i];
            }
        }

        nuevoArreglo[0] = minimo;
        nuevoArreglo[1] = maximo;
        return nuevoArreglo;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
       HashMap<Integer, Integer>miHashMap = new HashMap<>();
       for (int i = 0;i<arregloEnteros.length;i++) {
    	   miHashMap.put(arregloEnteros[i], contarApariciones1(arregloEnteros[i]));
    	
       }
       return miHashMap;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	// Utilizamos un HashMap para contar la frecuencia de cada número
        HashMap<Integer, Integer> frecuenciaNumeros = new HashMap<>();

        // Contamos la frecuencia de cada número en el arreglo de enteros
        for (int numero : arregloEnteros) {
            frecuenciaNumeros.put(numero, frecuenciaNumeros.getOrDefault(numero, 0) + 1);
        }

        // Contamos cuántos números tienen una frecuencia mayor que 1
        int contadorRepetidos = 0;
        for (int frecuencia : frecuenciaNumeros.values()) {
            if (frecuencia > 1) {
                contadorRepetidos++;
            }
        }

        return contadorRepetidos;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros(int[] otroArreglo) {
        if (arregloEnteros.length != otroArreglo.length) {
            return false;
        }

        for (int i = 0; i < arregloEnteros.length; i++) {

            if (arregloEnteros[i] != otroArreglo[i]) {

                return false;
            }
        }


        return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros(int[] otroArreglo) {
        // Verifica si los arreglos tienen la misma longitud
        if (arregloEnteros.length != otroArreglo.length) {
            return false;
        }

        // Copia y ordena ambos arreglos
        int[] copiaArregloEnteros = Arrays.copyOf(arregloEnteros, arregloEnteros.length);
        int[] copiaOtroArreglo = Arrays.copyOf(otroArreglo, otroArreglo.length);
        Arrays.sort(copiaArregloEnteros);
        Arrays.sort(copiaOtroArreglo);

        // Compara cada elemento en la misma posición de ambos arreglos
        for (int i = 0; i < copiaArregloEnteros.length; i++) {
            if (copiaArregloEnteros[i] != copiaOtroArreglo[i]) {
                // Si encuentra algún par de elementos diferentes, retorna false inmediatamente
                return false;
            }
        }

        // Si ha llegado hasta aquí, significa que todos los elementos son iguales
        return true;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros(int cantidad, int minimo, int maximo) {
        arregloEnteros = new int[cantidad];
        
        for (int i = 0; i < cantidad; i++) {
            int numeroAleatorio = (int) (Math.random() * (maximo - minimo + 1)) + minimo;
            arregloEnteros[i] = numeroAleatorio;
        }
    }

	public Integer contarApariciones2(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}