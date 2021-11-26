package org.huangyalong.commons.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.huangyalong.commons.info.ShowType;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class InternalServerErrorException extends RuntimeException {

    private static final long serialVersionUID = 5899807313916831250L;

    private Integer errorCode = HttpStatus.INTERNAL_SERVER_ERROR.value();

    private ShowType showType = ShowType.ERROR_MESSAGE;

    private String traceId;

    private String host;

    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InternalServerErrorException(String message, Integer errorCode, ShowType showType) {
        super(message);
        this.errorCode = errorCode;
        this.showType = showType;
    }

    public InternalServerErrorException(String message, String traceId, String host) {
        super(message);
        this.traceId = traceId;
        this.host = host;
    }

    public InternalServerErrorException(String message, Integer errorCode, String traceId, String host) {
        super(message);
        this.errorCode = errorCode;
        this.traceId = traceId;
        this.host = host;
    }

    public InternalServerErrorException(String message, ShowType showType, String traceId, String host) {
        super(message);
        this.showType = showType;
        this.traceId = traceId;
        this.host = host;
    }

    public InternalServerErrorException(String message, Integer errorCode, ShowType showType, String traceId, String host) {
        super(message);
        this.errorCode = errorCode;
        this.showType = showType;
        this.traceId = traceId;
        this.host = host;
    }
}
