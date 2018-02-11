package com.xframework.boot.web.vo;

import java.util.List;

public class JsonListResponseVo<T> extends JsonDataResponseVo<List<T>> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    final protected static String KEY_TOTAL = "total";
    final protected static String KEY_CURRENT_NUM = "currentNum";

    public long getTotal() {
        Long total = (Long) get(KEY_TOTAL);
        if (total == null) return 0l;
        else return total;
    }

    public void setTotal(long total) {
        put(KEY_TOTAL, total);
    }

    public void setCurrentNum(long currentNum) {
        put(KEY_CURRENT_NUM, currentNum);
    }

    public long getCurrentNum() {
        Long num = (Long) get(KEY_CURRENT_NUM);
        if (num == null) return 0l;
        else return num;
    }

    @Override
    public void setData(List<T> data) {
        Long num = 0l;
        if (data != null) {
            num = Long.valueOf(data.size());
        }
        setCurrentNum(num);
        if (0l == getTotal()) {
            setTotal(num);
        }
        super.setData(data);
    }
}
