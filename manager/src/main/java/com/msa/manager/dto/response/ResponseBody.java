package com.msa.manager.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseBody implements Serializable, Payload {
	
	private static final long serialVersionUID = 3617813841043984141L;

	private Header header;
	
	private Object body;
	
	public ResponseBody(){
		this.header = new Header();

	}
	
	public ResponseBody(Object payload){
		this.header = new Header();
		this.body = payload;
	}	

}
