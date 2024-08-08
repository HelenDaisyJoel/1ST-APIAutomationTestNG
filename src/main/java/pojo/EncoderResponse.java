package pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EncoderResponse {
	private String name;
	private String parent;
	private AuditInfo audit_info;
	private DisplayName display_name;
	private String vendor;
	private String vendor_encoder_identifier;
	private String state;
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
	public AuditInfo getAudit_info() {
        return audit_info;
    }

    public void setAudit_info(AuditInfo audit_info) {
        this.audit_info = audit_info;
    }
	public DisplayName getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(DisplayName display_name) {
		this.display_name = display_name;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getVendor_encoder_identifier() {
		return vendor_encoder_identifier;
	}
	public void setVendor_encoder_identifier(String vendor_encoder_identifier) {
		this.vendor_encoder_identifier = vendor_encoder_identifier;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
