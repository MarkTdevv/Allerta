package SoftwareTeamProject.Allerta;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class OcrService {

    private final Path tempDirectory = Files.createTempDirectory("uploaded-images");

    public OcrService() throws IOException {
        // Ensures the temp directory is set up
    }

    public String doOCR(MultipartFile file) throws IOException, TesseractException {
        File convFile = convertToFile(file);
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // Adjust based on where you store tessdata
        tesseract.setLanguage("eng"); // Use the appropriate language
        return tesseract.doOCR(convFile);
    }

    private File convertToFile(MultipartFile file) throws IOException {
        Path filepath = tempDirectory.resolve(file.getOriginalFilename());
        file.transferTo(filepath);
        return filepath.toFile();
    }
}

