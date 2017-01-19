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
		
		Throwable error = getError(requestAttributes);
		if(error == null) {
			retJson.setRetcode("999");
			retJson.setMessage("出错啦！");
		} else {
			// TODO 读取配置文件，获取异常返回CODE
			retJson.setRetcode("999");
			
			// TODO 读取配置文件，获取异常返回提示信息
			retJson.setMessage(getError(requestAttributes).getMessage());
		}

		return retJson;
	}
}
