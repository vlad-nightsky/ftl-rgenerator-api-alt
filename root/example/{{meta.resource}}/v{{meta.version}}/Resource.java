package {{meta.package}}.api.{{meta.resource}}.v{{meta.version}};

import com.rcore.rest.api.commons.response.OkApiResponse;
import com.rcore.rest.api.commons.response.SearchApiResponse;
import com.rcore.rest.api.commons.response.SuccessApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import {{meta.package}}.api.{{meta.resource}}.v{{meta.version}}.request.Search{{meta.title}}Request;
import {{meta.package}}.api.{{meta.resource}}.v{{meta.version}}.request.{{meta.title}}Request;
import {{meta.package}}.api.{{meta.resource}}.v{{meta.version}}.response.{{meta.title}}Response;

@Api(tags = "{{documentation.tag}}", description = "{{documentation.description}}")
@RestController("{{meta.resource}}AdminControllerV1")
public interface Resource {

    @ApiOperation("Создание нового документа в ресурсе")
    @PostMapping(value = Routes.ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
    SuccessApiResponse<{{meta.title}}Response> create(@RequestBody {{meta.title}}Request request);

    @ApiOperation("Обновление документа в ресурсе")
    @PutMapping(value = Routes.SINGLETON, produces = MediaType.APPLICATION_JSON_VALUE)
    SuccessApiResponse<{{meta.title}}Response> update(@PathVariable("id") String id, @RequestBody {{meta.title}}Request request);

    @ApiOperation("Удаление документа в ресурсе")
    @DeleteMapping(value = Routes.SINGLETON, produces = MediaType.APPLICATION_JSON_VALUE)
    OkApiResponse delete(@PathVariable("id") String id);

    @ApiOperation("Получение документа в ресурсе")
    @GetMapping(value =  Routes.ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
    SuccessApiResponse<SearchApiResponse<{{meta.title}}Response>> collection(Search{{meta.title}}Request request);

    @ApiOperation("Получение продукта по ID")
    @GetMapping(value =  Routes.SINGLETON, produces = MediaType.APPLICATION_JSON_VALUE)
    SuccessApiResponse<{{meta.title}}Response>  singleton(@PathVariable("id") String id);
}
