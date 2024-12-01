package com.usta.interfaces;

import java.util.List;

public interface Funcionalidad<T> {

    public boolean registrar(T elObjeto);

    public List<T> consultar(String orden);

    public T buscar(Integer llavePrimaria);

    public boolean eliminar(Integer llavePrimaria);

    public boolean actualizar(T elObjeto);

    public Integer totalRegistros();

    public List<T> buscarNombre(String dato, String nombre);

}
