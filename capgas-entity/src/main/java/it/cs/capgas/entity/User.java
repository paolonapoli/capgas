/**
 *
 */
package it.cs.capgas.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Class User (see http://docs.spring.io/spring-security/site/docs/4.0.3.RELEASE/reference/htmlsingle/#appendix-schema)
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
@Entity
@Table(name = "GAS_USER", uniqueConstraints = { @UniqueConstraint(columnNames = "USERNAME"),
	@UniqueConstraint(columnNames = "EMAIL") })
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 5572288174319479744L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "USERNAME")
    protected String username;

    @Column(name = "PASSWORD", nullable = false)
    protected String password;

    @Column(name = "ENABLED", nullable = false)
    protected Boolean enabled = true; // default

    @Column(name = "EMAIL", nullable = false)
    protected String email;

    @Column(name = "TELEPHONE")
    protected String telephone;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    protected Set<Group> groups;

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
     * Getter for the field username.
     *
     * @return the username
     */
    public String getUsername() {
	return this.username;
    }

    /**
     * Setter for the field username.
     *
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
	this.username = username;
    }

    /**
     * Getter for the field password.
     *
     * @return the password
     */
    public String getPassword() {
	return this.password;
    }

    /**
     * Setter for the field password.
     *
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * Getter for the field enabled.
     *
     * @return the enabled
     */
    public Boolean getEnabled() {
	return this.enabled;
    }

    /**
     * Setter for the field enabled.
     *
     * @param enabled
     *            the enabled to set
     */
    public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
    }

    /**
     * Getter for the field email.
     *
     * @return the email
     */
    public String getEmail() {
	return this.email;
    }

    /**
     * Setter for the field email.
     *
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * Getter for the field telephone.
     *
     * @return the telephone
     */
    public String getTelephone() {
	return this.telephone;
    }

    /**
     * Setter for the field telephone.
     *
     * @param telephone
     *            the telephone to set
     */
    public void setTelephone(String telephone) {
	this.telephone = telephone;
    }

    /**
     * Getter for the field groups.
     *
     * @return the groups
     */
    public Set<Group> getGroups() {
	return this.groups;
    }

    /**
     * Setter for the field groups.
     *
     * @param groups
     *            the groups to set
     */
    public void setGroups(Set<Group> groups) {
	this.groups = groups;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "User [id=" + this.id + ", username=" + this.username + ", password=" + this.password + ", enabled=" + this.enabled
		+ ", email=" + this.email + ", telephone=" + this.telephone + ", groups=" + this.groups + "]";
    }
}
