package kz.iitu.itse1909.borangaziyev.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.service.BookingService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Log
@RestController
@RequestMapping(value = "booking/")
public class BookingController {

    private BookingService bookingService;
    private ObjectMapper objectMapper;


    @Autowired
    public BookingController(BookingService bookingService, ObjectMapper objectMapper) {
        this.bookingService = bookingService;
        this.objectMapper = objectMapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "all/")
    public ResponseEntity<List<Booking>> getAllBookings(
            @RequestHeader Map<String, String> headers) {
        try {
            List<Booking> bookings = bookingService.getAllBookings();

            headers.forEach((key, value) -> {
                log.info(String.format("Header '%s' = %s", key, value));
            });

            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e
            );
        }
    }



    @GetMapping(value = "bookingsByCustomerId/{id:[0-9]+}/{pageNo:[0-9]+}/{pageSize:[0-9]+}/{sortBy}")
    public ResponseEntity<List<Booking>> getPaidBookingsByCustomerId(
            @PathVariable(value = "id") long id,
            @PathVariable(value = "pageNo") int pageNo,
            @PathVariable(value = "pageSize") int pageSize,
            @PathVariable(value = "sortBy") String sortBy) {
        try {
            List<Booking> bookings = bookingService.getPaidBookingsPagination(id, pageNo, pageSize, sortBy);

            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e
            );
        }
    }

    @GetMapping("downloadFile/")
    public ResponseEntity downloadFile() {

        return null;
    }

}
