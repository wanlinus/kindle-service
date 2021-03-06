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

package cn.wanli.kindle.domain;

import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author wanli
 * @date 2018-12-06 21:39
 */
@Entity
@Table(name = "tb_permission")
public class Permission implements Serializable {

    @Id
    @Column(name = "per_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "per_name", length = 32, nullable = false)
    private String name;

    @Column(name = "per_desc", length = 64)
    private String desc;

    @OneToMany(mappedBy = "permission")
    private List<MidRolePermission> midRolePermissions;

    public Permission() {
    }

    public Permission(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<MidRolePermission> getMidRolePermissions() {
        return midRolePermissions;
    }

    public void setMidRolePermissions(List<MidRolePermission> midRolePermissions) {
        this.midRolePermissions = midRolePermissions;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
