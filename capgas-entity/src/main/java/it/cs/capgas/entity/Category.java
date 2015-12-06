/**
 *
 */
package it.cs.capgas.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Class Category
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
@Entity
@Table(name = "GAS_CATEGORY")
public class Category implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2132034753110246694L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @ManyToMany(mappedBy = "categories")
    protected Set<Product> products;

    /**
     * Getter for the field id.
     *
     * @return the id
     */
    public Long getId() {
	return this.id;
    }

    /**
     * Setter for the field id.
     *
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * Getter for the field name.
     *
     * @return the name
     */
    public String getName() {
	return this.name;
    }

    /**
     * Setter for the field name.
     *
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Getter for the field description.
     *
     * @return the description
     */
    public String getDescription() {
	return this.description;
    }

    /**
     * Setter for the field description.
     *
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Getter for the field products.
     *
     * @return the products
     */
    public Set<Product> getProducts() {
	return this.products;
    }

    /**
     * Setter for the field products.
     *
     * @param products
     *            the products to set
     */
    public void setProducts(Set<Product> products) {
	this.products = products;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Category [id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", products="
		+ this.products + "]";
    }
}
