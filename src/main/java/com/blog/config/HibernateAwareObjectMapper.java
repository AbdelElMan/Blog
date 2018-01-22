package com.blog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = -7352617251029990494L;

	public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module());
    }
}