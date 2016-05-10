package org.kj6682.kosimo.dm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by luigi on 03.05.16.
 */
@RestController
@RequestMapping("/media")
public class MediaController {

    @Autowired
    MediaRepository mediaRepository;

    @Feature(value = "find")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Media find(@PathVariable("id") String id) {
        return mediaRepository.findById(Long.decode(id).longValue())
                .orElseThrow(() -> new Main.MediaNotFoundException(id));
    }

    @Feature(value = "findAll")
    @RequestMapping(method = RequestMethod.GET)
    public List<Media> findAll() {
        List<Media> result = new LinkedList<Media>();
        mediaRepository.findAll().forEach(item -> result.add(item));
        return result;
    }

    @Feature(value = "findByTitle")
    @RequestMapping(value = "title/{title}", method = RequestMethod.GET)
    public List<Media> findByTitle(@PathVariable("title") String title) {
        return mediaRepository.findByTitle(title);
    }

    @Feature(value = "findByAuthor")
    @RequestMapping(value = "author/{author}", method = RequestMethod.GET)
    public List<Media> findByAuhtor(@PathVariable("author") String author) {
        return mediaRepository.findByAuthor(author);
    }

    @Feature(value = "findByType")
    @RequestMapping(value = "type/{type}", method = RequestMethod.GET)
    public List<Media> findByType(@PathVariable("type") String type) {
        return mediaRepository.findByType(Media.Type.valueOf(type.toUpperCase()));
    }


    @Feature(value = "create")
    @RequestMapping(method = RequestMethod.POST)
    public Long create(@RequestParam(value = "title") String title,
                       @RequestParam(value = "author") String author,
                       @RequestParam(value = "type") String type,
                       @RequestParam(value = "location") String location) {
        Media result = mediaRepository.save(new Media(title,
                                                      author,
                                                      Media.Type.valueOf(type.toUpperCase()),
                                                      location));

        return result.getId();
    }

    @Feature(value = "delete")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public HttpEntity<String> delete(@PathVariable("id") String id) {
        validateMedia(id);
        mediaRepository.delete(Long.decode(id).longValue());
        return new ResponseEntity<>(String.format("Media (%s) has been removed", id), HttpStatus.OK);
    }


    private void validateMedia(String... ids) {
        Stream.of(ids).forEach(id -> this.mediaRepository.findById(Long.decode(id).longValue())
                .orElseThrow(() -> new Main.MediaNotFoundException(id)));
    }


    @ExceptionHandler(UnsupportedOperationException.class)
    void unsupportedOperation(HttpServletResponse response, Exception e) throws IOException {
        response.sendError(
                HttpStatus.SERVICE_UNAVAILABLE.value(),
                e.getMessage()
        );
    }

    @ExceptionHandler(Main.MediaNotFoundException.class)
    void mediaNotFound(HttpServletResponse response, Exception e) throws IOException {
        response.sendError(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage()
        );
    }

    @ExceptionHandler(Exception.class)
    void handleGenericException(HttpServletResponse response, Exception e) throws IOException {
        String msg = "There was an error processing your request: " + e.getMessage();
        response.sendError(
                HttpStatus.BAD_REQUEST.value(),
                msg
        );
    }


}//:)

