package org.huangyalong.commons.exception;

import cn.hutool.core.util.IdUtil;
import org.huangyalong.commons.info.ShowType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class BadRequestExceptionTest {

    private final String errorMessage = "COMMONS_TEST_ERROR";

    private final ShowType showType = ShowType.NOTIFICATION;

    private final String traceId = IdUtil.randomUUID();

    private final String host = "locahost";

    @Test
    void test1() {
        BadRequestException exception = Assertions.assertThrows(BadRequestException.class, () -> {
            throw new BadRequestException(errorMessage);
        });
        Assertions.assertEquals(exception.getMessage(), errorMessage);
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.BAD_REQUEST.value());
        Assertions.assertEquals(exception.getShowType(), ShowType.ERROR_MESSAGE);
        Assertions.assertNull(exception.getTraceId());
        Assertions.assertNull(exception.getHost());
    }

    @Test
    void test2() {
        BadRequestException exception = Assertions.assertThrows(BadRequestException.class, () -> {
            throw new BadRequestException(errorMessage, showType);
        });
        Assertions.assertEquals(exception.getMessage(), errorMessage);
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.BAD_REQUEST.value());
        Assertions.assertEquals(exception.getShowType(), showType);
        Assertions.assertNull(exception.getTraceId());
        Assertions.assertNull(exception.getHost());
    }

    @Test
    void test3() {
        BadRequestException exception = Assertions.assertThrows(BadRequestException.class, () -> {
            throw new BadRequestException(errorMessage, traceId, host);
        });
        Assertions.assertEquals(exception.getMessage(), errorMessage);
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.BAD_REQUEST.value());
        Assertions.assertEquals(exception.getShowType(), ShowType.ERROR_MESSAGE);
        Assertions.assertEquals(exception.getTraceId(), traceId);
        Assertions.assertEquals(exception.getHost(), host);
    }

    @Test
    void test4() {
        BadRequestException exception = Assertions.assertThrows(BadRequestException.class, () -> {
            throw new BadRequestException(errorMessage, showType, traceId, host);
        });
        Assertions.assertEquals(exception.getMessage(), errorMessage);
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.BAD_REQUEST.value());
        Assertions.assertEquals(exception.getShowType(), showType);
        Assertions.assertEquals(exception.getTraceId(), traceId);
        Assertions.assertEquals(exception.getHost(), host);
    }
}
