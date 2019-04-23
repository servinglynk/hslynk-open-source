package com.servinglynk.hmis.warehouse.rest;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazonaws.util.json.JSONObject;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;




@Controller
@RequestMapping("/version")
  public class VersionController extends ControllerBase  {

@Autowired
ApplicationContext applicationContext;

@RequestMapping(method = RequestMethod.GET)
@APIMapping(value="AUTH_AUTHORIZE",checkSessionToken=false, checkTrustedApp=false)
@ResponseBody
public String getVersion() {
	String result = "";
Resource resource = applicationContext.getResource("/WEB-INF/classes/build.properties");

try {
InputStream inputStream = resource.getInputStream();
result = IOUtils.toString(inputStream,"UTF8"
		+ ""); 
} catch (IOException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
}
   return result;

}
}
