package resources;
import java.util.ArrayList;
import java.util.List;
import pojo.CreateSource;
import pojo.DisplayName;
import pojo.ForeignIdentifier;

public class VideoSource {
	
	

	    public CreateSource createSource(String parent, String displayNameValue, String encoderName, String angleName, String foreignIDType, String foreignIDValue, String automatedStartMargin, String automatedEndMargin, boolean automateBooking) {
	        CreateSource createSource = new CreateSource();
	        createSource.setParent(parent);

	        DisplayName displayName = new DisplayName();
	        displayName.setValue(displayNameValue);
	        createSource.setDisplay_name(displayName);

	        createSource.setEncoder_name(encoderName);
	        createSource.setAngle_name(angleName);
	        createSource.setAutomated_start_margin(automatedStartMargin);
	        createSource.setAutomated_end_margin(automatedEndMargin);
	        createSource.setAutomate_booking(automateBooking);

	        ForeignIdentifier foreignIdentifier = new ForeignIdentifier();
	        foreignIdentifier.setType(foreignIDType);
	        List<String> foreignIDValues = new ArrayList<>();
	        foreignIDValues.add(foreignIDValue);
	        foreignIDValues.add("123");
	        foreignIdentifier.setValues(foreignIDValues);
	        
//	        ForeignIdentifier foreignIdentifier1 = new ForeignIdentifier();
//	        foreignIdentifier.setType("EquibaseTrackCode");
//	        List<String> foreignIDValues1 = new ArrayList<>();
//	        foreignIDValues1.add("567");
//	        foreignIDValues1.add("789");
//	        foreignIdentifier.setValues(foreignIDValues1);

	        List<ForeignIdentifier> foreignIdentifiers = new ArrayList<>();
	        foreignIdentifiers.add(foreignIdentifier);
//	        foreignIdentifiers.add(foreignIdentifier1);
	        createSource.setForeign_ids(foreignIdentifiers);

	        return createSource;
	    }
	

	public CreateSource updateSource(String newDisplayName, String newEncoderName, String newAngleName, String newForeignIDType, String newForeignIDValue, String newAutomatedStartMargin, String newAutomatedEndMargin, boolean newAutomateBooking) {
        CreateSource updatedSource = new CreateSource();
        DisplayName name=new DisplayName();
        name.setValue(newDisplayName);
        updatedSource.setDisplay_name(name);
        updatedSource.setAngle_name(newAngleName);
        updatedSource.setAutomate_booking(newAutomateBooking);
        updatedSource.setAutomated_end_margin(newAutomatedEndMargin);
        updatedSource.setAutomated_start_margin(newAutomatedStartMargin);
        updatedSource.setEncoder_name(newEncoderName);
        
        ForeignIdentifier foreignIdentifier = new ForeignIdentifier();
        foreignIdentifier.setType(newForeignIDType);
        List<String> foreignIDValues = new ArrayList<>();
        foreignIDValues.add(newForeignIDValue);
        foreignIDValues.add("123");
        foreignIdentifier.setValues(foreignIDValues);
        
        
        return updatedSource;
    }

}
