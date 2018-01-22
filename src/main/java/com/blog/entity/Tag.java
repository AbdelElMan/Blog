package com.blog.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.List;

@Entity
@Table(name = "BLOG_TAGS")
@DynamicUpdate
@DynamicInsert
@JsonAutoDetect
public class Tag implements Serializable {

	private static final long serialVersionUID = 1902137089619875043L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, length = 50, columnDefinition = "VARCHAR2(50)")
	private String name;

	@ManyToMany(mappedBy = "tags")
	private List<Entry> entries;

	public Tag() {
	}
	
	public Tag(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

}