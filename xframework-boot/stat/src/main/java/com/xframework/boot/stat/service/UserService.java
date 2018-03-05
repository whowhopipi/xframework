package com.xframework.boot.stat.service;

import com.xframework.boot.stat.entity.User;

/**
 * 用户服务
 */
public interface UserService<T> {

    User<T> getCurrentUser();

    User<T> getUserById(T id);

    User<T> getUserByName(String name);
}
