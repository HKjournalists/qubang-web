package com.mtech.common.spring.remoting;

public class HttpInvokerProxyFactoryBean extends org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean{
	
//	@Autowired @Qualifier("uamPermissionServiceClient")
//	private UamPermissionService uamPermissionService;
//	
//	private String appName;
//	
//	public String getAppName() {
//		return appName;
//	}
//
//	public void setAppName(String appName) {
//		this.appName = appName;
//	}
//	
//	@Override
//	public void afterPropertiesSet(){
//		App app = uamPermissionService.getAppByAppName(appName);
//		String serviceUrl = super.getServiceUrl();
//		super.setServiceUrl(app.genAbsoluteUrl() + serviceUrl);
//		super.afterPropertiesSet();
//	}
}
