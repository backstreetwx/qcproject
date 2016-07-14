package com.jason.qccore.web.result;

/**
 * @ClassName: BaseResult
 * @Description: TODO(基本结果标示，包含状态码字段)
 * @author jason.peng
 * @date 2015年9月3日 下午2:40:52
 */
public class BaseResult implements Result {

	private static final long serialVersionUID = 1L;
	/**
	 * 失败
	 */
	public static final Integer CODE_FAILED = 0;
	/**
	 * 成功
	 */
	public static final Integer CODE_SUCCESS = 1;
	/**
	 * 未授权
	 */
	public static final Integer CODE_UNAUTHORIZED = 401;
	/**
	 * 锁定
	 */
	public static final Integer CODE_LOCKED = 402;
	/**
	 * 禁止
	 */
	public static final Integer CODE_FORBIDDEN = 403;
	/**
	 * 资源未找到
	 */
	public static final Integer CODE_NOT_FOUND = 404;
	/**
	 * 系统错误
	 */
	public static final Integer CODE_SYSTEM_ERROR = 500;
	/**
	 * 系统时间错误
	 */
	public static final Integer CODE_SYSTEM_TIME_ERROR = 501;
	/**
	 * 系统维护
	 */
	public static final Integer CODE_SYSTEM_MAINTENANCE = 503;
	
	/**
	 * 用户没有领取红包
	 */
	public static final Integer CODE_PACKET_STATUS_NO = 1001;
	/**
	 * 用户领取红包
	 */
	public static final Integer CODE_PACKET_STATUS_YES = 1002;
	/**
	 * 用户积分不足
	 */
	public static final Integer USER_POINT_NOT_ENOUGH = 2001;
	/**
	 * 用户没有抢红包
	 */
	public static final Integer CODE_PACKET_NO = 3001;
	/**
	 * 用户抢过红包
	 */
	public static final Integer CODE_PACKET_YES = 3002;
	/**
	 * 抢红包时间还没到
	 */
	public static final Integer CODE_PACKET_TIME_NO = 3003;
	/**
	 * 抢红包时间
	 */
	public static final Integer CODE_PACKET_TIME_YES = 3004;
	
	private Integer code;

	public BaseResult() {

	}

	public BaseResult(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
