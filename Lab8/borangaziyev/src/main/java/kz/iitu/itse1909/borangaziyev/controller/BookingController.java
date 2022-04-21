package kz.iitu.itse1909.borangaziyev.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.service.BookingService;
import lombok.extern.java.Log;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.List;
import java.util.Map;

@Log
@RestController
@RequestMapping(value = "booking/")
public class BookingController {

    private BookingService bookingService;
    private ObjectMapper objectMapper;

    @Autowired
    private ServletContext servletContext;



    @Value("${download.path}")
    String downloadFilePath;

    @Value("${upload-dir.path}")
    String uploadFilePath;


    @Autowired
    public BookingController(BookingService bookingService, ObjectMapper objectMapper) {
        this.bookingService = bookingService;
        this.objectMapper = objectMapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "all/")
    public ResponseEntity<List<Booking>> getAllBookings(
            @RequestHeader Map<String, String> headers) {

        List<Booking> bookings = bookingService.getAllBookings();

        headers.forEach((key, value) -> {
            log.info(String.format("Header '%s' = %s", key, value));
        });

        return ResponseEntity.ok(bookings);

    }



    @GetMapping(value = "bookingsByCustomerId/{id:[0-9]+}/{pageNo:[0-9]+}/{pageSize:[0-9]+}/{sortBy}")
    public ResponseEntity<List<Booking>> getPaidBookingsByCustomerId(
            @PathVariable(value = "id") long id,
            @PathVariable(value = "pageNo") int pageNo,
            @PathVariable(value = "pageSize") int pageSize,
            @PathVariable(value = "sortBy") String sortBy) {

        List<Booking> bookings = bookingService.getPaidBookingsPagination(id, pageNo, pageSize, sortBy);

        return ResponseEntity.ok(bookings);

    }

    @GetMapping("downloadFile/")
    public ResponseEntity downloadFile() throws FileNotFoundException {


        File file = new File(downloadFilePath);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentLength(file.length())
                .contentType(MediaType.TEXT_PLAIN)
                .body(resource);


    }

    @PostMapping(value = "uploadFile/{fileName:[A-z]}")
    public ResponseEntity uploadFile(
            @PathVariable("fileName") String fileName,
            @RequestParam("file") MultipartFile file
    ) {
        try {
            if(fileName == null || fileName.isEmpty()) fileName = "newUploadedFile.txt";
            File uploadFile = new File(uploadFilePath+fileName);
            OutputStream outputStream = new FileOutputStream(uploadFile);

            IOUtils.copy(file.getInputStream(), outputStream);

            uploadFile.createNewFile();

            return ResponseEntity.ok()
                    .body("Successfully uploaded!");

        } catch (FileNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e
            );
        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e
            );
        }
    }

}
