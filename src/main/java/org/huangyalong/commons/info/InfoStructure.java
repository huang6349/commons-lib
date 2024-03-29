package org.huangyalong.commons.info;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class InfoStructure implements Serializable {

    private static final long serialVersionUID = -6005192455561666565L;

    private Boolean success;

    private Object data;

    private Integer errorCode;

    private String errorMessage;

    private Integer showType;

    private String e;

    private String traceId;

    private String host;

    public InfoStructure(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public InfoStructure(Boolean success, Object data, String errorMessage, Integer showType) {
        this.success = success;
        this.data = data;
        this.errorMessage = errorMessage;
        this.showType = showType;
    }

    public InfoStructure(Boolean success, Integer errorCode, String errorMessage, Integer showType, String e) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.showType = showType;
        this.e = e;
    }

    public InfoStructure(Boolean success, Integer errorCode, String errorMessage, Integer showType, String e, String traceId, String host) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.showType = showType;
        this.e = e;
        this.traceId = traceId;
        this.host = host;
    }
}
