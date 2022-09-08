package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println("[예외처리] " + method + "() 메소드 수행중 발생된 예외 메시지: " + exceptObj.getMessage());

//		System.out.println(method + "() �޼ҵ� ���� �� ���� �߻�!");
//		if (exceptObj instanceof IllegalArgumentException) {
//			System.out.println("�������� ���� �ԷµǾ����ϴ�.");
//		} else if (exceptObj instanceof NumberFormatException) {
//			System.out.println("���� ������ ���� �ƴմϴ�.");
//		} else if (exceptObj instanceof Exception) {
//			System.out.println("������ �߻��߽��ϴ�.");
//		}
	}
}