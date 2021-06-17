package {{meta.package}}.{{meta.apiPackage}}.{{meta.nameLow}}.v{{meta.version}};

import com.rcore.domain.commons.usecase.UseCaseExecutor;
import com.rcore.domain.commons.usecase.model.FiltersInputValues;
import com.rcore.domain.commons.usecase.model.IdInputValues;
import com.rcore.rest.api.commons.response.OkApiResponse;
import com.rcore.rest.api.commons.response.SearchApiResponse;
import com.rcore.rest.api.commons.response.SuccessApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import {{meta.package}}.{{meta.apiPackage}}.{{meta.nameLow}}.v{{meta.version}}.request.Create{{meta.nameUp}}Request;
import {{meta.package}}.{{meta.apiPackage}}.{{meta.nameLow}}.v{{meta.version}}.request.Update{{meta.nameUp}}Request;
import {{meta.package}}.{{meta.apiPackage}}.{{meta.nameLow}}.v{{meta.version}}.request.Search{{meta.nameUp}}Request;
import {{meta.package}}.{{meta.apiPackage}}.{{meta.nameLow}}.v{{meta.version}}.mappers.{{meta.nameUp}}ResponseMapper;
import {{meta.package}}.{{meta.apiPackage}}.{{meta.nameLow}}.v{{meta.version}}.response.{{meta.nameUp}}Response;
import {{meta.package}}.domain.{{meta.nameLow}}.config.{{meta.nameUp}}Config;
import {{meta.package}}.domain.{{meta.nameLow}}.exceptions.{{meta.nameUp}}NotFoundException;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component("{{meta.nameLow}}ControllerV{{meta.version}}")
public class {{meta.nameUp}}Controller implements Resource {
    private final UseCaseExecutor useCaseExecutor;
    private final {{meta.nameUp}}Config {{meta.nameLow}}Config;


    @Override
    public SuccessApiResponse<{{meta.nameUp}}Response> create(Create{{meta.nameUp}}Request request) {
        return useCaseExecutor.execute(
                {{meta.nameLow}}Config.create{{meta.nameUp}}UseCase(),
                request.toInputValues(),
                output -> SuccessApiResponse.of({{meta.nameUp}}ResponseMapper.map(output.getEntity()))
        );
    }

    @Override
    public SuccessApiResponse<{{meta.nameUp}}Response> update(String id, Update{{meta.nameUp}}Request request) {
        return useCaseExecutor.execute(
                {{meta.nameLow}}Config.update{{meta.nameUp}}UseCase(),
                request.toInputValues(id),
                output -> SuccessApiResponse.of({{meta.nameUp}}ResponseMapper.map(output.getEntity()))
        );
    }

    @Override
    public OkApiResponse delete(String id) {
        return useCaseExecutor.execute(
                {{meta.nameLow}}Config.delete{{meta.nameUp}}UseCase(),
                IdInputValues.of(id),
                o -> new OkApiResponse()
        );
    }

    @Override
    public SuccessApiResponse<SearchApiResponse<{{meta.nameUp}}Response>> collection(Search{{meta.nameUp}}Request request) {
        return useCaseExecutor.execute(
                {{meta.nameLow}}Config.find{{meta.nameUp}}UseCase(),
                FiltersInputValues.of(request.toFilters()),
                (o) -> SuccessApiResponse.of(SearchApiResponse.withItemsAndCount(
                        o.getResult().getItems().stream().map({{meta.nameUp}}ResponseMapper::map).collect(Collectors.toList()),
                        o.getResult().getCount()
                ))
        );
    }

    @Override
    public SuccessApiResponse<{{meta.nameUp}}Response> singleton(String id) {
        return useCaseExecutor.execute(
                {{meta.nameLow}}Config.find{{meta.nameUp}}ByIdUseCase(),
                IdInputValues.of(id),
                o -> o.getEntity().map(entity -> SuccessApiResponse.of({{meta.nameUp}}ResponseMapper.map(entity)))
                        .orElseThrow({{meta.nameUp}}NotFoundException::new)
        );
    }
}
