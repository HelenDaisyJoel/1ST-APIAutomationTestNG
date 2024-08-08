package resources;

import pojo.CreateBooking;
import pojo.ForeignIdentifier;
import pojo.LocalStartDate; // Import LocalStartDate

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VideoBooking {

    public CreateBooking createBooking(String Parent, String SourceName, String ChannelName, String StartTime,
                                       String EndTime, String foreignIDType, String foreignIDValue,
                                       LocalDate currentDate) {
        CreateBooking createBooking = new CreateBooking();
        createBooking.setParent(Parent);
        createBooking.setVideo_source_name(SourceName);
        createBooking.setVideo_channel_name(ChannelName);
        createBooking.setStart_time(StartTime);
        createBooking.setEnd_time(EndTime);

        ForeignIdentifier foreignIdentifier = new ForeignIdentifier();
        foreignIdentifier.setType(foreignIDType);
        List<String> foreignIDValues = new ArrayList<>();
        foreignIDValues.add(foreignIDValue);
        foreignIdentifier.setValues(foreignIDValues);

        List<ForeignIdentifier> foreignIdentifiers = new ArrayList<>();
        foreignIdentifiers.add(foreignIdentifier);
        createBooking.setForeign_ids(foreignIdentifiers);

     // Set local_start_date using LocalStartDate object
        LocalStartDate localStartDate = new LocalStartDate();
        localStartDate.setYear(currentDate.getYear());
        localStartDate.setMonth(currentDate.getMonthValue());
        localStartDate.setDay(currentDate.getDayOfMonth());
       
        createBooking.setLocal_start_date(localStartDate);
        return createBooking;
    }
}
