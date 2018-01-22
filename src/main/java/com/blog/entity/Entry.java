package com.blog.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BLOG_ENTRIES")
@DynamicUpdate
@DynamicInsert
@JsonAutoDetect
@NamedQueries({
	@NamedQuery(name=Entry.FindAll, query="SELECT e FROM Entry e order by e.createdOn desc")
})
public class Entry implements Serializable {

	private static final long serialVersionUID = 2451468147292632278L;
	
	public static final String FindAll = "Entry.FindAll";

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty(message = "{default.NotEmpty}")
	@Column(nullable = false, length = 300, columnDefinition = "VARCHAR2(300)")
	private String title;

	@NotEmpty(message = "{default.NotEmpty}")
	@Column(nullable = false, length = 3000, columnDefinition = "VARCHAR2(3000)")
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "DATE")
	private Date createdOn;

	@ManyToOne
	@JoinColumn(columnDefinition = "user_id", referencedColumnName = "id")
	private User user;

	@OneToMany(mappedBy = "entry")
	private List<Comment> comments;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "blog_entry_tag", joinColumns = @JoinColumn(name = "entry_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public void addTag(Tag tag) {
		tags.add(tag);
		tag.getEntries().add(this);
	}

	public void removeTag(Tag tag) {
		tags.remove(tag);
		tag.getEntries().remove(this);
	}

}