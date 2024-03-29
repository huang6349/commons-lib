package org.huangyalong.commons.exception;

import cn.hutool.core.util.IdUtil;
import org.huangyalong.commons.info.ShowType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class DataNotAlreadyIDExceptionTest {

    private final ShowType showType = ShowType.NOTIFICATION;

    private final String traceId = IdUtil.randomUUID();

    private final String host = "locahost";

    @Test
    void test1() {
        DataNotAlreadyIDException exception = Assertions.assertThrows(DataNotAlreadyIDException.class, () -> {
            throw new DataNotAlreadyIDException();
        });
        Assertions.assertEquals(exception.getMessage(), "新增的数据不能存在编号");
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.CONFLICT.value());
        Assertions.assertEquals(exception.getShowType(), ShowType.WARN_MESSAGE);
        Assertions.assertNull(exception.getTraceId());
        Assertions.assertNull(exception.getHost());
    }

    @Test
    void test2() {
        DataNotAlreadyIDException exception = Assertions.assertThrows(DataNotAlreadyIDException.class, () -> {
            throw new DataNotAlreadyIDException(showType);
        });
        Assertions.assertEquals(exception.getMessage(), "新增的数据不能存在编号");
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.CONFLICT.value());
        Assertions.assertEquals(exception.getShowType(), showType);
        Assertions.assertNull(exception.getTraceId());
        Assertions.assertNull(exception.getHost());
    }

    @Test
    void test3() {
        DataNotAlreadyIDException exception = Assertions.assertThrows(DataNotAlreadyIDException.class, () -> {
            throw new DataNotAlreadyIDException(traceId, host);
        });
        Assertions.assertEquals(exception.getMessage(), "新增的数据不能存在编号");
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.CONFLICT.value());
        Assertions.assertEquals(exception.getShowType(), ShowType.WARN_MESSAGE);
        Assertions.assertEquals(exception.getTraceId(), traceId);
        Assertions.assertEquals(exception.getHost(), host);
    }

    @Test
    void test4() {
        DataNotAlreadyIDException exception = Assertions.assertThrows(DataNotAlreadyIDException.class, () -> {
            throw new DataNotAlreadyIDException(showType, traceId, host);
        });
        Assertions.assertEquals(exception.getMessage(), "新增的数据不能存在编号");
        Assertions.assertEquals(exception.getErrorCode(), HttpStatus.CONFLICT.value());
        Assertions.assertEquals(exception.getShowType(), showType);
        Assertions.assertEquals(exception.getTraceId(), traceId);
        Assertions.assertEquals(exception.getHost(), host);
    }
}
