package com.ydisoft.hospital.util;

import java.io.Serializable;

/**
 * 通用数据传输对象
 * @author franke2009
 *
 * @param <T>
 */
public class CommonResult<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/** 异常编码  **/
	public static final int CODE_EXCEPTION = 0;

	/** 正常编码  **/
	public static final int CODE_NORMAL = 1;

	/** 警告编码  **/
	public static final int CODE_WARN = 2;

    /** 逻辑错误编码 */
    public static final int CODE_LOGIC_ERROR = 4;

    /**
     * 返回数据
     */
	private T data;

    /**
     * 错误编码
     */
	private int code;

    /**
     * 错误消息
     */
	private String message;
	
	public CommonResult(){
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

