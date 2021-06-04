package {{meta.package}}.{{meta.nameLow}}.v{{meta.version}};

import com.rcore.rest.api.commons.response.OkApiResponse;
import com.rcore.rest.api.commons.response.SearchApiResponse;
import com.rcore.rest.api.commons.response.SuccessApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import {{meta.package}}.api.{{meta.nameLow}}.v{{meta.version}}.request.Search{{meta.nameUp}}Request;
import {{meta.package}}.api.{{meta.nameLow}}.v{{meta.version}}.request.Create{{meta.nameUp}}Request;
import {{meta.package}}.api.{{meta.nameLow}}.v{{meta.version}}.request.Update{{meta.nameUp}}Request;
import {{meta.package}}.api.{{meta.nameLow}}.v{{meta.version}}.response.{{meta.nameUp}}Response;

@Api(tags = "{{documentation.tag}}", description = "{{documentation.description}}")
@RestController
public interface Resource {

    @ApiOperation("Создание нового документа в ресурсе")
    @PostMapping(value = Routes.ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
    SuccessApiResponse<{{meta.nameUp}}Response> create(@RequestBody Create{{meta.nameUp}}Request request);

    @ApiOperation("Обновление документа в ресурсе")
    @PutMapping(value = Routes.SINGLETON, produces = MediaType.APPLICATION_JSON_VALUE)
    SuccessApiResponse<{{meta.nameUp}}Response> update(@PathVariable("id") String id, @RequestBody Update{{meta.nameUp}}Request request);

    @ApiOperation("Удаление документа в ресурсе")
    @DeleteMapping(value = Routes.SINGLETON, produces = MediaType.APPLICATION_JSON_VALUE)
    OkApiResponse delete(@PathVariable("id") String id);

    @ApiOperation("Получение документа в ресурсе")
    @GetMapping(value =  Routes.ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
    SuccessApiResponse<SearchApiResponse<{{meta.nameUp}}Response>> collection(Search{{meta.nameUp}}Request request);

    @ApiOperation("Получение продукта по ID")
    @GetMapping(value =  Routes.SINGLETON, produces = MediaType.APPLICATION_JSON_VALUE)
    SuccessApiResponse<{{meta.nameUp}}Response>  singleton(@PathVariable("id") String id);
}
