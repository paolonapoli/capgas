/**
 *
 */
package it.cs.capgas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Class Authority
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
@Entity
@Table(name = "GAS_GROUP", uniqueConstraints = { @UniqueConstraint(columnNames = { "USER_ID", "NAME" }) })
public class Group implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -9142733638227441264L;

    @Id
    @JoinColumn(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = false)
    protected User username;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "GID_ALIAS", nullable = false)
    protected String alias;

    /**
     * Getter for the field alias.
     *
     * @return the alias
     */
    public String getAlias() {
	return this.alias;
    }

    /**
     * Setter for the field alias.
     *
     * @param alias
     *            the alias to set
     */
    public void setAlias(String alias) {
	this.alias = alias;
    }

    /**
     * Getter for the field id.
     *
     * @return the id
     */
    public Long getId() {
	return this.id;
    }

    /**
     * Setter for the field gid.
     *
     * @param gid
     *            the gid to set
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * Getter for the field username.
     *
     * @return the username
     */
    public User getUsername() {
	return this.username;
    }

    /**
     * Setter for the field username.
     *
     * @param username
     *            the username to set
     */
    public void setUsername(User username) {
	this.username = username;
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Group [id=" + this.id + ", username=" + this.username + ", name=" + this.name + ", alias=" + this.alias + "]";
    }
}
