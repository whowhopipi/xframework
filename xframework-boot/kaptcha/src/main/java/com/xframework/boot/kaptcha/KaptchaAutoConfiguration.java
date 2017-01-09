package com.xframework.boot.kaptcha;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.servlet.KaptchaServlet;

@Configuration
@ConditionalOnProperty(name = "kaptcha.enable", matchIfMissing = true)
@EnableConfigurationProperties(KaptchaPropertites.class)
public class KaptchaAutoConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private KaptchaPropertites propertites;

	@Bean
	public ServletRegistrationBean servletRegistrationBean() throws ServletException {
		ServletRegistrationBean servlet = new ServletRegistrationBean(new KaptchaServlet(), propertites.getUrl());

		addParam(servlet, Constants.KAPTCHA_SESSION_CONFIG_KEY, propertites.getSessionKey());
		addParam(servlet, Constants.KAPTCHA_SESSION_CONFIG_DATE, propertites.getSessionDate());
		addParam(servlet, Constants.KAPTCHA_BORDER, propertites.getBorder());
		addParam(servlet, Constants.KAPTCHA_BORDER_COLOR, propertites.getBorderColor());
		addParam(servlet, Constants.KAPTCHA_BORDER_THICKNESS, propertites.getBorderThickness());
		addParam(servlet, Constants.KAPTCHA_NOISE_COLOR, propertites.getNoiseColor());
		addParam(servlet, Constants.KAPTCHA_NOISE_IMPL, propertites.getNoiseImpl());
		addParam(servlet, Constants.KAPTCHA_OBSCURIFICATOR_IMPL, propertites.getObscurificatorImpl());
		addParam(servlet, Constants.KAPTCHA_PRODUCER_IMPL, propertites.getProducerImpl());
		addParam(servlet, Constants.KAPTCHA_TEXTPRODUCER_IMPL, propertites.getTextproducerImpl());
		addParam(servlet, Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, propertites.getTextproducerCharString());
		addParam(servlet, Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, propertites.getTextproducerCharLength());
		addParam(servlet, Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, propertites.getTextproducerFontNames());
		addParam(servlet, Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, propertites.getTextproducerFontColor());
		addParam(servlet, Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, propertites.getTextproducerFontSize());
		addParam(servlet, Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, propertites.getTextproducerCharSpace());
		addParam(servlet, Constants.KAPTCHA_WORDRENDERER_IMPL, propertites.getWordrendererImpl());
		addParam(servlet, Constants.KAPTCHA_BACKGROUND_IMPL, propertites.getBackgroundImpl());
		addParam(servlet, Constants.KAPTCHA_BACKGROUND_CLR_FROM, propertites.getBackgroundClrFrom());
		addParam(servlet, Constants.KAPTCHA_BACKGROUND_CLR_TO, propertites.getBackgroundClrTo());
		addParam(servlet, Constants.KAPTCHA_IMAGE_WIDTH, propertites.getImageWidth());
		addParam(servlet, Constants.KAPTCHA_IMAGE_HEIGHT, propertites.getImageHeight());

		return servlet;
	}

	private void addParam(ServletRegistrationBean servlet, String key, String value) {
		if (StringUtils.isEmpty(value))
			return;

		servlet.addInitParameter(key, value);
	}
}
