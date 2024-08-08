package utils;

import pojo.EncoderResponse;

public class ApiServiceEncoder extends BaseApiService<EncoderResponse> {
    private String createEncoderEndpoint;
    private String listEncoderEndpoint;
    private String ApiEndpoint;

    public ApiServiceEncoder(ConfigUtility config) {
        super(config, EncoderResponse.class);
        this.createEncoderEndpoint = config.getProperty("createEncoderEndpoint");
        this.listEncoderEndpoint = config.getProperty("listEncoderEndpoint");
        this.ApiEndpoint = config.getProperty("ApiEndpoint");
    }

    public EncoderResponse createEncoder(Object encoder) {
        return create(createEncoderEndpoint, encoder);
    }

    public EncoderResponse getEncoder(String encoderName) {
        return get(ApiEndpoint + encoderName);
    }

    public EncoderResponse deleteEncoder(String encoderName) {
        return delete(ApiEndpoint + encoderName);
    }

    public EncoderResponse listEncoders() {
        return list(listEncoderEndpoint);
    }

    public EncoderResponse updateEncoder(String encoderName, Object updatedEncoder, String... fields) {
        String endpoint = ApiEndpoint + encoderName;
        return update(endpoint, updatedEncoder, fields);
    }
    public EncoderResponse disableEncoder(String encoderName) {
//    	 String disableUrl = String.format("%s:disable",  encoderName);
//    	 System.out.println(disableUrl);
//        return disable(disableUrl);
    	
    	String disableUrl = String.format("%s%s:disable", ApiEndpoint, encoderName);
    	return disable(disableUrl);
//    	return disable(disableApiEndpoint + encoderName + ":disable");

    }

    public EncoderResponse reenableEncoder(String encoderName) {
        return reenable(ApiEndpoint + encoderName + ":reenable");
    }
}

