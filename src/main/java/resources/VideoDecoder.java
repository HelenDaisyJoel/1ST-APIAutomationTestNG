package resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.CreateDecoder;
import pojo.DisplayName;

import java.io.IOException;

public class VideoDecoder {
    public CreateDecoder CreateDecoder(String Parent, String DisplayName, String Vendor, String DecoderIdentifier, String SupportedChannelVendor,String state, String VendorChannelIdentifier, String ProjectID, String Zone, String InstanceName) throws IOException {

    	CreateDecoder cd = new CreateDecoder();
        cd.setParent(Parent);
        
        // Setting display_name with the provided value
        DisplayName name = new DisplayName();
        name.setValue(DisplayName);
        cd.setDisplay_name(name);
        
        // Setting other fields
        cd.setVendor(Vendor);
        cd.setState(state);
        cd.setVendor_decoder_identifier(DecoderIdentifier);
        cd.setSupported_channel_vendor(SupportedChannelVendor);
        cd.setVendor_channel_identifier(VendorChannelIdentifier);
        cd.setProject_id(ProjectID);
        cd.setZone(Zone);
        cd.setInstance_name(InstanceName);
        
        return cd;
    }
    
    public CreateDecoder CreateNoneDecoder(String Parent, String DisplayName, String Vendor, String DecoderIdentifier, String SupportedChannelVendor,String state) throws IOException {

    	CreateDecoder dolbyDecoder = new CreateDecoder();
    	dolbyDecoder.setParent(Parent);
        
        // Setting display_name with the provided value
        DisplayName name = new DisplayName();
        name.setValue(DisplayName);
        dolbyDecoder.setDisplay_name(name);
        
        // Setting other fields
        dolbyDecoder.setVendor(Vendor);
        dolbyDecoder.setState(state);
        dolbyDecoder.setVendor_decoder_identifier(DecoderIdentifier);
        dolbyDecoder.setSupported_channel_vendor(SupportedChannelVendor);
        return dolbyDecoder;
        
    }
    public CreateDecoder UpdateDecoder(String DisplayName, String DecoderIdentifier, String ProjectID, String Zone, String InstanceName, String VendorChannelIdentifier) throws IOException {
    	CreateDecoder ud = new CreateDecoder();
        DisplayName name = new DisplayName();
        name.setValue(DisplayName);
        ud.setDisplay_name(name);
        ud.setVendor_decoder_identifier(DecoderIdentifier);
        ud.setVendor_channel_identifier(VendorChannelIdentifier);
        ud.setState("STATE_IDLE");
        ud.setSupported_channel_vendor("VENDOR_PHENIX");
        ud.setProject_id(ProjectID);
        ud.setZone(Zone);
        ud.setInstance_name(InstanceName);
        return ud;


    }
    public CreateDecoder UpdateNoneDecoder(String DisplayName, String DecoderIdentifier) throws IOException {
    	CreateDecoder ud = new CreateDecoder();
        DisplayName name = new DisplayName();
        name.setValue(DisplayName);
        ud.setDisplay_name(name);
        ud.setVendor_decoder_identifier(DecoderIdentifier);
        
        return ud;


    }
    
}
