package model;



import java.util.LinkedList;
import java.util.List;

public class PromocionAxB extends Promocion implements Ofertables{

	public PromocionAxB(List<Atraccion> atracciones, Atraccion atraccionGratis) {
		super(atracciones, atraccionGratis);
	
	}

	@Override
	public boolean hayCupo() {
		for (Atraccion atr: this.atracciones) {
			if  (!atr.hayCupo()) {
				return false;
			}
		}
		if (!this.atrGratis.hayCupo()) return false;
		return true;
	}
	
	
	@Override
	public int getCosto() {
		int costoTotal=0;
		for (Atraccion atr: this.atracciones) {
			costoTotal+= atr.getCosto();
		}
		
		return costoTotal;
			
		}
	
	@Override
	public List<Atraccion> atraccionesIncluidas(){
		List<Atraccion> incluidas = new LinkedList<Atraccion>();
		incluidas.addAll(this.atracciones);
		incluidas.add(atrGratis);
		return incluidas;
	}
	@Override
	public double getTiempo() {
		double tiempoTotal = 0;
		for (Atraccion atr: this.atracciones) {
			tiempoTotal+= atr.getTiempo();
		}
		return tiempoTotal + this.atrGratis.getTiempo();
	}

	@Override
	public String toString() {
		String nombres = "";
		for (Atraccion atr: this.atracciones) {
			nombres+=(atr.getNombre() + "-");
		}
		nombres=nombres.substring(0, nombres.length()-1);
		return ("Promocion "+this.getTipo()+ " incluye "+ nombres +" y de regalo "+this.atrGratis.getNombre()+" a un costo de "+this.getCosto()+" monedas. Debe disponer de "+this.getTiempo()+"hs para recorrerlo." );
	}

	@Override
	public boolean esPromocion() {
		// TODO Auto-generated method stub
		return false;
	}
}
