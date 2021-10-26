package model;



import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Atraccion implements Ofertables {
	private String nombre;
	private int costo;
	private double tiempo;
	private int cupos;
	private TipoDeAtraccion tipoDeAtraccion;

	
	public Atraccion(String nombre, int costo, double tiempo, int cupos, TipoDeAtraccion tipoDeAtraccion) {
		this.nombre=nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupos = cupos;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}
	public String toString() {
		return ("Atraccion "+this.getNombre()+" tiene un costo de "+this.getCosto()+" monedas, es de tipo "+this.getTipo()+ ", y se debe disponer de "+this.getTiempo()+"hs para recorrerla"+". Tiene un cupo de "+this.cupos+ " personas");
	}
	@Override
	public int getCosto() {
		
		return this.costo ;
	}
	@Override
	public double getTiempo() {
		
		return this.tiempo;
	}
	@Override
	public TipoDeAtraccion getTipo() {
		// TODO Auto-generated method stub
		return this.tipoDeAtraccion;
	}
	@Override
	public boolean hayCupo() {
		// TODO Auto-generated method stub
		return this.cupos>0;
	}
	@Override
	public boolean esPromocion() {
		// TODO Auto-generated method stub
		return false;
	}
	public String getNombre() {
		return nombre;
	}
	public void restarUnCupo() throws Exception {
		if (this.cupos >= 1)this.cupos-=1;
		else {
			throw new Exception("No quedaban cupos disponibles para esta atraccion");
		}
	}
	@Override
	public List<Atraccion> atraccionesIncluidas() {
		List<Atraccion> incluidas = new LinkedList<Atraccion>();
		incluidas.add(this);
		return incluidas;
	}
	@Override
	public int hashCode() {
		return Objects.hash(costo, cupos, nombre, tiempo, tipoDeAtraccion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costo == other.costo && cupos == other.cupos && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo)
				&& tipoDeAtraccion == other.tipoDeAtraccion;
	}
	@Override
	public boolean esOContiene(Ofertables oferta) {
		return this.equals(oferta);
	}
}