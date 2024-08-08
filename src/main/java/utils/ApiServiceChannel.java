package utils;

import pojo.ChannelResponse;

public class ApiServiceChannel extends BaseApiService<ChannelResponse> {
    private String createChannelEndpoint;
    private String listChannelEndpoint;
    private String ApiEndpoint;

    public ApiServiceChannel(ConfigUtility config) {
        super(config, ChannelResponse.class);
        this.createChannelEndpoint = config.getProperty("createChannelEndpoint");
        this.listChannelEndpoint = config.getProperty("listChannelEndpoint");
        this.ApiEndpoint = config.getProperty("ApiEndpoint");
        }

    public ChannelResponse createChannel(Object Channel) {
    	String endpoint=createChannelEndpoint;
    	System.out.println(endpoint);
        return create(createChannelEndpoint, Channel);
    }

    public ChannelResponse getChannel(String ChannelName) {
        return get(ApiEndpoint + ChannelName);
    }

    public ChannelResponse deleteChannel(String ChannelName) {
        return delete(ApiEndpoint + ChannelName);
    }

    public ChannelResponse listChannels() {
        return list(listChannelEndpoint);
    }

    public ChannelResponse updateChannel(String ChannelName, Object updatedChannel, String... fields) {
        String endpoint = ApiEndpoint + ChannelName;
        return update(endpoint, updatedChannel, fields);
    }
    public ChannelResponse disableChannel(String ChannelName) {
        return disable(ApiEndpoint + ChannelName + ":disable");
    }

    public ChannelResponse reenableChannel(String ChannelName) {
        return reenable(ApiEndpoint + ChannelName + ":reenable");
    }
}

