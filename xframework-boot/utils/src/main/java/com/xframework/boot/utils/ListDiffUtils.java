package com.xframework.boot.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 比较列表工具
 */
public class ListDiffUtils {

    /**
     * 回调
     *
     * @param <T>
     */
    public interface Callback<T> {

        /**
         * 新增
         *
         * @param obj
         */
        void add(T obj);

        /**
         * 删除数据
         *
         * @param obj
         */
        void delete(T obj);
    }

    /**
     * 比较，适用于没有实现Comparable的对象
     *
     * @param before     比较前的列表
     * @param after      比较后的列表
     * @param callback   回调方法
     * @param comparator 比较方法
     * @param <T>
     */
    static public <T> void diff(List<T> before, List<T> after, Callback<T> callback, Comparator<T> comparator) {
        Collections.sort(before, comparator);
        Collections.sort(after, comparator);

        if (before == null || before.isEmpty()) {
            if (after != null && !after.isEmpty()) {
                for (T obj : after) {
                    callback.add(obj);
                }
            }
        } else if (after == null || after.isEmpty()) {
            if (before != null && !before.isEmpty()) {
                for (T obj : before) {
                    callback.delete(obj);
                }
            }
        } else {
            int maxBefore = before.size();
            int maxAfter = after.size();
            int i = 0;
            int j = 0;
            while (i < maxBefore && j < maxAfter) {
                T beforeObj = before.get(i);
                T afterObj = after.get(j);

                int comp = comparator.compare(beforeObj, afterObj);

                if (comp > 0) {
                    callback.add(afterObj);
                    j++;
                } else if (comp < 0) {
                    callback.delete(beforeObj);
                    i++;
                } else {
                    i++;
                    j++;
                }
            }

            if (i < maxBefore) {
                for (; i < maxBefore; i++) {
                    callback.delete(before.get(i));
                }
            } else if (j < maxAfter) {
                for (; j < maxAfter; j++) {
                    callback.add(after.get(j));
                }
            }
        }

    }

    /**
     * 比较，适用于实现了Comparable的对象
     *
     * @param before   比较前的列表
     * @param after    比较后的列表
     * @param callback 回调方法
     * @param <T>
     */
    static public <T extends Comparable> void diff(List<T> before, List<T> after, Callback<T> callback) {
        Collections.sort(before);
        Collections.sort(after);

        if (before == null || before.isEmpty()) {
            if (after != null && !after.isEmpty()) {
                for (T obj : after) {
                    callback.add(obj);
                }
            }
        } else if (after == null || after.isEmpty()) {
            if (before != null && !before.isEmpty()) {
                for (T obj : before) {
                    callback.delete(obj);
                }
            }
        } else {
            int maxBefore = before.size();
            int maxAfter = after.size();
            int i = 0;
            int j = 0;
            while (i < maxBefore && j < maxAfter) {
                T beforeObj = before.get(i);
                T afterObj = after.get(j);

                int comp = beforeObj.compareTo(afterObj);

                if (comp > 0) {
                    callback.add(afterObj);
                    j++;
                } else if (comp < 0) {
                    callback.delete(beforeObj);
                    i++;
                } else {
                    i++;
                    j++;
                }
            }

            if (i < maxBefore) {
                for (; i < maxBefore; i++) {
                    callback.delete(before.get(i));
                }
            } else if (j < maxAfter) {
                for (; j < maxAfter; j++) {
                    callback.add(after.get(j));
                }
            }
        }

    }
}
