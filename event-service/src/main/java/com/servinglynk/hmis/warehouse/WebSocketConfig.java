package com.servinglynk.hmis.warehouse;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@Configuration
public class WebSocketConfig  
implements WebSocketMessageBrokerConfigurer {


	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> arg0) {
	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> arg0) {
	}

	@Override
	public void configureClientInboundChannel(ChannelRegistration arg0) {
	}

	@Override
	public void configureClientOutboundChannel(ChannelRegistration arg0) {
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
	    config.enableSimpleBroker("/clients");
	    config.setApplicationDestinationPrefixes("/app");
		
	}

	@Override
	public boolean configureMessageConverters(List<MessageConverter> arg0) {
		return false;
	}

	@Override
	public void configureWebSocketTransport(WebSocketTransportRegistration arg0) {
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
	    registry.addEndpoint("/events-socket").setAllowedOrigins("*").withSockJS();		
	}

}
