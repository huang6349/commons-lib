package org.huangyalong.commons.exception;

import org.huangyalong.commons.info.ShowType;
import org.springframework.http.HttpStatus;

public class DataAlreadyIDException extends InternalServerErrorException {

    private static final long serialVersionUID = -5050265227748557450L;

    private static final Integer errorCode = HttpStatus.CONFLICT.value();

    private static final String message = "该数据编号已存在，请勿重复添加";

    private static final ShowType showType = ShowType.WARN_MESSAGE;

    public DataAlreadyIDException() {
        super(message, errorCode, showType);
    }

    public DataAlreadyIDException(ShowType showType) {
        super(message, errorCode, showType);
    }

    public DataAlreadyIDException(String traceId, String host) {
        super(message, errorCode, showType, traceId, host);
    }

    public DataAlreadyIDException(ShowType showType, String traceId, String host) {
        super(message, errorCode, showType, traceId, host);
    }
}
