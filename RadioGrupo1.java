/******************************************************************
Ultima modificacion: 14/01/2022

Clase radio grupo 1
@file RadioGrupo1.java

******************************************************************/

public class RadioGrupo1 implements Radio{
    private boolean frecuencia;
    private double estacion;
    private boolean estado;
    private int guardados[] = new int[12];

    

    public RadioGrupo1(boolean frecuencia, double estacion, boolean estado, int[] guardados) {
        this.frecuencia = frecuencia;
        this.estacion = estacion;
        this.estado = estado;
        this.guardados = guardados;
    }

    public RadioGrupo1(){
        
    }


    public boolean isFrecuencia() {
        return frecuencia;
    }
    public int[] getGuardados() {
        return guardados;
    }
    public void setGuardados(int guardados[]) {
        this.guardados = guardados;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public double getEstacion() {
        return estacion;
    }
    public void setEstacion(double estacion) {
        this.estacion = estacion;
    }
    public void setFrecuencia(boolean frecuencia) {
        this.frecuencia = frecuencia;
    }

    
}
