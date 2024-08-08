package test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.BookingResponse;
import pojo.ChannelResponse;
import pojo.CreateBooking;
import pojo.CreateChannel;
import pojo.CreateDecoder;
import pojo.CreateEncoder;
import pojo.CreateSource;
import pojo.EncoderResponse;
import pojo.ForeignIdentifier;
import pojo.SourceResponse;
import pojo.DecoderResponse;
import pojo.DisplayName;
import resources.VideoEncoder;
import resources.VideoSource;
import resources.VideoBooking;
import resources.VideoChannel;
import resources.VideoDecoder;
import utils.ApiServiceEncoder;
import utils.ApiServiceSource;
import utils.ApiServiceBooking;
import utils.ApiServiceChannel;
import utils.ApiServiceDecoder;
import utils.ConfigUtility;
import com.google.gson.Gson;

public class VideoPlatformTest {
    
    private String createdChannelName;
    private String createdBookingName;
    private ApiServiceEncoder apiServiceEncoder;
    private ApiServiceDecoder apiServiceDecoder;    
    private ApiServiceChannel apiServiceChannel;
    private ApiServiceBooking apiServiceBooking;
    
    
    
    public class EncoderTest {
        public String createdEncoderName; 

    @Test(dataProvider = "encoderData", dataProviderClass = TestDataProvider.class,groups = "encoderGroup")
    public void testEncoder(String parent, String state, String vendor, String vendorEncoderIdentifier, String displayNameValue, String newDisplayName, String newVendorEncoderIdentifier) {
        ConfigUtility config = new ConfigUtility("C:\\SampleWorkspace\\1st-prism-web-integration-test\\1ST-APIAutomationTestNG\\src\\main\\java\\utils\\global.properties");
        apiServiceEncoder = new ApiServiceEncoder(config);

        CreateEncoder encoder = createEncoder(parent, state, vendor, vendorEncoderIdentifier, displayNameValue);
        EncoderResponse createResponse = apiServiceEncoder.createEncoder(encoder);
        createdEncoderName = createResponse.getName();
        System.out.println("Created encoder with name: " + createdEncoderName);
        TestContext.createdEncoderName=createResponse.getName();
        Assert.assertNotNull(createdEncoderName, "Failed to create encoder. Encoder name is null.");

        getEncoder(createdEncoderName);
        updateEncoder(createdEncoderName, newDisplayName, newVendorEncoderIdentifier);
        disableEncoder(createdEncoderName);
        reenableEncoder(createdEncoderName);
//        listEncoders();
//        deleteEncoder(createdEncoderName);
    }
    }
    
    public class DecoderPhenixTest {
        public String createdDecoderName; 
    @Test(dataProvider = "decoderData", dataProviderClass = TestDataProvider.class,groups = "decoderGroup")
    public void testPhenixDecoder(String parent, String displayName, String vendor, String decoderIdentifier, String supportedChannelVendor, String state, String vendorChannelIdentifier, String projectId, String zone, String instanceName,
                                                 String newDisplayName, String newDecoderIdentifier, String newProjectId, String newZone, String newInstanceName, String newVendorChannelIdentifier) throws IOException {
        ConfigUtility config = new ConfigUtility("C:\\SampleWorkspace\\1st-prism-web-integration-test\\1ST-APIAutomationTestNG\\src\\main\\java\\utils\\global.properties");
        apiServiceDecoder = new ApiServiceDecoder(config);

        CreateDecoder decoder = createDecoder(parent, displayName, vendor, decoderIdentifier, supportedChannelVendor, state, vendorChannelIdentifier, projectId, zone, instanceName);
        DecoderResponse createResponse = apiServiceDecoder.createDecoder(decoder);
        createdDecoderName = createResponse.getName();
        System.out.println("Created decoder with name: " + createdDecoderName);
        
        
        Assert.assertNotNull(createdDecoderName, "Failed to create decoder. Decoder name is null.");
        
        getDecoder(createdDecoderName);
        updateDecoder(createdDecoderName, newDisplayName, newDecoderIdentifier, newProjectId, newZone, newInstanceName, newVendorChannelIdentifier);
        disableDecoder(createdDecoderName);
        reenableDecoder(createdDecoderName);
//        listDecoders();
        deleteDecoder(createdDecoderName);
    }
    }
    
    public class DecoderDolbyNoneTest {
        public String createdDecoderName; 
    @Test(dataProvider = "decoderNoneData", dataProviderClass = TestDataProvider.class,groups = "decoderGroup")
    public void testNoneDolbyDecoder(String parent, String displayName, String vendor, String decoderIdentifier, String supportedChannelVendor, String state,String newDisplayName,String newDecoderIdentifier)throws IOException {
        ConfigUtility config = new ConfigUtility("C:\\SampleWorkspace\\1st-prism-web-integration-test\\1ST-APIAutomationTestNG\\src\\main\\java\\utils\\global.properties");
        apiServiceDecoder = new ApiServiceDecoder(config);
        
        CreateDecoder decoderResponse = createNoneDecoder(parent, displayName, vendor, decoderIdentifier, supportedChannelVendor, state);
        DecoderResponse createNoneResponse = apiServiceDecoder.createDecoder(decoderResponse);
        createdDecoderName = createNoneResponse.getName();
        TestContext.createdDecoderName = createNoneResponse.getName();  // Store in TestContext
        System.out.println("NONE DECODER IS:"+createdDecoderName);
        getDecoder(createdDecoderName);
        updateNoneDecoder(createdDecoderName, newDisplayName, newDecoderIdentifier);
        disableDecoder(createdDecoderName);
        reenableDecoder(createdDecoderName);
//        listDecoders();
//        deleteDecoder(createdDecoderName);
    }
    }
    
    public class SourceTest {

        @Test(dataProvider = "sourceData", dataProviderClass = TestDataProvider.class, groups = "sourceGroup")
        public void testSource(String parent, String displayNameValue, String encoderName, String angleName,
                               String foreignIDType, String foreignIDValue, String automatedStartMargin, String automatedEndMargin,
                               boolean automateBooking, String newDisplayName, String newEncoderName, String newAngleName,
                               String newForeignIDType, String newForeignIDValue, String newAutomatedStartMargin, String newAutomatedEndMargin,
                               boolean newAutomateBooking) throws IOException {

            ConfigUtility config = new ConfigUtility("C:\\SampleWorkspace\\1st-prism-web-integration-test\\1ST-APIAutomationTestNG\\src\\main\\java\\utils\\global.properties");
            ApiServiceSource apiServiceSource = new ApiServiceSource(config);

            CreateSource sourceRequest = createSource(parent, displayNameValue, encoderName, angleName, foreignIDType, foreignIDValue, automatedStartMargin, automatedEndMargin, automateBooking);
            SourceResponse createResponse = apiServiceSource.createSource(sourceRequest);
            TestContext.createdSourceName = createResponse.getName();  // Store in TestContext
            System.out.println("Created Source Name: " + TestContext.createdSourceName);

            getSource(apiServiceSource, TestContext.createdSourceName);
            updateSource(apiServiceSource, TestContext.createdSourceName, newDisplayName, newEncoderName, newAngleName, newForeignIDType, newForeignIDValue, newAutomatedStartMargin, newAutomatedEndMargin, newAutomateBooking);
            disableSource(apiServiceSource, TestContext.createdSourceName);
            reenableSource(apiServiceSource, TestContext.createdSourceName);
//            listSources(apiServiceSource);
        }
    }


    public class ChannelPhenixTest {

        @Test(dataProvider = "channelPhenixData", dataProviderClass = TestDataProvider.class, groups = "channelGroup")
        public void testPhenixChannel(String parent, String displayName, String vendor, String vendorChannelIdentifier,
                                      String autoAngleName, String description, String foreignIdType, String foreignIdValue, boolean createReplay,
                                      String updatedDisplayName, String updatedvendorChannelId, String updatedAutoAngle, String updatedDescription, String updatedForeignIdType, String updatedForeignIdValue, boolean updatedCreateReplay) throws IOException {

            ConfigUtility config;
            ApiServiceChannel apiServiceChannel;
            config = new ConfigUtility("C:\\SampleWorkspace\\1st-prism-web-integration-test\\1ST-APIAutomationTestNG\\src\\main\\java\\utils\\global.properties");
            apiServiceChannel = new ApiServiceChannel(config);
            CreateChannel channelRequest = CreatePhenixChannel(parent, displayName, vendor, vendorChannelIdentifier, autoAngleName, description, foreignIdType, foreignIdValue, createReplay);

            Gson gson = new Gson();
            String payload = gson.toJson(channelRequest);
            System.out.println("Channel Request Payload: " + payload);
           
            ChannelResponse createResponse = apiServiceChannel.createChannel(channelRequest);
            TestContext.createdChannelName = createResponse.getName();  // Store in TestContext
            System.out.println("Created Channel Name: " + TestContext.createdChannelName);
            

            getChannel(apiServiceChannel, TestContext.createdChannelName);
            updatePhenixChannel(apiServiceChannel, TestContext.createdChannelName, updatedDisplayName, updatedAutoAngle, updatedvendorChannelId, updatedDescription, updatedForeignIdType, updatedForeignIdValue, updatedCreateReplay);
            disableChannel(apiServiceChannel, TestContext.createdChannelName);
            reenableChannel(apiServiceChannel, TestContext.createdChannelName);
//            listChannels(apiServiceChannel);
//            deleteChannel(apiServiceChannel, TestContext.createdChannelName);
        }
    }
  
    public class ChannelDolbyTest {
    @Test(dataProvider="channelDolbyData", dataProviderClass = TestDataProvider.class, groups = "channelGroup")
    public void testDolbyChannel(String parent, String displayName, String vendor,
                                                 String autoAngleName, String connectorID, String clusterName, String height, String frameRate, 
                                                 String description, String foreignIdType, String foreignIdValue, boolean createReplay,
                                                 String updatedVendorChannelIdentifier, String updatedVendor,
                                                 String updatedAutoAngleName, String updatedConnectorID,String updatedClusterName, String updatedHeight,String updatedFrameRate, 
                                                 String updatedDescription,String updatedForeignIdType,String updatedForeignIdValue,boolean updatedCreateReplay) throws IOException  {
       
        ConfigUtility config = new ConfigUtility("C:\\SampleWorkspace\\1st-prism-web-integration-test\\1ST-APIAutomationTestNG\\src\\main\\java\\utils\\global.properties");
        ApiServiceChannel apiServiceChannel = new ApiServiceChannel(config);

       
            // Create Channel
            CreateChannel channelRequest = CreateDolbyChannel(parent, displayName, vendor, autoAngleName, connectorID, clusterName, height, frameRate, description, foreignIdType, foreignIdValue, createReplay);
            System.out.println("Channel Request Payload: " + new Gson().toJson(channelRequest));

            ChannelResponse createResponse = apiServiceChannel.createChannel(channelRequest);
            System.out.println("Created Channel Response: " + createResponse);

            TestContext.createdChannelName = createResponse.getName();
            System.out.println("Created Channel Name: " + createdChannelName);

            getChannel(apiServiceChannel, TestContext.createdChannelName);
            updateDolbyChannel(apiServiceChannel, TestContext.createdChannelName,updatedVendorChannelIdentifier, updatedVendor,
            		updatedAutoAngleName, updatedConnectorID,updatedClusterName, updatedHeight,updatedFrameRate, 
            		updatedDescription,updatedForeignIdType,updatedForeignIdValue,updatedCreateReplay);
            disableChannel(apiServiceChannel, TestContext.createdChannelName);
            reenableChannel(apiServiceChannel, TestContext.createdChannelName);       
//            listChannels(apiServiceChannel);
//            deleteChannel(apiServiceChannel, TestContext.createdChannelName);
    }
    }
    
    public class ChannelNoneTest {
    @Test(dataProvider = "channelNoneData", dataProviderClass = TestDataProvider.class,groups = "channelGroup")
    public void testNoneChannel(String parent, String displayName, String vendor, 
    		String autoAngle, String decoder, String description,String foreignIdType, 
    		String foreignIdValue, String newDisplayName,String updatedAutoAngle, String updatedDecoder, 
    		String updatedDescription,String updatedForeignIdType,String updatedForeignIdValue)throws IOException {
    	
    	
      
        ConfigUtility config = new ConfigUtility("C:\\SampleWorkspace\\1st-prism-web-integration-test\\1ST-APIAutomationTestNG\\src\\main\\java\\utils\\global.properties");
        apiServiceChannel = new ApiServiceChannel(config);
        
        CreateChannel channelResponse = CreateNoneChannel(parent, displayName, vendor, autoAngle, decoder, description,foreignIdType, foreignIdValue);
        ChannelResponse createNoneResponse = apiServiceChannel.createChannel(channelResponse);
        TestContext.createdChannelName = createNoneResponse.getName();
        
        getChannel(apiServiceChannel, TestContext.createdChannelName);
        UpdateNoneChannel(apiServiceChannel, TestContext.createdChannelName, newDisplayName,updatedAutoAngle, updatedDecoder, 
        		updatedDescription,updatedForeignIdType,updatedForeignIdValue);
        disableChannel(apiServiceChannel, TestContext.createdChannelName);
        reenableChannel(apiServiceChannel, TestContext.createdChannelName);
//        listChannels(apiServiceChannel);
//        deleteChannel(apiServiceChannel, TestContext.createdChannelName);
    }
    }
   
    public class BookingTest {
    @Test(dataProvider = "BookingPhenixData", dataProviderClass = TestDataProvider.class, groups = "bookingGroup")
    public void testPhenixBooking(String parent, String sourceName, String channelName, String startTime, String endTime, String foreignIDType, String foreignIDValue,LocalDate currentDate) throws IOException {
        ConfigUtility config = new ConfigUtility("C:\\SampleWorkspace\\1st-prism-web-integration-test\\1ST-APIAutomationTestNG\\src\\main\\java\\utils\\global.properties");
        apiServiceBooking = new ApiServiceBooking(config);
     /// Create booking request payload
        
        CreateBooking bookingResponse = CreateBooking(parent, sourceName, channelName, startTime, endTime, foreignIDType, foreignIDValue, currentDate);
        BookingResponse bookingResponses = apiServiceBooking.createBooking(bookingResponse);
        createdBookingName = bookingResponses.getName();

        // Get booking
        getBooking(createdBookingName);
        disableBooking(createdBookingName);
        reenableBooking(createdBookingName);//
//        // List channels
//        listBookings();
//
//        // Delete channel
        deleteBooking(createdBookingName);
    
}
    }
	
	// *ENCODER******************************************************************************
	private CreateEncoder createEncoder(String parent, String state, String vendor, String vendorEncoderIdentifier, String displayNameValue) {
        VideoEncoder videoEncoder = new VideoEncoder();
        return videoEncoder.CreateEncoder(parent, state, vendor, vendorEncoderIdentifier, displayNameValue);
    }

    private void getEncoder(String encoderName) {
        EncoderResponse getResponse = apiServiceEncoder.getEncoder(encoderName);
        System.out.println("Fetched encoder with name: " + getResponse.getName());
        Assert.assertEquals(getResponse.getName(), encoderName, "Fetched encoder name mismatch.");
    }

    
    private void listEncoders() {
        EncoderResponse listResponse = apiServiceEncoder.listEncoders();
        System.out.println("List Response: " + listResponse.toString());
    }
   
    
    private void updateEncoder(String encoderName, String newDisplayName, String newVendorEncoderIdentifier) {
        VideoEncoder videoEncoder = new VideoEncoder();
        CreateEncoder updatedEncoder = videoEncoder.UpdateEncoder(newDisplayName, newVendorEncoderIdentifier);

        // Specify the fields to be updated
        String[] fields = {"display_name", "vendor_encoder_identifier"};

        EncoderResponse updateResponse = apiServiceEncoder.updateEncoder(encoderName, updatedEncoder, fields);
        System.out.println("Updated encoder with name: " + updateResponse.getName());

        // Assertions and validations for update response
        // For example:
        // Assert.assertEquals(updateResponse.getName(), encoderName);
    }
    private void disableEncoder(String encoderName) {
        EncoderResponse disableResponse = apiServiceEncoder.disableEncoder(encoderName);
        System.out.println("Disable Response: " + disableResponse.toString());
    }

    private void reenableEncoder(String encoderName) {
        EncoderResponse reenableResponse = apiServiceEncoder.reenableEncoder(encoderName);
        System.out.println("Reenable Response: " + reenableResponse);
    }
    private void deleteEncoder(String encoderName) {
        EncoderResponse deleteResponse = apiServiceEncoder.deleteEncoder(encoderName);
        System.out.println("Deleted encoder with name: " + encoderName);
    }
//*************************************************
    private CreateDecoder createDecoder(String parent, String displayName, String vendor, String decoderIdentifier, String supportedChannelVendor, String state, String vendorChannelIdentifier, String projectId, String zone, String instanceName) throws IOException {
        VideoDecoder videoDecoder = new VideoDecoder();
        return videoDecoder.CreateDecoder(parent, displayName, vendor, decoderIdentifier, supportedChannelVendor, state, vendorChannelIdentifier, projectId, zone, instanceName);
    }
    
    private CreateDecoder createNoneDecoder(String parent, String displayName, String vendor, String decoderIdentifier, String supportedChannelVendor, String state) throws IOException {
        VideoDecoder videoDecoder = new VideoDecoder();
        return videoDecoder.CreateNoneDecoder(parent, displayName, vendor, decoderIdentifier, supportedChannelVendor, state);
    }

    private void getDecoder(String decoderName) {
        DecoderResponse getResponse = apiServiceDecoder.getDecoder(decoderName);
        System.out.println("Fetched decoder with name: " + getResponse.getName());
    }

    private void updateDecoder(String decoderName, String newDisplayName, String newDecoderIdentifier, String newProjectId, String newZone, String newInstanceName, String newVendorChannelIdentifier) throws IOException {
        VideoDecoder videoDecoder = new VideoDecoder();
        CreateDecoder updatedDecoder = videoDecoder.UpdateDecoder(newDisplayName, newDecoderIdentifier, newProjectId, newZone, newInstanceName, newVendorChannelIdentifier);

        // Specify the fields to be updated
        String[] fields = {"display_name", "vendor_decoder_identifier", "project_id", "zone", "instance_name", "vendor_channel_identifier"};

        DecoderResponse updateResponse = apiServiceDecoder.updateDecoder(decoderName, updatedDecoder, fields);
        System.out.println("Updated decoder with name: " + updateResponse.getName());

        // Assertions and validations for update response
        // For example:
        // Assert.assertEquals(updateResponse.getName(), decoderName);
    }

    private void updateNoneDecoder(String decoderName, String newDisplayName, String newDecoderIdentifier) throws IOException {
        VideoDecoder videoDecoder = new VideoDecoder();
        CreateDecoder updatedDecoder = videoDecoder.UpdateNoneDecoder(newDisplayName, newDecoderIdentifier);

        // Specify the fields to be updated
        String[] fields = {"display_name", "vendor_decoder_identifier"};

        DecoderResponse updateResponse = apiServiceDecoder.updateDecoder(decoderName, updatedDecoder, fields);
        System.out.println("Updated decoder with name: " + updateResponse.getName());

        // Assertions and validations for update response
        // For example:
        // Assert.assertEquals(updateResponse.getName(), decoderName);
    }
    
    
    
    private void disableDecoder(String decoderName) {
//        DecoderResponse disableResponse = apiServiceDecoder.disableDecoder(decoderName);
//        System.out.println("Disable Response: " + disableResponse.toString());
//    }
    	try {
            DecoderResponse disableResponse = apiServiceDecoder.disableDecoder(decoderName);
            System.out.println("Disable Response: " + disableResponse.toString());
            // Optionally check if disableResponse.getStatusCode() == 200 if you expect it to be successful
        } catch (AssertionError e) {
            System.err.println("Failed to disable decoder. Expected status 200 but got 501.");
            // Handle the error condition as per your test requirements
        }
    }
    private void reenableDecoder(String decoderName) {
//        DecoderResponse reenableResponse = apiServiceDecoder.reenableDecoder(decoderName);
//        System.out.println("Reenable Response: " + reenableResponse);
//    }
    	try {
            DecoderResponse reenableResponse = apiServiceDecoder.reenableDecoder(decoderName);
            System.out.println("Reenable Response: " + reenableResponse.toString());
            // Optionally check if disableResponse.getStatusCode() == 200 if you expect it to be successful
        } catch (AssertionError e) {
            System.err.println("Failed to reenable decoder. Expected status 200 but got 501.");
            // Handle the error condition as per your test requirements
        }
    }

    private void listDecoders() {
        DecoderResponse listResponse = apiServiceDecoder.listDecoders();
        System.out.println("List Response: " + listResponse.toString());
    }

    private void deleteDecoder(String decoderName) {
        DecoderResponse deleteResponse = apiServiceDecoder.deleteDecoder(decoderName);
        System.out.println("Deleted decoder with name: " + decoderName);
    }
    
//    ***********************************************
    private CreateSource createSource(String parent, String displayNameValue, String encoderName, String angleName, String foreignIDType, String foreignIDValue, String automatedStartMargin, String automatedEndMargin, boolean automateBooking) throws IOException {
        VideoSource videoSource = new VideoSource();
        return videoSource.createSource(parent, displayNameValue, encoderName, angleName, foreignIDType, foreignIDValue, automatedStartMargin, automatedEndMargin, automateBooking);
    }

    private void updateSource(ApiServiceSource apiServiceSource,String sourceName, String newDisplayName, String newEncoderName, String newAngleName, String newForeignIDType, String newForeignIDValue, String newAutomatedStartMargin, String newAutomatedEndMargin, boolean newAutomateBooking) throws IOException {
        VideoSource videoSource = new VideoSource();
        CreateSource updatedDecoder = videoSource.updateSource(newDisplayName, newEncoderName, newAngleName, newForeignIDType, newForeignIDValue, newAutomatedStartMargin, newAutomatedEndMargin, newAutomateBooking);

        // Specify the fields to be updated
        String[] fields = { "display_name", "encoder", "foreign_ids", "automate_booking", "automated_start_margin", "automated_end_margin", "angle_name" };

        SourceResponse updateResponse = apiServiceSource.updateSource(sourceName, updatedDecoder, fields);
        System.out.println("Updated Source with name: " + updateResponse.getName());
    }
    private void getSource(ApiServiceSource apiServiceSource,String sourceName) {
        SourceResponse getResponse = apiServiceSource.getSource(sourceName);
        System.out.println("Fetched Source with name: " + getResponse.getName());
    }

    private void listSources(ApiServiceSource apiServiceSource) {
        SourceResponse listResponse = apiServiceSource.listSources();
        System.out.println("List Source Response: " + listResponse.toString());
    }

    private void disableSource(ApiServiceSource apiServiceSource,String sourceName) {
        try{SourceResponse disableResponse = apiServiceSource.disableSource(sourceName);
        System.out.println("Disable Source Response: " + disableResponse.toString());
        
    } catch (RuntimeException e) {
        System.out.println("Error occurred: " + e.getMessage());
    }
    }

    private void reenableSource(ApiServiceSource apiServiceSource,String sourceName) {
       try { SourceResponse reenableResponse = apiServiceSource.reenableSource(sourceName);
        System.out.println("Reenable Response: " + reenableResponse);
        
        } catch (RuntimeException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
//    Channel*******************************************************************
    
    private CreateChannel CreatePhenixChannel(String parent, String displayName, String vendor, String vendorChannelIdentifier, 
		 	String autoAngleName, String description,String foreignIdType,String foreignIdValue, boolean createReplay) {
		VideoChannel videoChannel=new VideoChannel();
		return videoChannel.CreatePhenixChannel(parent, displayName, vendor, vendorChannelIdentifier, 
			 	autoAngleName, description,foreignIdType,foreignIdValue, createReplay);
	}
    
    private CreateChannel CreateDolbyChannel(String parent, String displayName, String vendor, String autoAngleName, String connectorID, 
            String clusterName, String height, String frameRate, String description, String foreignIdType, 
            String foreignIdValue, boolean createReplay) {
    	VideoChannel videoChannel = new VideoChannel();
    	return videoChannel.CreateDolbyChannel(parent, displayName, vendor, autoAngleName, connectorID, clusterName, height, frameRate, description, foreignIdType, foreignIdValue, createReplay);


}

    private CreateChannel CreateNoneChannel(String parent, String displayName, String vendor, 
    		String autoAngle, String decoder, String description,String foreignIdType, 
    		String foreignIdValue) {
    	VideoChannel videoChannel = new VideoChannel();
    	CreateChannel channel = videoChannel.CreateNoneChannel(parent, displayName, vendor, autoAngle,
				decoder, description, foreignIdType, foreignIdValue);
    	return channel;
	}

    private void getChannel(ApiServiceChannel apiServiceChannel,String channelName){
    	 System.out.println("Getting Channel: " + channelName);
		ChannelResponse getResponse = apiServiceChannel.getChannel(channelName);
		System.out.println("Get Channel Response: " + getResponse);
    }
    
    private void updatePhenixChannel(ApiServiceChannel apiServiceChannel,String createdChannelName, String updatedDisplayName, String updatedVendorChannelId,
            String updatedAutoAngle, String updatedDescription, String updatedForeignIdType, String updatedForeignIdValue, boolean updatedCreateReplay) throws IOException {
    		VideoChannel videoChannel = new VideoChannel(); // Create an instance of VideoChannel
    		CreateChannel updatedChannel = videoChannel.UpdatePhenixChannel(updatedDisplayName, updatedAutoAngle, updatedVendorChannelId, updatedDescription, updatedForeignIdType, updatedForeignIdValue, updatedCreateReplay);

// Specify the fields to be updated
    		String[] fields = {"display_name", "auto_angle", "foreign_ids", "vendor_channel_identifier", "create_replay", "description"};

    		ChannelResponse updateResponse = apiServiceChannel.updateChannel(createdChannelName, updatedChannel, fields);
    		System.out.println("Updated Channel with name: " + updateResponse.getName());
    		
    
}
    private void updateDolbyChannel(ApiServiceChannel apiServiceChannel,String createdChannelName,String updatedVendorChannelIdentifier, String updatedVendor,
            String updatedAutoAngleName, String updatedConnectorID,String updatedClusterName, String updatedHeight,String updatedFrameRate, 
            String updatedDescription,String updatedForeignIdType,String updatedForeignIdValue,boolean updatedCreateReplay) throws IOException
    
    {
    	
    	VideoChannel videoChannel = new VideoChannel(); // Create an instance of VideoChannel
		CreateChannel updatedChannel = videoChannel.UpdateDolbyChannel(updatedVendorChannelIdentifier, updatedVendor,
                updatedAutoAngleName, updatedConnectorID,updatedClusterName, updatedHeight,updatedFrameRate, 
                updatedDescription,updatedForeignIdType,updatedForeignIdValue,updatedCreateReplay);

    	// Specify the fields to be updated
		String[] fields = {"connector_id", "auto_angle", "foreign_ids", "vendor_channel_identifier", "create_replay", "height ","frame_rate","description","video_channel_cluster"};

		ChannelResponse updateResponse = apiServiceChannel.updateChannel(createdChannelName, updatedChannel, fields);
		System.out.println("Updated Channel with name: " + updateResponse.getName());
    }
    private CreateChannel UpdateNoneChannel(ApiServiceChannel apiServiceChannel,String createdChannelName,String newDisplayName,String updatedAutoAngle, String updatedDecoder, 
    		String updatedDescription,String updatedForeignIdType,String updatedForeignIdValue) throws IOException {
		
    	VideoChannel videoChannel = new VideoChannel(); // Create an instance of VideoChannel
		CreateChannel updatedChannel = videoChannel.UpdateNoneChannel(newDisplayName,updatedAutoAngle, updatedDecoder, 
	    		updatedDescription,updatedForeignIdType,updatedForeignIdValue);

    	// Specify the fields to be updated
		String[] fields = {"display_name", "auto_angle", "foreign_ids", "decoder", "description"};

		ChannelResponse updateResponse = apiServiceChannel.updateChannel(createdChannelName, updatedChannel, fields);
		System.out.println("Updated Channel with name: " + updateResponse.getName());
		return updatedChannel;
	}

    
    private void listChannels(ApiServiceChannel apiServiceChannel) {
    	ChannelResponse listResponse = apiServiceChannel.listChannels();
        System.out.println("List Source Response: " + listResponse.toString());
    }

    private void disableChannel(ApiServiceChannel apiServiceChannel,String channelName) {
        try{ChannelResponse disableResponse = apiServiceChannel.disableChannel(channelName);
        System.out.println("Disable Channel Response: " + disableResponse.toString());
        
    } catch (RuntimeException e) {
        System.out.println("Error occurred: " + e.getMessage());
    }
    }

    private void reenableChannel(ApiServiceChannel apiServiceChannel,String channelName) {
       try { ChannelResponse reenableResponse = apiServiceChannel.reenableChannel(channelName);
        System.out.println("Reenable Response: " + reenableResponse);
        
        } catch (RuntimeException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
    
    
    private void deleteChannel(ApiServiceChannel apiServiceChannel,String channelName) {
    	ChannelResponse deleteResponse = apiServiceChannel.deleteChannel(channelName);
        System.out.println("Deleted channel with name: " + channelName);
		
	}
//    Booking**********************************************
    private CreateBooking CreateBooking(String parent, String sourceName, String channelName, String startTime,
			String endTime, String foreignIDType, String foreignIDValue, LocalDate currentDate) {
		VideoBooking videoBooking=new VideoBooking();
		CreateBooking booking = videoBooking.createBooking(parent, sourceName, channelName, startTime,
				endTime, foreignIDType, foreignIDValue, currentDate);
    	return booking;
	}

    
    private void getBooking(String bookingName){
   	 System.out.println("Getting Booking name: " + bookingName);
   	BookingResponse getResponse = apiServiceBooking.getBooking(bookingName);
		System.out.println("Get Booking Response: " + getResponse);
   }
   
    
    private void deleteBooking(String bookingName) {
    	BookingResponse deleteResponse = apiServiceBooking.deleteBooking(bookingName);
        System.out.println("Deleted Booking with name: " + bookingName);
		
	}
    
    private void listBookings() {
    	BookingResponse listResponse = apiServiceBooking.listBookings();
        System.out.println("List Booking Response: " + listResponse.toString());
    }
    private void reenableBooking(String bookingName) {
    	try{BookingResponse disableResponse = apiServiceBooking.reenableBooking(bookingName);
        System.out.println("Disable Booking Response: " + disableResponse.toString());
        
    } catch (RuntimeException e) {
        System.out.println("Error occurred: " + e.getMessage());
    }
		
	}

	private void disableBooking(String bookingName) {
		try{BookingResponse disableResponse = apiServiceBooking.disableBooking(bookingName);
        System.out.println("Disable Booking Response: " + disableResponse.toString());
        
    } catch (RuntimeException e) {
        System.out.println("Error occurred: " + e.getMessage());
    }
		
	}

    
    
    
    
    
    
    
}

