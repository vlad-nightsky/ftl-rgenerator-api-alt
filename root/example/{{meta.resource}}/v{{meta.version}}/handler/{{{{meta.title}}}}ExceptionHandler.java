package {{meta.package}}.api.{{meta.resource}}.v{{meta.version}}.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.foodtechlab.aeh.core.Error;
import ru.foodtechlab.aeh.core.ErrorApiResponse;
import ru.foodtechlab.i18n.I18NHelper;
import {{meta.package}}.domain.{{meta.resource}}.exceptions.{{meta.title}}DomainException;
import {{meta.package}}.domain.{{meta.resource}}.exceptions.{{meta.title}}NotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Locale;

@RequiredArgsConstructor
@RestControllerAdvice
public class {{meta.title}}ExceptionHandler {
    private final I18NHelper i18NHelper;

    @ExceptionHandler({ {{meta.title}}DomainException.class })
    public ResponseEntity<ErrorApiResponse<Error>> handleException({{meta.title}}DomainException exception, HttpServletRequest request, Locale locale){
        ErrorApiResponse<Error> errorErrorApiResponse = ErrorApiResponse.badRequest(
                Collections.singletonList(Error.of(i18NHelper.getTitle(exception, locale), i18NHelper.getMessage(exception, locale), exception.getDomain(), exception.getMessage())),
                request.getRequestURI()
        );

        return ResponseEntity.status(errorErrorApiResponse.getStatus())
                .body(errorErrorApiResponse);
    }

    @ExceptionHandler({ {{meta.title}}NotFoundException.class })
    public ResponseEntity<ErrorApiResponse<Error>> handleException({{meta.title}}NotFoundException exception, HttpServletRequest request, Locale locale){
        ErrorApiResponse<Error> errorErrorApiResponse = ErrorApiResponse.notFound(
                Collections.singletonList(Error.of(i18NHelper.getTitle(exception, locale), i18NHelper.getMessage(exception, locale), exception.getDomain(), exception.getMessage())),
                request.getRequestURI()
        );

        return ResponseEntity.status(errorErrorApiResponse.getStatus())
                .body(errorErrorApiResponse);
    }
}
