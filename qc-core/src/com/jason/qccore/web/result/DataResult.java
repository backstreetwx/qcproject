package com.jason.qccore.web.result;

/**
 * @ClassName: DataResult
 * @Description: TODO(数据结果标示，包含一个数据字段)
 * @author jason.peng
 * @date 2015年10月23日 上午9:34:45
 */
public class DataResult<T> extends MessageResult {

	private static final long serialVersionUID = 1L;

	private T data;

	public DataResult() {
		super();
	}
	
	public DataResult(Integer code) {
		super(code);
	}

	public DataResult(Integer code, String msg) {
		super(code, msg);
	}

	public DataResult(Integer code, String msg, T data) {
		super(code, msg);
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
