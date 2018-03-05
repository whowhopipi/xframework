package com.xframework.boot.stat.entity;

import java.io.Serializable;

import com.xframework.boot.web.XframeworkApplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessHeader implements Serializable {
    private static final long serialVersionUID = XframeworkApplication.SERIAL_VERSION;

    public static final short TYPE_REQUEST = 0;
    public static final short TYPE_RESPONSE = 1;

    private String id;

    private String lid;

    private Short type;

    private String name;

    private String value;

}
