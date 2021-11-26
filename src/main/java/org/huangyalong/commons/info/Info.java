package org.huangyalong.commons.info;

public interface Info {

    static InfoStructure success(Object data) {
        return new InfoStructure(true, data);
    }

    static InfoStructure success(Object data, String message) {
        return new InfoStructure(true, data, message, ShowType.WARN_MESSAGE.getShowType());
    }

    static InfoStructure success(Object data, String message, ShowType showType) {
        return new InfoStructure(true, data, message, showType.getShowType());
    }

    static InfoStructure error(Integer errorCode, String message, String e) {
        return new InfoStructure(false, errorCode, message, ShowType.ERROR_MESSAGE.getShowType(), e);
    }

    static InfoStructure error(Integer errorCode, String message, String e, ShowType showType) {
        return new InfoStructure(false, errorCode, message, showType.getShowType(), e);
    }

    static InfoStructure error(Integer errorCode, String message, String e, String traceId, String host) {
        return new InfoStructure(false, errorCode, message, ShowType.ERROR_MESSAGE.getShowType(), e, traceId, host);
    }

    static InfoStructure error(Integer errorCode, String message, String e, ShowType showType, String traceId, String host) {
        return new InfoStructure(false, errorCode, message, showType.getShowType(), e, traceId, host);
    }
}
