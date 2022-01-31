package pro.paullezin.bootjava.vouting.error;

import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final ErrorAttributes errorAttributes;

    @ExceptionHandler(AppException.class)
    public ResponseEntity<Map<String, Object>> appException(AppException ae, WebRequest request) {
        Map<String, Object> body = errorAttributes.getErrorAttributes(request, ae.getOptions());
        HttpStatus status = ae.getStatus();
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", ae.getReason());
        return ResponseEntity.status(status).body(body);
    }
}