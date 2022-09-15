package com.example.demo.exception;

public class DevCreateException extends RuntimeException {
	private DevCreateErrorCode devCreateErrorCode;
	private String message;

	public DevCreateException(DevCreateErrorCode devCreateErrorCode) {
		super(devCreateErrorCode.getMessage());
		System.out.println(devCreateErrorCode.getMessage());
		this.devCreateErrorCode = devCreateErrorCode;
		this.message = devCreateErrorCode.getMessage();
	}

	public DevCreateException(DevCreateErrorCode devCreateErrorCode, String message) {
		super(message);
		System.out.println(devCreateErrorCode.getMessage());
		this.devCreateErrorCode = devCreateErrorCode;
		this.message = message;
	}
}
