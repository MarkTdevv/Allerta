package SoftwareTeamProject.Allerta;

import net.sourceforge.tess4j.TesseractException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleIOException(IOException ex) {
        return "Error handling file: " + ex.getMessage();
    }

    @ExceptionHandler(TesseractException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleTesseractException(TesseractException ex) {
        return "Error processing OCR: " + ex.getMessage();
    }
}

