package school.hei.sary.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import school.hei.sary.service.event.ImageProcessService;

import java.io.IOException;

@RestController
public class ImageProcessController {

    private final ImageProcessService imageProcessService;

    @Autowired
    public ImageProcessController(ImageProcessService imageProcessService) {
        this.imageProcessService = imageProcessService;
    }

    @PutMapping(value = "/blacked/{id}", consumes = "multipart/form-data")
    public ResponseEntity<String> processImage(@PathVariable("id") String id, @RequestPart("image") MultipartFile image)
            throws IOException {
        String presignedUrl = imageProcessService.processImage(id, image);
        return ResponseEntity.ok(presignedUrl);
    }

    /*@GetMapping("/blacked/{id}")
    public ResponseEntity<String> getUrlOfOriginalAndOutputImage(@PathVariable String id) {

    }*/
}
