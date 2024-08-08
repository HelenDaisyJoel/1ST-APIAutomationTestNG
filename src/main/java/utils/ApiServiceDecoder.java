package utils;
import pojo.DecoderResponse;

public class ApiServiceDecoder extends BaseApiService<DecoderResponse> {
    private String createDecoderEndpoint;
    private String listDecoderEndpoint;
    private String ApiEndpoint;

    public ApiServiceDecoder(ConfigUtility config) {
        super(config, DecoderResponse.class);
        this.createDecoderEndpoint = config.getProperty("createDecoderEndpoint");
        this.listDecoderEndpoint = config.getProperty("listDecoderEndpoint");
        this.ApiEndpoint = config.getProperty("ApiEndpoint");        
    }

    public DecoderResponse createDecoder(Object decoder) {
        return create(createDecoderEndpoint, decoder);
    }

    public DecoderResponse getDecoder(String decoderName) {
        return get(ApiEndpoint + decoderName);
    }

    public DecoderResponse deleteDecoder(String decoderName) {
        return delete(ApiEndpoint + decoderName);
    }

    public DecoderResponse listDecoders() {
        return list(listDecoderEndpoint);
    }
    
    public DecoderResponse updateDecoder(String decoderName, Object updatedDecoder, String... fields) {
        String endpoint = ApiEndpoint + decoderName;
        return update(endpoint, updatedDecoder, fields);
    }
    
    public DecoderResponse disableDecoder(String decoderName) {
        return list(ApiEndpoint+ decoderName+":disable");
    }
    public DecoderResponse reenableDecoder(String decoderName) {
        return list(ApiEndpoint+ decoderName+":reenable");
    }
    
}