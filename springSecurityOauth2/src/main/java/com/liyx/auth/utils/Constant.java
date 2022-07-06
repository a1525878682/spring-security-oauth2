package com.liyx.auth.utils;

/**
 * @author ouyangxiap
 * @version 1.0
 * @date 2020/8/28 14:03
 */
public class Constant {

    /**
     * Zuul请求头TOKEN名称（不要有空格）
     */
    public static final String ZUUL_TOKEN_HEADER = "ZuulToken";
    /**
     * Zuul请求头TOKEN值
     */
    public static final String ZUUL_TOKEN_VALUE = "zuul:123456";

    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "test@2020!";
    /**
     * gif类型
     */
    public static final String GIF = "gif";
    /**
     * png类型
     */
    public static final String PNG = "png";

    /**
     * 验证码 key前缀
     */
    public static final String CODE_PREFIX = "yuan.captcha.";

    /**
     * 排序规则：降序
     */
    public static final String ORDER_DESC = "desc";

    /**
     * 排序规则：升序
     */
    public static final String ORDER_ASC = "asc";

    /**
     * 主机资产
     */
    public static final String HOST_ASSET = "1";

    /**
     * 应用资产
     */
    public static final String WEB_ASSET = "2";

    /**
     * 操作状态 1-提交
     */
    public static final String SUBMIT = "1";

    /**
     * 操作状态 0-撤回
     */
    public static final String RECALL = "0";

    /**
     * 任务已完成
     */
    public static final String TASK_OVER = "2";
    /**
     * 任务已停止
     */
    public static final String TASK_STOP = "0";
    /**
     * 任务等待执行
     */
    public static final String TASK_TODO = "3";
    /**
     * 任务正在执行
     */
    public static final String TASK_DOING = "1";
    /**
     * 任务id 快速扫描类型
     */
    public static final Integer TASK_TYPE_FAST = 1;
    /**
     * 任务id 深度扫描类型
     */
    public static final Integer TASK_TYPE_DETECT = 2;
    /**
     * 任务id自定义扫描类型
     */
    public static final Integer TASK_TYPE_CUSTOM = 3;
    /**
     * 任务id发现新资产类型
     */
    public static final Integer TASK_TYPE_NEW_ASSET = 6;
    /**
     * 任务id端口存活类型
     */
    public static final Integer TASK_TYPE_PORT_ALIVE = 7;
    /**
     * 任务id资产监控类型
     */
    public static final Integer TASK_TYPE_MONITOR = 999;

    /**
     * 任务id漏扫类型
     */
    public static final Integer TASK_TYPE_RISK = 5;

    /**
     * 自定义扫描ip范围,扫描现有资产
     */
    public static final Integer IP_RANGE_EXIST = 1;

    /**
     * 自定义扫描ip范围,扫描ip库中全部
     */
    public static final String IP_RANGE_ALL = "all";

    /**
     * 自定义扫描ip范围,按部门选择ip
     */
    public static final String IP_RANGE_DEPT = "byDept";

    /**
     * 自定义扫描ip范围,自定义ip
     */
    public static final String IP_RANGE_CUSTOM = "custom";

    /**
     * 请求发送成功
     */
    public static final Integer CODE_SUCCESS = 0;

    /**
     * 角色:超级管理员
     */
    public static final Integer GROUP_SYSTEM = 1;

    /**
     * 角色:风险管理员
     */
    public static final Integer GROUP_FLAW = 2;

    /**
     * 角色:资产管理员
     */
    public static final Integer GROUP_ASSET = 3;
    /**
     * 角色:部门负责人
     */
    public static final Integer GROUP_DEPT = 4;

    public static final String FULL_DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 异常资产监测 过多端口
     */
    public static final String MORE_PORTS = "1";

    /**
     * 异常资产监测 过多非常见端口
     */
    public static final String MORE_UNUSUAL_PORTS = "2";

    /**
     * 异常资产监测 多个远程运维服务
     */
    public static final String MANY_REMOTE_SERVICE = "3";

    /**
     * 异常资产监测 进程异常
     */
    public static final String PROCESS_EXCEPTION = "4";

    /**
     * 异常资产监测 IP消失
     */
    public static final String IP_DISAPPEAR = "5";

    /**
     * 异常资产监测 无效资产
     */
    public static final String INVALID_ASSETS = "6";

    /**
     * 异常资产监测 资产被替换
     */
    public static final String REPLACE_ASSETS = "7";

    /**
     * 异常资产监测 无主资产
     */
    public static final String OWNERLESS_ASSETS = "8";
}
