	package com.blog.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.Date;

@Entity
@Table(name="BLOG_COMMENTS")
@DynamicUpdate
@DynamicInsert
@JsonAutoDetect
public class Comment implements Serializable {

	private static final long serialVersionUID = -94657605405655406L;

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty(message = "{default.NotEmpty}")
	@Column(nullable=false, length=300, columnDefinition="VARCHAR2(300)")
	private String title;

	@NotEmpty(message = "{default.NotEmpty}")
	@Column(nullable=false, length=1000, columnDefinition="VARCHAR2(1000)")
	private String text;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="DATE")
	private Date createdOn;

	@ManyToOne
	@JoinColumn(columnDefinition="entry_id",referencedColumnName="id")
	private Entry entry;

	@ManyToOne
	@JoinColumn(columnDefinition="user_id",referencedColumnName="id")
	private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}