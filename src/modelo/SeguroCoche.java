package modelo;

import java.util.Calendar;

public class SeguroCoche extends Poliza {
	
	private String matricula;
	private int anyoCarnet;
	public static final double porcentaje=0.015; //porcentaje por año de antigüedad
	public static final double novato=75; //recargo por menos de 5 años de carnet
	public static final double siniestro=0.03; //recargo por siniestro

	public SeguroCoche() {
		super();
		this.matricula="";
	}
	

	public SeguroCoche(String idPoliza, String nombre, String apellidos, String dni, int anyo, String formaPago,
			double primaBase, int numSiniestroHistorico, String matricula, int anyoCarnet) {
		super(idPoliza, nombre, apellidos, dni, anyo, formaPago, primaBase, numSiniestroHistorico);
		this.matricula = matricula;
		this.anyoCarnet = anyoCarnet;
	}

	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public int getAnyoCarnet() {
		return anyoCarnet;
	}


	public void setAnyoCarnet(int anyoCarnet) {
		this.anyoCarnet = anyoCarnet;
	}


	@Override
	public String toString() {
		return "SeguroCoche [matricula=" + matricula + ", anyoCarnet=" + anyoCarnet + ", idPoliza=" + idPoliza
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", anyo=" + anyo + ", formaPago="
				+ formaPago + ", primaBase=" + primaBase + ", numSiniestroHistorico=" + numSiniestroHistorico + "]";
	}

	public double calcularPrima() {
		double prima=0;
		int anyo=Calendar.getInstance().get(Calendar.YEAR)-this.getAnyo();
		if (this.getAnyo()<10) {
			prima=this.getPrimaBase()-((this.getPrimaBase()*porcentaje)*anyo);
		} else {
			prima=this.getPrimaBase()-this.getPrimaBase()*porcentaje*10;
		}
		
		if (getAnyoCarnet()<5) {
			prima=prima+novato;
		}
		prima=prima + prima*getNumSiniestroHistorico()*siniestro;
		return prima;
	}
}
