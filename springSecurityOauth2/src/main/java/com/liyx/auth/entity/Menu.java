package com.liyx.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author liyx
 * @since 2020-09-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 菜单/按钮ID
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

    /**
     * 上级菜单ID
     */
    private Integer parentId;

    /**
     * 菜单/按钮名称
     */
    private String menuName;

    /**
     * 对应路由path
     */
    private String path;

    /**
     * 对应路由组件
     */
    private String component;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 图标
     */
    private String icon;

    /**
     * 类型  0菜单 1按钮
     */
    private String menuType;

    /**
     * 排序码
     */
    private Integer orderNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private Integer createPerson;

    /**
     * 更新人
     */
    private Integer updatePerson;


}
