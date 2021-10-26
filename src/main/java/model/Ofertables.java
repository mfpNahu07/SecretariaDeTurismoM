package model;


import java.util.List;

public interface Ofertables {
public int getCosto();
public double getTiempo();
public TipoDeAtraccion getTipo();
public boolean hayCupo();
public boolean esPromocion();
public List<Atraccion> atraccionesIncluidas();
public boolean esOContiene(Ofertables oferta);

}
