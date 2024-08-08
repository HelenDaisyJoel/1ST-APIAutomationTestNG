package resources;

import pojo.CreateEncoder;
import pojo.DisplayName;

public class VideoEncoder {
    public CreateEncoder CreateEncoder(String parent, String state, String vendor, String vendorEncoderIdentifier, String displayNameValue) {
        CreateEncoder encoder = new CreateEncoder();
        encoder.setParent(parent);
        encoder.setState(state);
        encoder.setVendor(vendor);
        encoder.setVendor_encoder_identifier(vendorEncoderIdentifier);

        DisplayName displayName = new DisplayName();
        displayName.setValue(displayNameValue);
        encoder.setDisplay_name(displayName);
        
        return encoder;
    }
    
    public CreateEncoder UpdateEncoder(String newDisplayName, String newVendorEncoderIdentifier) {
        CreateEncoder updatedEncoder = new CreateEncoder();
        
        // Set Display Name
        DisplayName updatedDisplayName = new DisplayName();
        updatedDisplayName.setValue(newDisplayName);
        updatedEncoder.setDisplay_name(updatedDisplayName);
        
        // Set Vendor Encoder Identifier
        updatedEncoder.setVendor_encoder_identifier(newVendorEncoderIdentifier);
        
        return updatedEncoder;
    }

}
