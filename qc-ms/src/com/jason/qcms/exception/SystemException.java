package com.jason.qcms.exception;
/**
* @ClassName: SystemException
* @Description: TODO(全局系统异常类，统一处理异常)
* @author jason.peng
* @date 2015年8月19日 下午5:07:02
 */
public class SystemException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SystemException() {
		super();
	}

	public SystemException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemException(String message) {
		super(message);
	}

	public SystemException(Throwable cause) {
		super(cause);
	}

}
