package utils;

import pojo.SourceResponse;

public class ApiServiceSource extends BaseApiService<SourceResponse> {
    private String createSourceEndpoint;
    private String ApiEndpoint;
    private String listSourceEndpoint;

    public ApiServiceSource(ConfigUtility config) {
        super(config, SourceResponse.class);
        this.createSourceEndpoint = config.getProperty("createSourceEndpoint");
        this.listSourceEndpoint = config.getProperty("listSourceEndpoint");
        this.ApiEndpoint = config.getProperty("ApiEndpoint");
    }

    public SourceResponse createSource(Object Source) {
        return create(createSourceEndpoint, Source);
    }

    public SourceResponse getSource(String SourceName) {
        return get(ApiEndpoint + SourceName);
    }

    public SourceResponse deleteSource(String SourceName) {
        return delete(ApiEndpoint + SourceName);
    }

    public SourceResponse listSources() {
        return list(listSourceEndpoint);
    }

    public SourceResponse updateSource(String SourceName, Object updatedSource, String... fields) {
        String endpoint = ApiEndpoint + SourceName;
        System.out.println(endpoint);
        return update(endpoint, updatedSource, fields);
    }
    public SourceResponse disableSource(String SourceName) {
        return disable(ApiEndpoint + SourceName + ":disable");
    }

    public SourceResponse reenableSource(String SourceName) {
        return reenable(ApiEndpoint + SourceName + ":reenable");
    }
}

