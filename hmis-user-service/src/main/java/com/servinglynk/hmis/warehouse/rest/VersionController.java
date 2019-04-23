package com.servinglynk.hmis.warehouse.rest;

import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;




@Controller
@RequestMapping(value = "/version", produces = MediaType.APPLICATION_JSON_VALUE)
  public class VersionController {

@Autowired
ApplicationContext applicationContext;

@RequestMapping(method = RequestMethod.GET)
@ResponseBody
public JSONObject getVersion() {
JSONObject result = new JSONObject();
Resource resource = applicationContext.getResource("/META-INF/MANIFEST.MF");

try {
 Manifest manifest = new Manifest(resource.getInputStream());
 if (manifest != null){
  Attributes mainAttributes = manifest.getMainAttributes();
  if(mainAttributes != null){
   for (Object key : mainAttributes.keySet()) {
    try {
		result.put((String) key, mainAttributes.get(key));
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
  }
 }
} catch (IOException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
}
   return result;

}
}
