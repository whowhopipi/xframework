package com.xframework.boot.kaptcha;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="kaptcha")
public class KaptchaPropertites {

	private String sessionKey;

	private String sessionDate;

	private String border;

	private String borderColor;

	private String borderThickness;

	private String noiseColor;

	private String noiseImpl;

	private String obscurificatorImpl;

	private String producerImpl;

	private String textproducerImpl;

	private String textproducerCharString;

	private String textproducerCharLength;

	private String textproducerFontNames;

	private String textproducerFontColor;

	private String textproducerFontSize;

	private String textproducerCharSpace;

	private String wordrendererImpl;

	private String backgroundImpl;

	private String backgroundClrFrom;

	private String backgroundClrTo;

	private String imageWidth;

	private String imageHeight;

	@Value("${kaptcha.url:/captcha.jpg}")
	private String url;

}
