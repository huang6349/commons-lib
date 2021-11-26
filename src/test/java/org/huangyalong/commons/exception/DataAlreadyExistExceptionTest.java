package org.huangyalong.commons.exception;

import cn.hutool.core.util.IdUtil;
import org.huangyalong.commons.info.ShowType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class DataAlreadyExistExceptionTest {

    private final String errorMessage = "COMMONS_TEST_ERROR";

    private final ShowType showType = ShowType.NOTIFICATION;

    private final String traceId = IdUtil.randomUUID();

    private final String host = "locahost";

    @Test
    void test1() {
        DataAlreadyExistException exception = Assertions.assertThrows(DataAlreadyExistException.class, () -> {
            throw new DataAlreadyExistException();
        });
        Assertions.assertEquals(exception.getMessage(), "该数据已存在，请勿重复添加");
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.CONFLICT.value());
        Assertions.assertEquals(exception.getShowType(), ShowType.WARN_MESSAGE);
        Assertions.assertNull(exception.getTraceId());
        Assertions.assertNull(exception.getHost());
    }

    @Test
    void test2() {
        DataAlreadyExistException exception = Assertions.assertThrows(DataAlreadyExistException.class, () -> {
            throw new DataAlreadyExistException(errorMessage);
        });
        Assertions.assertEquals(exception.getMessage(), errorMessage);
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.CONFLICT.value());
        Assertions.assertEquals(exception.getShowType(), ShowType.WARN_MESSAGE);
        Assertions.assertNull(exception.getTraceId());
        Assertions.assertNull(exception.getHost());
    }

    @Test
    void test3() {
        DataAlreadyExistException exception = Assertions.assertThrows(DataAlreadyExistException.class, () -> {
            throw new DataAlreadyExistException(showType);
        });
        Assertions.assertEquals(exception.getMessage(), "该数据已存在，请勿重复添加");
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.CONFLICT.value());
        Assertions.assertEquals(exception.getShowType(), showType);
        Assertions.assertNull(exception.getTraceId());
        Assertions.assertNull(exception.getHost());
    }

    @Test
    void test4() {
        DataAlreadyExistException exception = Assertions.assertThrows(DataAlreadyExistException.class, () -> {
            throw new DataAlreadyExistException(errorMessage, showType);
        });
        Assertions.assertEquals(exception.getMessage(), errorMessage);
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.CONFLICT.value());
        Assertions.assertEquals(exception.getShowType(), showType);
        Assertions.assertNull(exception.getTraceId());
        Assertions.assertNull(exception.getHost());
    }

    @Test
    void test5() {
        DataAlreadyExistException exception = Assertions.assertThrows(DataAlreadyExistException.class, () -> {
            throw new DataAlreadyExistException(traceId, host);
        });
        Assertions.assertEquals(exception.getMessage(), "该数据已存在，请勿重复添加");
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.CONFLICT.value());
        Assertions.assertEquals(exception.getShowType(), ShowType.WARN_MESSAGE);
        Assertions.assertEquals(exception.getTraceId(), traceId);
        Assertions.assertEquals(exception.getHost(), host);
    }

    @Test
    void test6() {
        DataAlreadyExistException exception = Assertions.assertThrows(DataAlreadyExistException.class, () -> {
            throw new DataAlreadyExistException(errorMessage, traceId, host);
        });
        Assertions.assertEquals(exception.getMessage(), errorMessage);
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.CONFLICT.value());
        Assertions.assertEquals(exception.getShowType(), ShowType.WARN_MESSAGE);
        Assertions.assertEquals(exception.getTraceId(), traceId);
        Assertions.assertEquals(exception.getHost(), host);
    }

    @Test
    void test7() {
        DataAlreadyExistException exception = Assertions.assertThrows(DataAlreadyExistException.class, () -> {
            throw new DataAlreadyExistException(showType, traceId, host);
        });
        Assertions.assertEquals(exception.getMessage(), "该数据已存在，请勿重复添加");
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.CONFLICT.value());
        Assertions.assertEquals(exception.getShowType(), showType);
        Assertions.assertEquals(exception.getTraceId(), traceId);
        Assertions.assertEquals(exception.getHost(), host);
    }

    @Test
    void test8() {
        DataAlreadyExistException exception = Assertions.assertThrows(DataAlreadyExistException.class, () -> {
            throw new DataAlreadyExistException(errorMessage, showType, traceId, host);
        });
        Assertions.assertEquals(exception.getMessage(), errorMessage);
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.CONFLICT.value());
        Assertions.assertEquals(exception.getShowType(), showType);
        Assertions.assertEquals(exception.getTraceId(), traceId);
        Assertions.assertEquals(exception.getHost(), host);
    }
}
