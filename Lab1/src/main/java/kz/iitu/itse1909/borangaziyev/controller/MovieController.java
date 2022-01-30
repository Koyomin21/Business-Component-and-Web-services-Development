//package kz.iitu.itse1909.borangaziyev.controller;
//
//import kz.iitu.itse1909.borangaziyev.database.Movie;
//import kz.iitu.itse1909.borangaziyev.database.Seat;
//import kz.iitu.itse1909.borangaziyev.service.MovieService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "movies/")
//public class MovieController {
//
//    @Autowired
//    private MovieService service;
//    @Autowired
//    private SeatRepository seatRepository;
//
//    @GetMapping("/all")
//    public List<Movie> getMovies() {
//        return service.getAllMovies();
//    }
//
//    @GetMapping("/")
//    public String index() {
//        return "Hello from Index Page of Movie Controller!";
//    }
//
//    @GetMapping("/seat")
//    public Seat getSeat() {
//        return seatRepository.findById(1l).get();
//    }
//}
