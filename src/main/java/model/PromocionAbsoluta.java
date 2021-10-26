package model;



import java.util.List;

public class PromocionAbsoluta extends Promocion{

	public PromocionAbsoluta(List<Atraccion> atracciones, int costoFinal) {
		super(atracciones, costoFinal);
		//super((atraccion1.getCosto() + atraccion2.getCosto()) - descuentoAbsoluto, atraccion1.getTiempo() + atraccion2.getTiempo(), atraccion1.getTipo());

	}
	@Override
	public String toString() {
		String nombres = "";
		for (Atraccion atr: this.atracciones) {
			nombres+=(atr.getNombre() + "-");
		}
		nombres=nombres.substring(0, nombres.length()-1);
		return ("Promocion "+this.getTipo()+ " incluye "+nombres+" a un costo de "+this.getCosto() +" monedas. Debe disponer de "+this.getTiempo()+"hs para recorrerlo.");
	}
	@Override
	public int getCosto() {
		return this.precioPorTodo;
	}

}
