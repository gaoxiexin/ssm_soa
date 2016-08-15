package com.ssm.soa.api.exception;

/**
 * 
 * @author gaoxiexin
 *
 */
public enum UserExceptionEnum {

	INVALID_USER(1001001, "无效用户");

	private int state;

	private String msg;

	UserExceptionEnum(int state, String msg) {
		this.state = state;
		this.msg = msg;
	}

	public int getState() {
		return state;
	}

	public String getMsg() {
		return msg;
	}

	public static UserExceptionEnum stateOf(int index) {
		for (UserExceptionEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
