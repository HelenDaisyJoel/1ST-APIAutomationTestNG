package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelResponse {
    private String name;
    private String parent;
    private AuditInfo audit_info;
    private DisplayName display_name;
    private String vendor;
    private String vendor_channel_identifier;
    private String connector_id;
    private String state;
    private List<ForeignIdentifier> foreign_ids;
    
    private String auto_angle_name;
    private String description;
    private String decoder_name;
    private String create_replay;
    private String cluster_name;
    private String height;
    private String frame_rate;
    private String transcoder_id;
    private String transcoder_d_n_s;
    private String vendor_token_id;

    // Getters and Setters for all fields

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

    public String getVendor_channel_identifier() {
        return vendor_channel_identifier;
    }

    public void setVendor_channel_identifier(String vendor_channel_identifier) {
        this.vendor_channel_identifier = vendor_channel_identifier;
    }

    public String getConnector_id() {
        return connector_id;
    }

    public void setConnector_id(String connector_id) {
        this.connector_id = connector_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<ForeignIdentifier> getForeign_ids() {
        return foreign_ids;
    }

    public void setForeign_ids(List<ForeignIdentifier> foreign_ids) {
        this.foreign_ids = foreign_ids;
    }

    public String getAuto_angle_name() {
        return auto_angle_name;
    }

    public void setAuto_angle_name(String auto_angle_name) {
        this.auto_angle_name = auto_angle_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDecoder_name() {
        return decoder_name;
    }

    public void setDecoder_name(String decoder_name) {
        this.decoder_name = decoder_name;
    }

    public String getCreate_replay() {
        return create_replay;
    }

    public void setCreate_replay(String create_replay) {
        this.create_replay = create_replay;
    }

    public String getCluster_name() {
        return cluster_name;
    }

    public void setCluster_name(String cluster_name) {
        this.cluster_name = cluster_name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getFrame_rate() {
        return frame_rate;
    }

    public void setFrame_rate(String frame_rate) {
        this.frame_rate = frame_rate;
    }

    public String getTranscoder_id() {
        return transcoder_id;
    }

    public void setTranscoder_id(String transcoder_id) {
        this.transcoder_id = transcoder_id;
    }

    public String getTranscoder_d_n_s() {
        return transcoder_d_n_s;
    }

    public void setTranscoder_d_n_s(String transcoder_d_n_s) {
        this.transcoder_d_n_s = transcoder_d_n_s;
    }

    public String getVendor_token_id() {
        return vendor_token_id;
    }

    public void setVendor_token_id(String vendor_token_id) {
        this.vendor_token_id = vendor_token_id;
    }
}
