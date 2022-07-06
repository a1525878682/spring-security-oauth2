package com.liyx.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = -4352868070794165999L;

    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 部门
     */
    private Integer deptId;

    /**
     * 岗位名称
     */
    private String position;

    /**
     * 权限组
     */
    private Integer permGroup;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String mail;
    /**
     * 密码
     */
    private String pwd;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 创建人
     */
    private Integer createPerson;

    /**
     * 更新人
     */
    private Integer updatePerson;


    /**
     * 权限组名称
     */
    @TableField(exist = false)
    private String groupName;

    /**
     * 是否首次登录(重置密码后也属于首次登录)  0-是 1-否
     */
    private String loginFlag;

    /**
     * 用户类型 目前只有两种 system 和supportUnit 只有 管理员是system
     */
    @TableField("user_type")
    private String userType;

    /**
     * 部门名称
     */
    @TableField(exist = false)
    private String deptName;

    @TableField(exist = false)
    private String createTimeFrom;
    @TableField(exist = false)
    private String createTimeTo;
    /**
     * 角色 ID
     */
    @TableField(exist = false)
    private String roleId;

    @TableField(exist = false)
    private String roleName;

}
