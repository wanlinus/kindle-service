/*
 * kindle electronic book push service
 *
 * Copyright (C) 2018 - wanli <wanlinus@qq.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package cn.wanli.kindle.service;

import cn.wanli.kindle.domain.User;
import cn.wanli.kindle.entity.PaginationData;
import cn.wanli.kindle.entity.PasswordEntity;
import cn.wanli.kindle.entity.UserSimpleEntity;
import cn.wanli.kindle.entity.UserEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author wanli
 * @date 2019-01-04 01:04
 */
public interface UserService {
    /**
     * 查询所有用户
     *
     * @return 所有用户集合
     */
    List<User> findAll();

    /**
     * 分页获取用户信息
     *
     * @param requestPage 请求页数
     * @param pageSize    每页数量
     * @param keyword     关键字
     * @return PaginationData
     */
    PaginationData<UserEntity> pageUsers(int requestPage, int pageSize, String keyword);

    /**
     * 通过用户Id查找用户
     *
     * @param uid 用户ID
     * @return User
     */
    Optional<User> findById(Long uid);

    /**
     * 用户注册
     *
     * @param entity 用户注册数据传输对象
     * @return 注册成功后的用户信息
     */
    User registerUser(UserSimpleEntity entity);

    /**
     * 修改用户信息
     *
     * @param id  用户ID
     * @param entity 包含用户信息的数据传输对象
     */
    void modifyAccount(Long id, UserSimpleEntity entity);

    /**
     * 修改用户昵称
     *
     * @param id       用户ID
     * @param nickname 需要修改的用户昵称
     */
    void modifyNickname(Long id, String nickname);

    /**
     * 修改用户密码
     *
     * @param id     用户ID
     * @param entity 包含用户原始密码和新密码的实体
     * @return 修改成功返回true否则返回false
     */
    boolean modifyPassword(Long id, PasswordEntity entity);


}
