package model;



import java.util.List;

public class PromocionPorcentual extends Promocion {

	public PromocionPorcentual(List <Atraccion> atracciones, double descuentoPorcentual) {
		super(atracciones, descuentoPorcentual);
		
		//super((atraccion1.getCosto() + atraccion2.getCosto()) * (100 - descuentoPorcentual) / 100, atraccion1.getTiempo() + atraccion2.getTiempo(), atraccion1.getTipo()); 
	}
	@Override
	public int getCosto() {
	
		int costoTotal=0;
		for (Atraccion atr: this.atracciones) {
			costoTotal+= atr.getCosto();
		}
		costoTotal = (int) (costoTotal * (1-this.porcentajeDesc));
		return costoTotal;
		
	}
	@Override
	public String toString() {
		String nombres = "";
		for (Atraccion atr: this.atracciones) {
			nombres+=(atr.getNombre() + "-");
		}
		nombres=nombres.substring(0, nombres.length()-1);
		return ("Promocion "+this.getTipo()+ " incluye : "+ nombres +" a un "+this.porcentajeDesc*100+"% off"+", con un costo final de "+this.getCosto() +" monedas. Debe disponer de "+this.getTiempo()+"hs para recorrerlo.");
	}
}
