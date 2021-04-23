package {{meta.package}}.api.{{meta.resource}}.v{{meta.version}}.request;

import com.rcore.rest.api.commons.request.SearchApiRequest;
import {{meta.package}}.domain.{{meta.resource}}.port.filters.{{meta.title}}Filters;

public class Search{{meta.title}}Request extends SearchApiRequest {
    public {{meta.title}}Filters toFilters() {
        return {{meta.title}}Filters.builder()
                .limit(super.getLimit())
                .offset(super.getOffset())
                .query(super.getQuery())
                .sortDirection(super.getSortDirection().toString())
                .sortName(super.getSortName())
                .build();
    }
}
