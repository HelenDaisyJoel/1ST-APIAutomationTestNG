package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DecoderResponse {
	private String name;	
	private String parent;
	private DisplayName display_name;
	private AuditInfo audit_info;    
	private String vendor;
    private String vendor_decoder_identifier;
    private String supported_channel_vendor;
    private String state;
    private String vendor_channel_identifier;
    private String project_id;
    private String zone;
    private String instance_name;
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public DisplayName getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(DisplayName display_name) {
		this.display_name = display_name;
	}
	public AuditInfo getAudit_info() {
		return audit_info;
	}
	public void setAudit_info(AuditInfo audit_info) {
		this.audit_info = audit_info;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getVendor_decoder_identifier() {
		return vendor_decoder_identifier;
	}
	public void setVendor_decoder_identifier(String vendor_decoder_identifier) {
		this.vendor_decoder_identifier = vendor_decoder_identifier;
	}
	public String getSupported_channel_vendor() {
		return supported_channel_vendor;
	}
	public void setSupported_channel_vendor(String supported_channel_vendor) {
		this.supported_channel_vendor = supported_channel_vendor;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getVendor_channel_identifier() {
		return vendor_channel_identifier;
	}
	public void setVendor_channel_identifier(String vendor_channel_identifier) {
		this.vendor_channel_identifier = vendor_channel_identifier;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getInstance_name() {
		return instance_name;
	}
	public void setInstance_name(String instance_name) {
		this.instance_name = instance_name;
	}
	
//	@JsonProperty("video_decoders")
//    private List<VideoDecoder> videoDecoders;
//
//    // Getters and setters for videoDecoders
//    public List<VideoDecoder> getVideoDecoders() {
//        return videoDecoders;
//    }
//
//    public void setVideoDecoders(List<VideoDecoder> videoDecoders) {
//        this.videoDecoders = videoDecoders;
//    }
}
