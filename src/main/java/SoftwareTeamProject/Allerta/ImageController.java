package SoftwareTeamProject.Allerta;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.codec.binary.Base64;
import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @PostMapping("/upload")
    public String uploadImageAndConvertToBase64(@RequestParam("image") MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            byte[] bytes = imageFile.getBytes();
            String base64 = Base64.encodeBase64String(bytes);
            return base64;
        }
        return "Failed to convert image";
    }
}

