package org.huangyalong.commons.exception;

import org.huangyalong.commons.info.ShowType;
import org.springframework.http.HttpStatus;

public class DataNotAlreadyIDException extends InternalServerErrorException {

    private static final long serialVersionUID = -5050265227748557450L;

    private static final Integer errorCode = HttpStatus.CONFLICT.value();

    private static final String message = "新增的数据不能存在编号";

    private static final ShowType showType = ShowType.WARN_MESSAGE;

    public DataNotAlreadyIDException() {
        super(message, errorCode, showType);
    }

    public DataNotAlreadyIDException(ShowType showType) {
        super(message, errorCode, showType);
    }

    public DataNotAlreadyIDException(String traceId, String host) {
        super(message, errorCode, showType, traceId, host);
    }

    public DataNotAlreadyIDException(ShowType showType, String traceId, String host) {
        super(message, errorCode, showType, traceId, host);
    }
}
