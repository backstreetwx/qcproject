package com.jason.qccore.web.result;

/**
 * @ClassName: MessageResult
 * @Description: TODO(消息结果标示，包含一个消息字段)
 * @author jason.peng
 * @date 2015年9月3日 下午2:41:53
 */
public class MessageResult extends BaseResult {

	private static final long serialVersionUID = 1L;

	private String msg;

	public MessageResult() {
		super();
	}

	public MessageResult(Integer code) {
		super(code);
	}

	public MessageResult(Integer code, String msg) {
		super(code);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
