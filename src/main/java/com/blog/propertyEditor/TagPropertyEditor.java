package com.blog.propertyEditor;

import java.beans.PropertyEditorSupport;

import com.blog.entity.Tag;

public class TagPropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(final String text) {
		
		if (text != null && !text.isEmpty()){
			Tag tag = new Tag(text);
			setValue(tag);
		}else{
			setValue(null);	
		}
	
	}

	@Override
	public String getAsText() {
		
		if (this.getValue() != null) {
			Tag tag = (Tag) this.getValue();
			return tag.getName().toString();

		}
		
		return null;
	}

}
