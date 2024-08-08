package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingResponse {

    private String parent;
    private String name;
    private AuditInfo audit_info;
    private DisplayName display_name;
    private String video_source_name;
    private String video_channel_name;
    private String start_time;
    private String end_time;
    private String error_message;
    private String state;
    private String decoder_name;
    private List<ForeignIdentifier> foreign_ids;
    public LocalStartDate getLocal_start_date() {
		return local_start_date;
	}

	public void setLocal_start_date(LocalStartDate local_start_date) {
		this.local_start_date = local_start_date;
	}

	private LocalStartDate local_start_date; // Changed from localStartDate

    // Getters and Setters

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getVideo_source_name() {
        return video_source_name;
    }

    public void setVideo_source_name(String video_source_name) {
        this.video_source_name = video_source_name;
    }

    public String getVideo_channel_name() {
        return video_channel_name;
    }

    public void setVideo_channel_name(String video_channel_name) {
        this.video_channel_name = video_channel_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDecoder_name() {
        return decoder_name;
    }

    public void setDecoder_name(String decoder_name) {
        this.decoder_name = decoder_name;
    }

    public List<ForeignIdentifier> getForeign_ids() {
        return foreign_ids;
    }

    public void setForeign_ids(List<ForeignIdentifier> foreign_ids) {
        this.foreign_ids = foreign_ids;
    }

    

}
