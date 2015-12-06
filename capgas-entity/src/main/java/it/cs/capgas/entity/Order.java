/**
 *
 */
package it.cs.capgas.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class Order
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
@Entity
@Table(name = "GAS_ORDER")
public class Order implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4502499044952844821L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "START_DATE", nullable = false)
    protected Date startDate;

    @Column(name = "END_DATE", nullable = false)
    protected Date endDate;

    @Column(name = "DELIVERY_START", nullable = false)
    protected Date deliveryStart;

    @Column(name = "DELIVERY_END", nullable = false)
    protected Date deliveryEnd;

    @Lob
    @Column(name = "DELIVERY_NOTE")
    protected Double deliveryNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVERY_PLACE_ID", nullable = false)
    protected Place deliveryPlace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOLIDAL_GROUP_ID", nullable = false)
    protected SolidalGroup solidalGroup;

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
     * Getter for the field startDate.
     *
     * @return the startDate
     */
    public Date getStartDate() {
	return this.startDate;
    }

    /**
     * Setter for the field startDate.
     *
     * @param startDate
     *            the startDate to set
     */
    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    /**
     * Getter for the field endDate.
     *
     * @return the endDate
     */
    public Date getEndDate() {
	return this.endDate;
    }

    /**
     * Setter for the field endDate.
     *
     * @param endDate
     *            the endDate to set
     */
    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    /**
     * Getter for the field deliveryStart.
     *
     * @return the deliveryStart
     */
    public Date getDeliveryStart() {
	return this.deliveryStart;
    }

    /**
     * Setter for the field deliveryStart.
     *
     * @param deliveryStart
     *            the deliveryStart to set
     */
    public void setDeliveryStart(Date deliveryStart) {
	this.deliveryStart = deliveryStart;
    }

    /**
     * Getter for the field deliveryEnd.
     *
     * @return the deliveryEnd
     */
    public Date getDeliveryEnd() {
	return this.deliveryEnd;
    }

    /**
     * Setter for the field deliveryEnd.
     *
     * @param deliveryEnd
     *            the deliveryEnd to set
     */
    public void setDeliveryEnd(Date deliveryEnd) {
	this.deliveryEnd = deliveryEnd;
    }

    /**
     * Getter for the field deliveryNote.
     *
     * @return the deliveryNote
     */
    public Double getDeliveryNote() {
	return this.deliveryNote;
    }

    /**
     * Setter for the field deliveryNote.
     *
     * @param deliveryNote
     *            the deliveryNote to set
     */
    public void setDeliveryNote(Double deliveryNote) {
	this.deliveryNote = deliveryNote;
    }

    /**
     * Getter for the field deliveryPlace.
     *
     * @return the deliveryPlace
     */
    public Place getDeliveryPlace() {
	return this.deliveryPlace;
    }

    /**
     * Setter for the field deliveryPlace.
     *
     * @param deliveryPlace
     *            the deliveryPlace to set
     */
    public void setDeliveryPlace(Place deliveryPlace) {
	this.deliveryPlace = deliveryPlace;
    }

    /**
     * Getter for the field solidalGroup.
     *
     * @return the solidalGroup
     */
    public SolidalGroup getSolidalGroup() {
	return this.solidalGroup;
    }

    /**
     * Setter for the field solidalGroup.
     *
     * @param solidalGroup
     *            the solidalGroup to set
     */
    public void setSolidalGroup(SolidalGroup solidalGroup) {
	this.solidalGroup = solidalGroup;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Order [id=" + this.id + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", deliveryStart=" + this.deliveryStart + ", deliveryEnd=" + this.deliveryEnd
		+ ", deliveryNote=" + this.deliveryNote + ", deliveryPlace=" + this.deliveryPlace + ", solidalGroup=" + this.solidalGroup + "]";
    }
}
