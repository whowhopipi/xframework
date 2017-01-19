package com.xframework.boot.exception.attr;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import com.xframework.boot.web.vo.JsonDataVo;

@Component
public class XframeworkErrorAttributes extends DefaultErrorAttributes {

	@Value("${xframework.error.showTrace:false}")
	private boolean showTrace = true;
	
	@Override
	public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
		Map<String, Object> body = super.getErrorAttributes(requestAttributes, includeStackTrace);
		
		JsonDataVo<Map<String, Object>> retJson = new JsonDataVo<>();
		retJson.setData(body);
		
		retJson.put("showTrace", showTrace);
		
		retJson.setSuccess(false);
		retJson.setRetcode("");

		return retJson;
	}
}
