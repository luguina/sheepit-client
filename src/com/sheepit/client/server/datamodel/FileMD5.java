package com.sheepit.client.server.datamodel;

import lombok.Getter;
import lombok.ToString;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict = false, name = "file")
@ToString
public class FileMD5 {

	@Attribute
	@Getter
	private String md5;

	@Attribute
	@Getter
	private String action;

	public FileMD5() {
	}
}
