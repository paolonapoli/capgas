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
 * Class Group
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
@Entity
@Table(name = "GAS_PLACE")
public class Place implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 3430749519380596496L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @Column(name = "GPS_LON")
    protected Double gpsLongitude;

    @Column(name = "GPS_LAT")
    protected Double gpsLatitude;

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

    /**
     * Getter for the field gpsLongitude.
     *
     * @return the gpsLongitude
     */
    public Double getGpsLongitude() {
	return this.gpsLongitude;
    }

    /**
     * Setter for the field gpsLongitude.
     *
     * @param gpsLongitude
     *            the gpsLongitude to set
     */
    public void setGpsLongitude(Double gpsLongitude) {
	this.gpsLongitude = gpsLongitude;
    }

    /**
     * Getter for the field gpsLatitude.
     *
     * @return the gpsLatitude
     */
    public Double getGpsLatitude() {
	return this.gpsLatitude;
    }

    /**
     * Setter for the field gpsLatitude.
     *
     * @param gpsLatitude
     *            the gpsLatitude to set
     */
    public void setGpsLatitude(Double gpsLatitude) {
	this.gpsLatitude = gpsLatitude;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Place [" + (this.id != null ? "id=" + this.id + ", " : "") + (this.name != null ? "name=" + this.name + ", " : "")
		+ (this.description != null ? "description=" + this.description + ", " : "") + (this.gpsLongitude != null ? "gpsLongitude=" + this.gpsLongitude + ", " : "")
		+ (this.gpsLatitude != null ? "gpsLatitude=" + this.gpsLatitude : "") + "]";
    }
}
