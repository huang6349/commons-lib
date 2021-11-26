package org.huangyalong.commons.exception;

import cn.hutool.core.util.IdUtil;
import org.huangyalong.commons.info.ShowType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class InternalServerErrorExceptionTest {

    private final String errorMessage = "COMMONS_TEST_ERROR";

    private final Integer errorCode = 500;

    private final ShowType showType = ShowType.NOTIFICATION;

    private final String traceId = IdUtil.randomUUID();

    private final String host = "locahost";

    @Test
    void test1() {
        InternalServerErrorException exception = Assertions.assertThrows(InternalServerErrorException.class, () -> {
            throw new InternalServerErrorException(errorMessage);
        });
        Assertions.assertEquals(exception.getMessage(), errorMessage);
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        Assertions.assertEquals(exception.getShowType(), ShowType.ERROR_MESSAGE);
        Assertions.assertNull(exception.getTraceId());
        Assertions.assertNull(exception.getHost());
    }

    @Test
    void test2() {
        InternalServerErrorException exception = Assertions.assertThrows(InternalServerErrorException.class, () -> {
            throw new InternalServerErrorException(errorMessage, errorCode);
        });
        Assertions.assertEquals(exception.getMessage(), errorMessage);
        Assertions.assertEquals(exception.getErrorCode(), errorCode);
        Assertions.assertEquals(exception.getShowType(), ShowType.ERROR_MESSAGE);
        Assertions.assertNull(exception.getTraceId());
        Assertions.assertNull(exception.getHost());
    }

    @Test
    void test3() {
        InternalServerErrorException exception = Assertions.assertThrows(InternalServerErrorException.class, () -> {
            throw new InternalServerErrorException(errorMessage, errorCode, showType);
        });
        Assertions.assertEquals(exception.getMessage(), errorMessage);
        Assertions.assertEquals(exception.getErrorCode(), errorCode);
        Assertions.assertEquals(exception.getShowType(), showType);
        Assertions.assertNull(exception.getTraceId());
        Assertions.assertNull(exception.getHost());
    }

    @Test
    void test4() {
        InternalServerErrorException exception = Assertions.assertThrows(InternalServerErrorException.class, () -> {
            throw new InternalServerErrorException(errorMessage, traceId, host);
        });
        Assertions.assertEquals(exception.getMessage(), errorMessage);
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        Assertions.assertEquals(exception.getShowType(), ShowType.ERROR_MESSAGE);
        Assertions.assertEquals(exception.getTraceId(), traceId);
        Assertions.assertEquals(exception.getHost(), host);
    }

    @Test
    void test5() {
        InternalServerErrorException exception = Assertions.assertThrows(InternalServerErrorException.class, () -> {
            throw new InternalServerErrorException(errorMessage, errorCode, traceId, host);
        });
        Assertions.assertEquals(exception.getMessage(), errorMessage);
        Assertions.assertEquals(exception.getErrorCode(), errorCode);
        Assertions.assertEquals(exception.getShowType(), ShowType.ERROR_MESSAGE);
        Assertions.assertEquals(exception.getTraceId(), traceId);
        Assertions.assertEquals(exception.getHost(), host);
    }

    @Test
    void test6() {
        InternalServerErrorException exception = Assertions.assertThrows(InternalServerErrorException.class, () -> {
            throw new InternalServerErrorException(errorMessage, showType, traceId, host);
        });
        Assertions.assertEquals(exception.getMessage(), errorMessage);
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        Assertions.assertEquals(exception.getShowType(), showType);
        Assertions.assertEquals(exception.getTraceId(), traceId);
        Assertions.assertEquals(exception.getHost(), host);
    }

    @Test
    void test7() {
        InternalServerErrorException exception = Assertions.assertThrows(InternalServerErrorException.class, () -> {
            throw new InternalServerErrorException(errorMessage, errorCode, showType, traceId, host);
        });
        Assertions.assertEquals(exception.getMessage(), errorMessage);
        Assertions.assertEquals(exception.getErrorCode(), errorCode);
        Assertions.assertEquals(exception.getShowType(), showType);
        Assertions.assertEquals(exception.getTraceId(), traceId);
        Assertions.assertEquals(exception.getHost(), host);
    }
}
