package com.xframework.boot.kaptcha;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.google.code.kaptcha.Constants;

@ConfigurationProperties(prefix="kaptcha")
public class KaptchaPropertites {

//	@Value("${" + Constants.KAPTCHA_SESSION_CONFIG_KEY + "}")
	private String sessionKey;

//	@Value("${" + Constants.KAPTCHA_SESSION_CONFIG_DATE + "}")
	private String sessionDate;

//	@Value("${" + Constants.KAPTCHA_BORDER + "}")
	private String border;

//	@Value("${" + Constants.KAPTCHA_BORDER_COLOR + "}")
	private String borderColor;

//	@Value("${" + Constants.KAPTCHA_BORDER_THICKNESS + "}")
	private String borderThickness;

//	@Value("${" + Constants.KAPTCHA_NOISE_COLOR + "}")
	private String noiseColor;

//	@Value("${" + Constants.KAPTCHA_NOISE_IMPL + "}")
	private String noiseImpl;

//	@Value("${" + Constants.KAPTCHA_OBSCURIFICATOR_IMPL + "}")
	private String obscurificatorImpl;

//	@Value("${" + Constants.KAPTCHA_PRODUCER_IMPL + "}")
	private String producerImpl;

//	@Value("${" + Constants.KAPTCHA_TEXTPRODUCER_IMPL + "}")
	private String textproducerImpl;

//	@Value("${" + Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING + "}")
	private String textproducerCharString;

//	@Value("${" + Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH + "}")
	private String textproducerCharLength;

//	@Value("${" + Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES + "}")
	private String textproducerFontNames;

//	@Value("${" + Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR + "}")
	private String textproducerFontColor;

//	@Value("${" + Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE + "}")
	private String textproducerFontSize;

//	@Value("${" + Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE + "}")
	private String textproducerCharSpace;

//	@Value("${" + Constants.KAPTCHA_WORDRENDERER_IMPL + "}")
	private String wordrendererImpl;

//	@Value("${" + Constants.KAPTCHA_BACKGROUND_IMPL + "}")
	private String backgroundImpl;

//	@Value("${" + Constants.KAPTCHA_BACKGROUND_CLR_FROM + "}")
	private String backgroundClrFrom;

//	@Value("${" + Constants.KAPTCHA_BACKGROUND_CLR_TO + "}")
	private String backgroundClrTo;

//	@Value("${" + Constants.KAPTCHA_IMAGE_WIDTH + "}")
	private String imageWidth;

//	@Value("${" + Constants.KAPTCHA_IMAGE_HEIGHT + "}")
	private String imageHeight;

	@Value("${kaptcha.url:/captcha.jpg}")
	private String url;

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public String getSessionDate() {
		return sessionDate;
	}

	public void setSessionDate(String sessionDate) {
		this.sessionDate = sessionDate;
	}

	public String getBorder() {
		return border;
	}

	public void setBorder(String border) {
		this.border = border;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public String getBorderThickness() {
		return borderThickness;
	}

	public void setBorderThickness(String borderThickness) {
		this.borderThickness = borderThickness;
	}

	public String getNoiseColor() {
		return noiseColor;
	}

	public void setNoiseColor(String noiseColor) {
		this.noiseColor = noiseColor;
	}

	public String getNoiseImpl() {
		return noiseImpl;
	}

	public void setNoiseImpl(String noiseImpl) {
		this.noiseImpl = noiseImpl;
	}

	public String getObscurificatorImpl() {
		return obscurificatorImpl;
	}

	public void setObscurificatorImpl(String obscurificatorImpl) {
		this.obscurificatorImpl = obscurificatorImpl;
	}

	public String getProducerImpl() {
		return producerImpl;
	}

	public void setProducerImpl(String producerImpl) {
		this.producerImpl = producerImpl;
	}

	public String getTextproducerImpl() {
		return textproducerImpl;
	}

	public void setTextproducerImpl(String textproducerImpl) {
		this.textproducerImpl = textproducerImpl;
	}

	public String getTextproducerCharString() {
		return textproducerCharString;
	}

	public void setTextproducerCharString(String textproducerCharString) {
		this.textproducerCharString = textproducerCharString;
	}

	public String getTextproducerCharLength() {
		return textproducerCharLength;
	}

	public void setTextproducerCharLength(String textproducerCharLength) {
		this.textproducerCharLength = textproducerCharLength;
	}

	public String getTextproducerFontNames() {
		return textproducerFontNames;
	}

	public void setTextproducerFontNames(String textproducerFontNames) {
		this.textproducerFontNames = textproducerFontNames;
	}

	public String getTextproducerFontColor() {
		return textproducerFontColor;
	}

	public void setTextproducerFontColor(String textproducerFontColor) {
		this.textproducerFontColor = textproducerFontColor;
	}

	public String getTextproducerFontSize() {
		return textproducerFontSize;
	}

	public void setTextproducerFontSize(String textproducerFontSize) {
		this.textproducerFontSize = textproducerFontSize;
	}

	public String getTextproducerCharSpace() {
		return textproducerCharSpace;
	}

	public void setTextproducerCharSpace(String textproducerCharSpace) {
		this.textproducerCharSpace = textproducerCharSpace;
	}

	public String getWordrendererImpl() {
		return wordrendererImpl;
	}

	public void setWordrendererImpl(String wordrendererImpl) {
		this.wordrendererImpl = wordrendererImpl;
	}

	public String getBackgroundImpl() {
		return backgroundImpl;
	}

	public void setBackgroundImpl(String backgroundImpl) {
		this.backgroundImpl = backgroundImpl;
	}

	public String getBackgroundClrFrom() {
		return backgroundClrFrom;
	}

	public void setBackgroundClrFrom(String backgroundClrFrom) {
		this.backgroundClrFrom = backgroundClrFrom;
	}

	public String getBackgroundClrTo() {
		return backgroundClrTo;
	}

	public void setBackgroundClrTo(String backgroundClrTo) {
		this.backgroundClrTo = backgroundClrTo;
	}

	public String getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(String imageWidth) {
		this.imageWidth = imageWidth;
	}

	public String getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(String imageHeight) {
		this.imageHeight = imageHeight;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
