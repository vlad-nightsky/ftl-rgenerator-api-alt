package {{meta.package}}.{{meta.apiPackage}}.{{meta.nameLow}}.v{{meta.version}}.request;

import com.rcore.rest.api.commons.request.SearchApiRequest;
import io.swagger.annotations.ApiModel;
import {{meta.package}}.domain.{{meta.nameLow}}.port.filters.{{meta.nameUp}}Filters;


@ApiModel("{{document.description}}: для запроса на поиск")
public class Search{{meta.nameUp}}Request extends SearchApiRequest {
    public {{meta.nameUp}}Filters toFilters() {
        return {{meta.nameUp}}Filters.builder()
                .limit(super.getLimit())
                .offset(super.getOffset())
                .query(super.getQuery())
                .sortDirection(super.getSortDirection().toString())
                .sortName(super.getSortName())
                .build();
    }
}
