package com.blog.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;

import com.blog.validator.EmailValid;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="BLOG_USERS")
@DynamicUpdate
@DynamicInsert
@NamedQueries({
	@NamedQuery(name=User.FindByUsername, query="SELECT g FROM User g where g.username = :username")
})
@JsonAutoDetect
public class User implements Serializable {

	private static final long serialVersionUID = 4546249978555897300L;

	public static final String  FindByUsername = "User.FindByUsername";

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false, precision=12, columnDefinition="NUMBER(2,0)")
	private int rol;

	@NotEmpty(message = "{default.NotEmpty}")
	@Column(length=50, columnDefinition="VARCHAR2(50)",unique=true)
	private String username;

	@NotEmpty(message = "{default.NotEmpty}")
	@Column(nullable=false, length=60, columnDefinition="VARCHAR2(60)")
	private String password;

	@Transient
	@NotEmpty(message = "{default.NotEmpty}")
	@Column(nullable=false, length=60, columnDefinition="VARCHAR2(60)")
	private String passwordverification;

	@EmailValid
	@NotEmpty(message = "{default.NotEmpty}")
	@Column(nullable=false, length=60, columnDefinition="VARCHAR2(60)")
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="DATE")
	private Date createdOn;

	@OneToMany(mappedBy="user")
	private List<Entry> entries;

	@OneToMany(mappedBy = "user")
	private List<Comment> comments;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordverification() {
		return passwordverification;
	}

	public void setPasswordverification(String passwordverification) {
		this.passwordverification = passwordverification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}