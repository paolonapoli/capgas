/**
 *
 */
package it.cs.capgas.entity;

import java.io.Serializable;
import java.util.Currency;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Class ProductCategory
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
@Entity
@Table(name = "GAS_PRODUCT", uniqueConstraints = { @UniqueConstraint(columnNames = { "NAME", "SOLIDAL_GROUP_ID" }) /* TODO: CHANGE GROUP_ID WITH USERNAME */ })
public class Product implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -8327833668341091316L;

    /* Entity Fields */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @Column(name = "VISIBLE", nullable = false)
    protected Boolean visible = false; // default value

    @Column(name = "START_DATE")
    protected Date startDate;

    @Column(name = "END_DATE")
    protected Date endDate;

    @Column(name = "STD_PRICE", nullable = false)
    protected Currency stdPrice;

    @Column(name = "STD_QTY", nullable = false)
    protected Integer stdQty;

    @Column(name = "PHOTO_DIR_PATH")
    protected String photoDirPath;

    @Column(name = "PHOTO_FILE_NAME")
    protected String photoFileName;

    /* FK fields */
    @ManyToMany
    @JoinTable(name = "GAS_PRODUCT_CATEGORY", joinColumns = { @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
	    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID") })
    protected Set<Category> categories;

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
     * Getter for the field visible.
     *
     * @return the visible
     */
    public Boolean getVisible() {
	return this.visible;
    }

    /**
     * Setter for the field visible.
     *
     * @param visible
     *            the visible to set
     */
    public void setVisible(Boolean visible) {
	this.visible = visible;
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
     * Getter for the field stdPrice.
     *
     * @return the stdPrice
     */
    public Currency getStdPrice() {
	return this.stdPrice;
    }

    /**
     * Setter for the field stdPrice.
     *
     * @param stdPrice
     *            the stdPrice to set
     */
    public void setStdPrice(Currency stdPrice) {
	this.stdPrice = stdPrice;
    }

    /**
     * Getter for the field stdQty.
     *
     * @return the stdQty
     */
    public Integer getStdQty() {
	return this.stdQty;
    }

    /**
     * Setter for the field stdQty.
     *
     * @param stdQty
     *            the stdQty to set
     */
    public void setStdQty(Integer stdQty) {
	this.stdQty = stdQty;
    }

    /**
     * Getter for the field photoDirPath.
     *
     * @return the photoDirPath
     */
    public String getPhotoDirPath() {
	return this.photoDirPath;
    }

    /**
     * Setter for the field photoDirPath.
     *
     * @param photoDirPath
     *            the photoDirPath to set
     */
    public void setPhotoDirPath(String photoDirPath) {
	this.photoDirPath = photoDirPath;
    }

    /**
     * Getter for the field photoFileName.
     *
     * @return the photoFileName
     */
    public String getPhotoFileName() {
	return this.photoFileName;
    }

    /**
     * Setter for the field photoFileName.
     *
     * @param photoFileName
     *            the photoFileName to set
     */
    public void setPhotoFileName(String photoFileName) {
	this.photoFileName = photoFileName;
    }

    /**
     * Getter for the field categories.
     *
     * @return the categories
     */
    public Set<Category> getCategories() {
	return this.categories;
    }

    /**
     * Setter for the field categories.
     *
     * @param categories
     *            the categories to set
     */
    public void setCategories(Set<Category> categories) {
	this.categories = categories;
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
	return "Product [id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", visible=" + this.visible + ", startDate=" + this.startDate + ", endDate=" + this.endDate
		+ ", stdPrice=" + this.stdPrice + ", stdQty=" + this.stdQty + ", photoDirPath=" + this.photoDirPath + ", photoFileName=" + this.photoFileName + ", categories=" + this.categories
		+ ", solidalGroup=" + this.solidalGroup + "]";
    }
}
