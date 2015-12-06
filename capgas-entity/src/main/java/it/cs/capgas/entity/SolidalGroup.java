/**
 *
 */
package it.cs.capgas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * Class Solidal Group
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
@Entity
@Table(name = "GAS_SOLIDAL_GROUP")
public class SolidalGroup implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -5627948640509166306L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "SolidalGroup [" + (this.id != null ? "id=" + this.id + ", " : "") + (this.name != null ? "name=" + this.name + ", " : "")
		+ (this.description != null ? "description=" + this.description : "") + "]";
    }
}
