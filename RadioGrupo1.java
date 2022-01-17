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

    

    public RadioGrupo1(boolean frecuencia, double estacion, boolean estado, double[] guardados) {
        this.frecuencia = frecuencia;
        this.estacion = estacion;
        this.estado = estado;
        this.guardados = guardados;
    }

    public RadioGrupo1(){
        this.frecuencia = true;
        this.estacion = 530;
        this.estado = true;
    }


    public boolean isFrecuencia() {
        return frecuencia;
    }
    public double[] getGuardados() {
        return guardados;
    }
    public void setGuardados(double guardados[]) {
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

	@Override
	public boolean isOn() {
		// TODO Auto-generated method stub
		return estado;
	}

	@Override
	public void turnOnOff() {
		// TODO Auto-generated method stub
		estado = !estado;
		
	}

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

	@Override
	public double getStation() {
		// TODO Auto-generated method stub
		return estacion;
	}

	@Override
	public void saveStation(int position, double station) {
		// TODO Auto-generated method stub
		this.guardados[position] = station;
		
	}

	@Override
	public double getSavedStation(int position) {
		// TODO Auto-generated method stub
		estacion = this.guardados[position];
		frecuencia = estacion > 200;
		return estacion;
	}

	@Override
	public boolean getFrequency() {
		// TODO Auto-generated method stub
		return frecuencia;
	}

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
