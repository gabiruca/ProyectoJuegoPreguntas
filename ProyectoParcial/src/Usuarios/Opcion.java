/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

/**
 *
 * @author DanielAlvaradoPelaez
 */
public class Opcion {
    private String opcion;
    private TipoRespuesta respuesta;

    public Opcion(String opcion, TipoRespuesta respuesta) {
        this.opcion = opcion;
        this.respuesta = respuesta;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public TipoRespuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(TipoRespuesta respuesta) {
        this.respuesta = respuesta;
    }
    
}
