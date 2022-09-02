package com.javateam.SpringBootThymeleafValidation.domain;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Student {

	@NotNull(message = "이름은 필수 사항입니다.")
	@NotEmpty(message = "이름을 작성하십시오.")
	private String name;

	@NotNull(message = "제목은 필수 항목입니다.")
	@Min(value = 2, message = "최소 2자 이상입니다.")
	@Max(value = 20, message = "20자 이하로 작성하십시오.")
	private String subject;

	@NotNull
	@Min(value = 1, message = "1학년이 최저 학년입니다.")
	@Max(value = 4, message = "4학년이 최고 학년입니다.")
	private int grade;

	@NotNull
	@Size(max = 13, min = 13, message = "전화번호는 13자리 이내로 작성합니다.")
	@Pattern(regexp = "01\\d{1}-\\d{3,4}-\\d{4}", 
			 message = "예시(010-1234-5678)와 같이 입력하십시오.")
	private String mobile;

	@NotNull(message = "생년월일을 입력하십시오.")
	@Past(message = "생일은 금일 기준 이전 일이 들어가야 합니다")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate birth;
}