package test;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
//import java.util.Arrays;
//import java.util.Locale;
import java.util.UUID;

import org.testng.annotations.DataProvider;
//import test.VideoPlatformTest.ChannelTest;
//import test.VideoPlatformTest.SourceTest;
//import test.VideoPlatformTest.TestContext;




public class TestDataProvider {

    @DataProvider(name = "encoderData")
    public static Object[][] encoderDataProvider() {
    	String randomEncoderName="Encoder-"+UUID.randomUUID().toString().substring(0, 4);
    	String randomEncoderID="Encoder-"+UUID.randomUUID().toString().substring(0, 4);
    	String randomUpdatedEncoderName="EncoderUpdate-"+UUID.randomUUID().toString().substring(0, 4);
        return new Object[][] {
            {"org/test123/orgUnits/test1234", "STATE_UNSPECIFIED", "VENDOR_LTN", randomEncoderName, randomEncoderID,randomUpdatedEncoderName, "newVendorEncoderId21"}
            // Add more data sets if needed
        };
    }

    @DataProvider(name = "decoderData")
    public static Object[][] decoderDataProvider() {
    	String randomDecoderName = "DecoderPhenix-" + UUID.randomUUID().toString().substring(0, 4);
    	String randomDecoderID = "DecoderIDNone-" + UUID.randomUUID().toString().substring(0, 4);
    	String randomVendorChannelID="ChannelIDNone-" + UUID.randomUUID().toString().substring(0, 4);
    	String randomUpdatedDecoder = "DecoderPhenixUpdate-" + UUID.randomUUID().toString().substring(0, 4);
    	String randomUpdatedDecoderID = "DecoderIDNoneUpdate-" + UUID.randomUUID().toString().substring(0, 4);
        return new Object[][]{
        		
        
            {"org/test123/orgUnits/test1234", randomDecoderName, "VENDOR_LTN", randomDecoderID, "VENDOR_PHENIX", "STATE_UNSPECIFIED", 
            	randomVendorChannelID, "ProjectID", "Zone", "InstanceName", randomUpdatedDecoder, randomUpdatedDecoderID, 
             "NewProjectID", "NewZone", "NewInstanceName", "NewVendorChannelIdentifier"},
     	
        };
    }
	
	@DataProvider(name = "decoderNoneData")
    public Object[][] decoderNoneDataProvider() {
		String randomDecoderName = "DecoderNone-" + UUID.randomUUID().toString().substring(0, 4);
		String randomDecoderID = "DecoderIDNone-" + UUID.randomUUID().toString().substring(0, 4);
        return new Object[][] {
            { "org/test123/orgUnits/test1234", randomDecoderName, "VENDOR_LTN", randomDecoderID, "VENDOR_NONE", "STATE_UNSPECIFIED", "NewDisplayName", "NewDecoderIdentifier" },
        
        };
    }
	@DataProvider(name = "decoderDolbyData")
    public Object[][] decoderDolbyDataProvider() {
		String randomDecoderName = "DecoderNone-" + UUID.randomUUID().toString().substring(0, 4);
		String randomDecoderID = "DecoderIDNone-" + UUID.randomUUID().toString().substring(0, 4);
        return new Object[][] {
           
            { "org/test123/orgUnits/test1234", randomDecoderName, "VENDOR_LTN", randomDecoderID, "VENDOR_DOLBY", "STATE_UNSPECIFIED", "UpdatedDolbyDisplayName", "UpdatedDolbyDecoderIdentifier" }
        
        };
    }
	
	@DataProvider(name = "sourceData")
	public static Object[][] sourceDataProvider() {
	    String randomSourceName = "SourceDisplayName-" + UUID.randomUUID().toString().substring(0, 4);
	    String randomUpdatedSourceName = "SourceUpdate-" + UUID.randomUUID().toString().substring(0, 4);
	    
	    String EncoderName=TestContext.createdEncoderName;
	    return new Object[][] {
	        { "org/test123/orgUnits/test1234", randomSourceName, EncoderName, "platforms/video/cameraAngles/jockey_cam_10", "CHRIMSEventCode", "1290mn", "10s", "10s", true, randomUpdatedSourceName, "org/test123/videoEncoders/01900d57-deea-7485-b0ce-1b8a77998dc2", "platforms/video/cameraAngles/jockey_cam_10", "CHRIMSEventCode", "update", "100s", "100s", false},
	        { "org/test123/orgUnits/test1234", randomSourceName, EncoderName, "platforms/video/cameraAngles/jockey_cam_10", "CHRIMSEventCode", "1290mn", "10s", "10s", true, randomUpdatedSourceName, "org/test123/videoEncoders/01900d57-deea-7485-b0ce-1b8a77998dc2", "platforms/video/cameraAngles/jockey_cam_10", "CHRIMSEventCode", "update", "100s", "100s", false},
	    };
	}
	
	@DataProvider(name = "channelPhenixData")
	public static Object[][] channelPhenixDataProvider() {
	String randomChannelName = "Channel-" + UUID.randomUUID().toString().substring(0, 4);
	String randomChannelID = "ChannelID-" + UUID.randomUUID().toString().substring(0, 4);
	String randomUpdatedChannelName = "ChannelUpdate-" + UUID.randomUUID().toString().substring(0, 4);
    return new Object[][] {
        { "org/test123/orgUnits/test1234", randomChannelName,"VENDOR_PHENIX", randomChannelID, "platforms/video/cameraAngles/jockey_cam_10", "description", "CHRIMSEventCode", "1290mn", true, randomUpdatedChannelName,"vendorChannelId", "platforms/video/cameraAngles/jockey_cam_10", "updateddescription", "CHRIMSEventCode", "test", false},
    };
	}

	 @DataProvider(name = "channelDolbyData")
	    public static Object[][] channelDolbyDataProvider() {
		String randomChannelName = "ChannelDolby-" + UUID.randomUUID().toString().substring(0, 4);
//		String randomUpdatedChannelName = "ChannelUpdate-" + UUID.randomUUID().toString();
	        return new Object[][] {
	            { "org/test123/orgUnits/test1234", randomChannelName, "VENDOR_DOLBY", "platforms/video/cameraAngles/jockey_cam_10", "123", "platforms/video/videoChannelClusters/018e5dcb-8187-7037-883a-c26bb9b57468", "_720p", "_60f", "description", "CHRIMSEventCode", "1290mn", true, "channelid", "VENDOR_DOLBY", "platforms/video/cameraAngles/jockey_cam_10", "12345", "platforms/video/videoChannelClusters/018e5dcb-8187-7037-883a-c26bb9b57468", "_720p", "_120f", "updateddescription", "CHRIMSEventCode", "34update", true }
	        };
	    }
	
    @DataProvider(name = "channelNoneData")
	public static Object[][] channelNoneDataProvider() {
    	String randomUpdatedChannelName = "ChannelUpdate-" + UUID.randomUUID().toString().substring(0, 4);
    	String NoneDecoderName = TestContext.createdDecoderName;
    return new Object[][] {
        { "org/test123/orgUnits/test1234", "NoneChannel", "VENDOR_NONE",  "platforms/video/cameraAngles/jockey_cam_10", NoneDecoderName, "description", "CHRIMSEventCode", "1290mn", randomUpdatedChannelName, "platforms/video/cameraAngles/jockey_cam_10","org/test123/videoDecoders/0190179e-7c8b-706e-bdbe-ebc0960e8b74", "updateddescription","CHRIMSEventCode", "update"},
    };
}   
    
    @DataProvider(name="BookingPhenixData")
    public static Object[][] BookingPhenixDataProvider() {
        // Generate current UTC time plus one hour as a formatted string
        Instant currentTimePlusOneHour = Instant.now().plus(1, ChronoUnit.HOURS);
        String startTime = DateTimeFormatter.ISO_INSTANT.format(currentTimePlusOneHour);
        // Calculate end time as start time plus one hour
        Instant endTimeInstant = currentTimePlusOneHour.plus(1, ChronoUnit.HOURS);
        String endTime = DateTimeFormatter.ISO_INSTANT.format(endTimeInstant);
        // Get current date in UTC
        Instant currentInstant = Instant.now();
        LocalDate currentDate = LocalDate.ofInstant(currentInstant, ZoneId.of("UTC"));
        String sourceName = TestContext.createdSourceName;
        String channelPhenixName = TestContext.createdChannelName;

        return new Object[][] {
            { "org/test123/orgUnits/test1234", sourceName, channelPhenixName, startTime, endTime, "CHRIMSEventCode", "1290mn", currentDate },
        };}



}

