package uniandes.dpoo.estructuras.logica;

import java.util.*;

public class SandboxMapas {
    private Map<String, String> mapaCadenas;

    public SandboxMapas() {
        mapaCadenas = new HashMap<>();
    }

    public List<String> getValoresComoLista() {
        List<String> listaValores = new ArrayList<>(mapaCadenas.values());
        Collections.sort(listaValores);
        return listaValores;
    }

    public List<String> getLlavesComoListaInvertida() {
        List<String> llaves = new ArrayList<>(mapaCadenas.keySet());
        llaves.sort(Collections.reverseOrder());
        return llaves;
    }

    public String getPrimera() {
        return mapaCadenas.isEmpty() ? null : Collections.min(mapaCadenas.keySet());
    }

    public String getUltima() {
        return mapaCadenas.isEmpty() ? null : Collections.max(mapaCadenas.values());
    }

    public Collection<String> getLlaves() {
        List<String> llavesMayusculas = new ArrayList<>();
        mapaCadenas.keySet().forEach(llave -> llavesMayusculas.add(llave.toUpperCase()));
        return llavesMayusculas;
    }

    public int getCantidadCadenasDiferentes() {
        return new HashSet<>(mapaCadenas.values()).size();
    }

    public void agregarCadena(String cadena) {
        if (!cadena.isEmpty()) {
            mapaCadenas.put(new StringBuilder(cadena).reverse().toString(), cadena);
        }
    }

    public void eliminarCadenaConLLave(String llave) {
        mapaCadenas.remove(llave);
    }

    public void eliminarCadenaConValor(String valor) {
        mapaCadenas.values().removeIf(val -> val.equals(valor));
    }

    public void reiniciarMapaCadenas(List<Object> objetos) {
        mapaCadenas.clear();
        objetos.forEach(obj -> agregarCadena(obj.toString()));
    }

    public void volverMayusculas() {
        Map<String, String> mapanew = new HashMap<>();
        mapaCadenas.forEach((key, value) -> mapanew.put(key.toUpperCase(), value));
        mapaCadenas = mapanew;
    }

    public boolean compararValores(String[] otroArreglo) {
        return mapaCadenas.values().containsAll(Arrays.asList(otroArreglo));
    }
}