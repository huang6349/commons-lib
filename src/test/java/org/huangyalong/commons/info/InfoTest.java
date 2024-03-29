package org.huangyalong.commons.info;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class InfoTest {

    private final List<Integer> data = CollUtil.newArrayList(1, 2, 3);

    private final String e = new RuntimeException("COMMONS_TEST_RUNTIMEERROR").getMessage();

    private final Integer errorCode = 500;

    private final String errorMessage = "COMMONS_TEST_ERROR";

    private final String traceId = IdUtil.randomUUID();

    private final String host = "locahost";

    @Test
    void success1() {
        InfoStructure info = new InfoStructure(true, data);
        compare(info, Info.success(data));
    }

    @Test
    void success2() {
        InfoStructure info = new InfoStructure(true, data, errorMessage, ShowType.WARN_MESSAGE.getShowType());
        compare(info, Info.success(data, errorMessage));
    }

    @Test
    void success3() {
        InfoStructure info = new InfoStructure(true, data, errorMessage, ShowType.ERROR_MESSAGE.getShowType());
        compare(info, Info.success(data, errorMessage, ShowType.ERROR_MESSAGE));
    }

    @Test
    void error1() {
        InfoStructure info = new InfoStructure(false, errorCode, errorMessage, ShowType.ERROR_MESSAGE.getShowType(), e);
        compare(info, Info.error(errorCode, errorMessage, e));
    }

    @Test
    void error2() {
        InfoStructure info = new InfoStructure(false, errorCode, errorMessage, ShowType.NOTIFICATION.getShowType(), e);
        compare(info, Info.error(errorCode, errorMessage, e, ShowType.NOTIFICATION));
    }

    @Test
    void error3() {
        InfoStructure info = new InfoStructure(false, errorCode, errorMessage, ShowType.ERROR_MESSAGE.getShowType(), e, traceId, host);
        compare(info, Info.error(errorCode, errorMessage, e, traceId, host));
    }

    @Test
    void error4() {
        InfoStructure info = new InfoStructure(false, errorCode, errorMessage, ShowType.NOTIFICATION.getShowType(), e, traceId, host);
        compare(info, Info.error(errorCode, errorMessage, e, ShowType.NOTIFICATION, traceId, host));
    }

    private void compare(InfoStructure a, InfoStructure b) {
        Assertions.assertThat(a.getSuccess()).isEqualTo(b.getSuccess());
        Assertions.assertThat(a.getData()).isEqualTo(b.getData());
        Assertions.assertThat(a.getErrorCode()).isEqualTo(b.getErrorCode());
        Assertions.assertThat(a.getErrorMessage()).isEqualTo(b.getErrorMessage());
        Assertions.assertThat(a.getShowType()).isEqualTo(b.getShowType());
        Assertions.assertThat(a.getE()).isEqualTo(b.getE());
        Assertions.assertThat(a.getTraceId()).isEqualTo(b.getTraceId());
        Assertions.assertThat(a.getHost()).isEqualTo(b.getHost());
    }
}
