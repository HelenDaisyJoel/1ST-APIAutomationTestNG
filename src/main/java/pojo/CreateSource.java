package pojo;

import java.util.List;

public class CreateSource {
	private String parent;
	private DisplayName display_name;
	private String angle_name;
	private String encoder_name;	
	private List<ForeignIdentifier> foreign_ids;	
	private String state;
	private String automated_start_margin;
	private String automated_end_margin;
	private boolean automate_booking;
	
	
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
	public String getAngle_name() {
		return angle_name;
	}
	public void setAngle_name(String angle_name) {
		this.angle_name = angle_name;
	}
	public String getEncoder_name() {
		return encoder_name;
	}
	public void setEncoder_name(String encoder_name) {
		this.encoder_name = encoder_name;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAutomated_start_margin() {
		return automated_start_margin;
	}
	public void setAutomated_start_margin(String automated_start_margin) {
		this.automated_start_margin = automated_start_margin;
	}
	public String getAutomated_end_margin() {
		return automated_end_margin;
	}
	public void setAutomated_end_margin(String automated_end_margin) {
		this.automated_end_margin = automated_end_margin;
	}
	
	public void setAutomate_booking(boolean automate_booking) {
		this.automate_booking = automate_booking;
	}
	public List<ForeignIdentifier> getForeign_ids() {
		return foreign_ids;
	}
	public void setForeign_ids(List<ForeignIdentifier> foreign_ids) {
		this.foreign_ids = foreign_ids;
	}
	
	

}
