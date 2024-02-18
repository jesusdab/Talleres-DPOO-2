package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SandboxConjuntos
{
    private Set<String> conjuntoCadenas;

    public SandboxConjuntos( )
    {
        conjuntoCadenas = new HashSet<String>( );
    }

    public List<String> getCadenasComoLista() {
        if (conjuntoCadenas == null) {
            return null;
        }

        List<String> lista = new ArrayList<>(conjuntoCadenas);

        return lista;
    }

    public List<String> getCadenasComoListaInvertida( )
    {
        if (conjuntoCadenas == null) {
            return null;
        }
        List<String> lista = new ArrayList<>(conjuntoCadenas);
        Collections.reverse(lista);
        return lista;
    }	

    public int getCantidadCadenas() {
        if (conjuntoCadenas == null) {
            return 0;
        }

        return conjuntoCadenas.size();
    }

    public void agregarCadena( String cadena )
    {
        conjuntoCadenas.add(cadena);
    }

    public void eliminarCadena( String cadena )
    {
        conjuntoCadenas.remove(cadena);
    }

    public void eliminarCadenaSinMayusculasOMinusculas(String cadena) {
        conjuntoCadenas.remove(cadena);
        conjuntoCadenas.remove(cadena.toLowerCase());
        conjuntoCadenas.remove(cadena.toUpperCase());
    }

    public void reiniciarConjuntoCadenas(String[] nuevosValores) {
        if (nuevosValores == null) {
            return;
        }

        conjuntoCadenas.clear();

        for (Object objeto : nuevosValores) {
            conjuntoCadenas.add(objeto.toString());
        }
    }

    public void volverMayusculas( )
    {
        Set<String> nuevoConjunto = new HashSet<>();
        for (String Cadena: conjuntoCadenas) {
            nuevoConjunto.add(Cadena.toUpperCase());
        }
        conjuntoCadenas = nuevoConjunto;
    }

    public boolean compararElementos(String[] otroArreglo) {
        if (conjuntoCadenas == null || otroArreglo == null) {
            return false;
        }

        Collection<String> listaArreglo = Arrays.asList(otroArreglo);
        return conjuntoCadenas.containsAll(listaArreglo);
    }

	public String getPrimera() {
		if (conjuntoCadenas != null && !conjuntoCadenas.isEmpty()) {
            Iterator<String> iterator = conjuntoCadenas.iterator();
            return iterator.next();
        }
        return null;
    }

    public Collection<String> getSiguientes(String string) {
        if (conjuntoCadenas == null || conjuntoCadenas.isEmpty()) {
            return null;
        }

        Iterator<String> iterator = conjuntoCadenas.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(string)) {
                break;
            }
        }

        Collection<String> siguientes = new LinkedList<>();
        while (iterator.hasNext()) {
            siguientes.add(iterator.next());
        }

        return siguientes;
    }

    public String getUltima() {
        if (conjuntoCadenas != null && !conjuntoCadenas.isEmpty()) {
            String ultima = null;
            for (String cadena : conjuntoCadenas) {
                ultima = cadena;
            }
            return ultima;
        }
        return null;
    }

    public void eliminarPrimera() {
        if (conjuntoCadenas != null && !conjuntoCadenas.isEmpty()) {
            Iterator<String> iterator = conjuntoCadenas.iterator();
            conjuntoCadenas.remove(iterator.next());
        }
    }

    public TreeSet<String> invertirCadenas() {
        if (conjuntoCadenas == null || conjuntoCadenas.isEmpty()) {
            return null;
        }

        TreeSet<String> invertido = new TreeSet<>(Collections.reverseOrder());
        invertido.addAll(conjuntoCadenas);
        return invertido;
    }
}