package {{meta.package}}.api.{{meta.resource}}.v{{meta.version}};

import com.rcore.domain.commons.usecase.UseCaseExecutor;
import com.rcore.domain.commons.usecase.model.FiltersInputValues;
import com.rcore.domain.commons.usecase.model.IdInputValues;
import com.rcore.rest.api.commons.response.OkApiResponse;
import com.rcore.rest.api.commons.response.SearchApiResponse;
import com.rcore.rest.api.commons.response.SuccessApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import {{meta.package}}.api.{{meta.resource}}.v{{meta.version}}.request.{{meta.title}}Request;
import {{meta.package}}.api.{{meta.resource}}.v{{meta.version}}.request.Search{{meta.title}}Request;
import {{meta.package}}.api.{{meta.resource}}.v{{meta.version}}.mappers.{{meta.title}}ResponseMapper;
import {{meta.package}}.api.{{meta.resource}}.v{{meta.version}}.response.{{meta.title}}Response;
import {{meta.package}}.domain.{{meta.resource}}.config.{{meta.title}}Config;
import {{meta.package}}.domain.{{meta.resource}}.exceptions.{{meta.title}}NotFoundException;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component("{{meta.resource}}ControllerV{{meta.version}}")
public class Controller implements Resource {
    private final UseCaseExecutor useCaseExecutor;
    private final {{meta.title}}Config {{meta.resource}}Config;


    @Override
    public SuccessApiResponse<{{meta.title}}Response> create({{meta.title}}Request request) {
        return useCaseExecutor.execute(
                {{meta.resource}}Config.create{{meta.title}}UseCase(),
                request.toCreateInputValues(),
                output -> SuccessApiResponse.of({{meta.title}}ResponseMapper.map(output.getEntity()))
        );
    }

    @Override
    public SuccessApiResponse<{{meta.title}}Response> update(String id, {{meta.title}}Request request) {
        return useCaseExecutor.execute(
                {{meta.resource}}Config.update{{meta.title}}UseCase(),
                request.toUpdateInputValues(id),
                output -> SuccessApiResponse.of({{meta.title}}ResponseMapper.map(output.getEntity()))
        );
    }

    @Override
    public OkApiResponse delete(String id) {
        return useCaseExecutor.execute(
                {{meta.resource}}Config.delete{{meta.title}}UseCase(),
                IdInputValues.of(id),
                o -> new OkApiResponse()
        );
    }

    @Override
    public SuccessApiResponse<SearchApiResponse<{{meta.title}}Response>> collection(Search{{meta.title}}Request request) {
        return useCaseExecutor.execute(
                {{meta.resource}}Config.find{{meta.title}}sUseCase(),
                FiltersInputValues.of(request.toFilters()),
                (o) -> SuccessApiResponse.of(SearchApiResponse.withItemsAndCount(
                        o.getResult().getItems().stream().map({{meta.title}}ResponseMapper::map).collect(Collectors.toList()),
                        o.getResult().getCount()
                ))
        );
    }

    @Override
    public SuccessApiResponse<{{meta.title}}Response> singleton(String id) {
        return useCaseExecutor.execute(
                {{meta.resource}}Config.find{{meta.title}}ByIdUseCase(),
                IdInputValues.of(id),
                o -> o.getEntity().map(entity -> SuccessApiResponse.of({{meta.title}}ResponseMapper.map(entity)))
                        .orElseThrow({{meta.title}}NotFoundException::new)
        );
    }
}
