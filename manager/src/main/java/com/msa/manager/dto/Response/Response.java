package com.msa.manager.dto.Response;

import com.msa.manager.common.utils.ErrorCode;
import com.msa.manager.common.utils.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Response<T> {
    private Header header;
    private T body;

    public Response(){
    }
    Response(T body){
        this.header = new Header(RequestStatus.SUCCESS,0,null);
        this.body = body;
    }

    public void setHeader(RequestStatus status, int errorCode, String message){
        this.header = new Header(status,errorCode,message);
    }

}
@Data
@AllArgsConstructor
class Header {
    RequestStatus status;
    int errorCode;
    String message;
}

