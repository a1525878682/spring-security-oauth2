package com.liyx.auth.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {

	public static final ResultObj  LOGIN_SUCCESS=new ResultObj(Constast.OK, "登陆成功");
	public static final ResultObj  LOGIN_ERROR_PASS=new ResultObj(Constast.ERROR, "登陆失败,用户名或密码不正确");
	public static final ResultObj  LOGIN_ERROR_CODE=new ResultObj(Constast.ERROR, "登陆失败,验证码不正确");
	public static final ResultObj  ADD_REPEAT=new ResultObj(Constast.ERROR, "账号重复");

	public static final ResultObj  UPDATE_SUCCESS=new ResultObj(Constast.OK, "更新成功");
	public static final ResultObj  UPDATE_ERROR=new ResultObj(Constast.ERROR, "更新失败");

	public static final ResultObj  ADD_SUCCESS=new ResultObj(Constast.OK, "添加成功");
	public static final ResultObj  ADD_ERROR=new ResultObj(Constast.ERROR, "添加失败");

	public static final ResultObj  DELETE_SUCCESS=new ResultObj(Constast.OK, "删除成功");
	public static final ResultObj  DELETE_ERROR=new ResultObj(Constast.ERROR, "删除失败");

	public static final ResultObj  RESET_SUCCESS=new ResultObj(Constast.OK, "重置成功");
	public static final ResultObj  RESET_ERROR=new ResultObj(Constast.ERROR, "重置失败");

	public static final ResultObj  DISPATCH_SUCCESS=new ResultObj(Constast.OK, "分配成功");
	public static final ResultObj  DISPATCH_ERROR=new ResultObj(Constast.ERROR, "分配失败");

	public static final ResultObj  OPERATE_SUCCESS=new ResultObj(Constast.OK, "操作成功");
	public static final ResultObj  OPERATE_ERROR=new ResultObj(Constast.ERROR, "操作失败");

	public static final ResultObj  DEPLOY_SUCCESS=new ResultObj(Constast.OK, "发布成功");
	public static final ResultObj  DEPLOY_ERROR=new ResultObj(Constast.ERROR, "发布失败,请检查流程是否正确");

	public static final ResultObj  START_PROCESS_SUCCESS=new ResultObj(Constast.OK, "流程启动成功");
	public static final ResultObj  START_PROCESS_ERROR=new ResultObj(Constast.ERROR, "流程启动失败");

	public static final ResultObj  MISSION_SUCCESS=new ResultObj(Constast.OK, "任务完成");
	public static final ResultObj  MISSION_FAILURE=new ResultObj(Constast.ERROR, "任务完成失败");
	public static final ResultObj  EXPORT_SUCCESS=new ResultObj(Constast.OK, "导出成功");
	public static final ResultObj  EXPORT_FAILURE=new ResultObj(Constast.ERROR, "导出失败");

	public static final ResultObj ASSETS_DEFINE_COLUMN_NULL =new ResultObj(Constast.ERROR, "字段不能为空");
	public static final ResultObj ASSETS_DEFINE_COLUMN_REPEAT =new ResultObj(Constast.ERROR, "字段重复");
	public static final ResultObj ASSETS_DEFINE_ID_ERROR =new ResultObj(Constast.ERROR, "字段ID错误");
	public static final ResultObj ASSETS_DEFINE_SUCCESS =new ResultObj(Constast.OK, "校验通过");
	public static final ResultObj ASSETS_DEFINE_ERROR =new ResultObj(Constast.ERROR, "校验失败");
	public static final ResultObj ADD_IP_REPEAT =new ResultObj(Constast.ERROR, "IP已存在");
	public static final ResultObj ADD_DEPT_REPEAT =new ResultObj(Constast.ERROR, "部门已存在");
	public static final ResultObj DEL_HOST_ERROR = new ResultObj(Constast.ERROR, "删除的主机资产下存在应用资产，不能删除");
	public static final ResultObj ADD_HOST_REPEAT =new ResultObj(Constast.ERROR, "主机资产已存在");
	public static final ResultObj ADD_APP_REPEAT =new ResultObj(Constast.ERROR, "应用资产已存在");
	public static final ResultObj ADD_APP_ERROR =new ResultObj(Constast.ERROR, "主机资产不存在，请先添加主机资产");
	public static final ResultObj ADD_HOST_ERROR =new ResultObj(Constast.ERROR, "IP库不存在此IP");
	public static final ResultObj ADD_ASSET_ERROR =new ResultObj(Constast.ERROR, "请设置资产所属部门");
	public static final ResultObj ADD_ASSET_DEPT_ERROR =new ResultObj(Constast.ERROR, "部门不存在");
	public static final ResultObj IP_NOT_NULL =new ResultObj(Constast.ERROR, "IP不能为空");
	public static final ResultObj IP_PORT_NOT_NULL =new ResultObj(Constast.ERROR, "端口不能为空");
	public static final ResultObj WEB_SITE_NOT_NULL =new ResultObj(Constast.ERROR, "网址不能为空");

	public static final ResultObj NO_CHOOSE =new ResultObj(Constast.ERROR, "请选择记录");

	public static final ResultObj TASK_START_ERROR =new ResultObj(Constast.ERROR, "任务启动失败");
	public static final ResultObj TASK_START_SUCCESS =new ResultObj(Constast.OK, "任务启动成功");
	public static final ResultObj TASK_RISK_RUNNING =new ResultObj(Constast.ERROR, "任务启动失败,漏扫正在执行");

	public static final ResultObj UNDO_FLAW_TASK =new ResultObj(Constast.ERROR, "删除用户失败，该用户还有待办风险任务未处理");
	public static final ResultObj UNDO_ASSET_TASK =new ResultObj(Constast.ERROR, "删除用户失败，该用户下有资产不可删除");


	private Integer code;
	private String msg;



}
