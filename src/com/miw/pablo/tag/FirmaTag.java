package com.miw.pablo.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class FirmaTag extends TagSupport {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int doEndTag() throws JspException {
		String footer = "<p><small>© copyright <a href=\"mailto:UO173780@uniovi.es\">"
				+ name + "</a> 2013 MIW-LEW</small></p>";
		try {
			pageContext.getOut().println(footer);
		} catch (IOException e) {
		} // Ignore it
		return EVAL_PAGE;
	}
}