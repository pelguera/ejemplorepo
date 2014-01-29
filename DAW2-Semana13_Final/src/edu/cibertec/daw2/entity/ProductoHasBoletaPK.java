package edu.cibertec.daw2.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the producto_has_boleta database table.
 * 
 */
@Embeddable
public class ProductoHasBoletaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idproducto;

	private int idboleta;

	public ProductoHasBoletaPK() {
	}
	public int getIdproducto() {
		return this.idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public int getIdboleta() {
		return this.idboleta;
	}
	public void setIdboleta(int idboleta) {
		this.idboleta = idboleta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductoHasBoletaPK)) {
			return false;
		}
		ProductoHasBoletaPK castOther = (ProductoHasBoletaPK)other;
		return 
			(this.idproducto == castOther.idproducto)
			&& (this.idboleta == castOther.idboleta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idproducto;
		hash = hash * prime + this.idboleta;
		
		return hash;
	}
}