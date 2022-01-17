/******************************************************************
Ultima modificacion: 14/01/2022

Clase radio grupo 1
@file RadioGrupo1.java

******************************************************************/

public class RadioGrupo1 implements Radio{
    private boolean frecuencia;
    private double estacion;
    private boolean estado;
    private double[] guardados = new double[12];

    /**
     * Constructor.
     * Inicializa la frecuencia a true: AM
     * La estación a 530
     * Inicia en estado true: encendido
     */
    public RadioGrupo1(){
        this.frecuencia = true;
        this.estacion = 530;
        this.estado = true;
    }

    /**
     * Indica el arreglo de estaciones guardadas
     * @return arreglo de estaciones guardadas
     */
    public double[] getGuardados() {
        return guardados;
    }
    
    /**
     * Establece un arreglo nuevo de estaciones guardadas
     * @param guardados arreglo nuevo de estaciones
     */
    public void setGuardados(double guardados[]) {
        this.guardados = guardados;
    }

    /**
     * Establece una estación específica
     * @param estacion a establecer
     */
    public void setEstacion(double estacion) {
        this.estacion = estacion;
    }

    /**
     * Indica si la radio está prendida
     * @return estado true - encendido / false - apagado
     */
	@Override
	public boolean isOn() {
		return estado;
	}

	/**
	 * Apaga la radio cuando está encendida y viceversa
	 */
	@Override
	public void turnOnOff() {
		// TODO Auto-generated method stub
		estado = !estado;
		
	}

	/**
	 * Avanza a la siguiente estación, si llega al límite, regresa al inicio
	 */
	@Override
	public void nextStation(boolean station) {
		// TODO Auto-generated method stub
		if (frecuencia) {
			estacion += 10;
			if (estacion > 1610) {
				estacion = 530;
			}
		} else {
			estacion += 0.2;
			if (estacion > 107.9) {
				estacion = 87.9;
			}
		}
	}

	/**
	 * Retrocede a la estación anterior, si llega al límite, regresa al final
	 */
	@Override
	public void prevStation(boolean station) {
		// TODO Auto-generated method stub
		if (frecuencia) {
			estacion -= 10;
			if (estacion < 530) {
				estacion = 1610;
			}
		} else {
			estacion -= 0.2;
			if (estacion < 87.9) {
				estacion = 107.9;
			}
		}
		
	}

	/**
	 * Indica la estación actual
	 */
	@Override
	public double getStation() {
		// TODO Auto-generated method stub
		return estacion;
	}

	/**
	 * Guarda la estación en el espacio escogido
	 * @param position índice en el que se guarda
	 * @param station estación a guardar
	 */
	@Override
	public void saveStation(int position, double station) {
		// TODO Auto-generated method stub
		this.guardados[position] = station;
		
	}

	/**
	 * Indica la estación guardada y la pone en la radio
	 * @return estación guardada
	 */
	@Override
	public double getSavedStation(int position) {
		// TODO Auto-generated method stub
		estacion = this.guardados[position];
		frecuencia = estacion > 200;
		return estacion;
	}

	/**
	 * Indica la frecuencia
	 * @return frecuencia true - AM / false - FM
	 */
	@Override
	public boolean getFrequency() {
		// TODO Auto-generated method stub
		return frecuencia;
	}

	/**
	 * Cambia a AM si está en FM y viceversa
	 */
	@Override
	public void switchAMFM() {
		// TODO Auto-generated method stub
		frecuencia = !frecuencia;
		if (frecuencia) {
			estacion = 530;
		} else {
			estacion = 87.9;
		}
	}

    
}
