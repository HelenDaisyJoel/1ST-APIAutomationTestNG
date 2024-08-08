package utils;

import pojo.BookingResponse;

public class ApiServiceBooking extends BaseApiService<BookingResponse> {

    private final String createBookingEndpoint;
    private final String ApiEndpoint;
    private final String listBookingEndpoint;

    public ApiServiceBooking(ConfigUtility config) {
        super(config, BookingResponse.class);
        this.createBookingEndpoint = config.getProperty("createBookingEndpoint");
        this.listBookingEndpoint = config.getProperty("listBookingEndpoint");
        this.ApiEndpoint = config.getProperty("ApiEndpoint");
    }

    public BookingResponse createBooking(Object booking) {
        return create(createBookingEndpoint, booking);
    }

    public BookingResponse getBooking(String bookingName) {
        return get(ApiEndpoint + bookingName);
    }

    public BookingResponse deleteBooking(String bookingName) {
        return delete(ApiEndpoint + bookingName);
    }

    public BookingResponse listBookings() {
        return list(listBookingEndpoint);
    }

    public BookingResponse updateBooking(String bookingName, Object updatedBooking, String... fields) {
        String endpoint = ApiEndpoint + bookingName;
        System.out.println(endpoint);
        return update(endpoint, updatedBooking, fields);
    }

    public BookingResponse disableBooking(String bookingName) {
        return disable(ApiEndpoint + bookingName + ":disable");
    }

    public BookingResponse reenableBooking(String bookingName) {
        return reenable(ApiEndpoint + bookingName + ":reenable");
    }
}
