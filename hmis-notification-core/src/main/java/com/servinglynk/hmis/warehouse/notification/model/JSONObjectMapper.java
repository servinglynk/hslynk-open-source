package com.servinglynk.hmis.warehouse.notification.model;
import com.fasterxml.jackson.annotation.JsonInclude;import com.fasterxml.jackson.databind.DeserializationFeature;import com.fasterxml.jackson.databind.ObjectMapper;import com.fasterxml.jackson.databind.SerializationFeature;
/**
 * JSONObjectMapper enables Jaxb annotation when serializing and deserializing objects in json format
 */
@SuppressWarnings("serial")public class JSONObjectMapper extends ObjectMapper {
	public JSONObjectMapper() {//		// by default jackson write out null fields we do not want to do that//		this.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);//		AnnotationIntrospector primary = new JacksonAnnotationIntrospector();//		AnnotationIntrospector secondary = new JaxbAnnotationIntrospector();//		AnnotationIntrospector pair = new AnnotationIntrospector.Pair(primary, secondary);//		this.getDeserializationConfig().setAnnotationIntrospector(pair);//		this.getSerializationConfig().setAnnotationIntrospector(pair);		super();        this.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);        this.configure(SerializationFeature.WRAP_ROOT_VALUE, true);        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);	}
}
