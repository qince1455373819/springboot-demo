package com.ywkd.common;
public enum ServerResponseEnum {
	SUCCESS(0, "成功"),
    ERROR(10, "失败"),
    ACCOUNT_NOT_EXIST(11, "账号不存在"),
    DUPLICATE_ACCOUNT(12, "账号重复"),
    ACCOUNT_IS_DISABLED(13, "账号被禁用"),
    INCORRECT_CREDENTIALS(14, "账号或密码错误"),
    NOT_LOGIN_IN(15, "账号未登录"),
    UNAUTHORIZED(16, "没有权限");
	
    Integer code;
    String message;
    private ServerResponseEnum(Integer code,String message) {
    	this.code=code;
    	this.message=message;
    }
	public Integer getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
    public static ServerResponseEnum parse(Integer code) {
    	ServerResponseEnum result=ServerResponseEnum.SUCCESS;
    	switch(code){
    	case 0:
    		result = ServerResponseEnum.SUCCESS;
    		break;
    	case 10:
    		result = ServerResponseEnum.ERROR;
    		break;
    	case 11:
    		result = ServerResponseEnum.ACCOUNT_NOT_EXIST;
    		break;
    	case 12:
    		result = ServerResponseEnum.DUPLICATE_ACCOUNT;
    		break;
    	case 13:
    		result = ServerResponseEnum.ACCOUNT_IS_DISABLED;
    		break;
    	case 14:
    		result = ServerResponseEnum.INCORRECT_CREDENTIALS;
    		break;
    	case 15:
    		result = ServerResponseEnum.NOT_LOGIN_IN;
    		break;
    	case 16:
    		result = ServerResponseEnum.UNAUTHORIZED;
    		break;
    	}
    	return result;
    }
}
