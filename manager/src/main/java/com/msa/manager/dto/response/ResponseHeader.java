package com.msa.manager.dto.response;

import com.msa.manager.dto.ApiException;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseHeader implements Payload, Serializable {

	private static final long serialVersionUID = 8009272581530140412L;

	private Header header;

	public ResponseHeader(){
		this.header = new Header();

	}

	public ResponseHeader(ApiException e) {
		this.header = new Header();
		header.setStatusCode(e.getErrorCode());
		header.setStatusMessage(e.getErrorMessage());
	}
}
