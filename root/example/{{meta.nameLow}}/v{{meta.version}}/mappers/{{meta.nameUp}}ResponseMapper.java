package {{meta.package}}.api.{{meta.nameLow}}.v{{meta.version}}.mappers;

import {{meta.package}}.api.{{meta.nameLow}}.v{{meta.version}}.response.{{meta.nameUp}}Response;
import {{meta.package}}.domain.{{meta.nameLow}}.entity.{{meta.nameUp}}Entity;

public class {{meta.nameUp}}ResponseMapper {
    public static {{meta.nameUp}}Response map({{meta.nameUp}}Entity entity) {
        return {{meta.nameUp}}Response.builder()
                .id(entity.getId())
                {{#document.fields}}
                .{{name}}(entity.get{{nameUperCase}}())
                {{/document.fields}}
                .build();
    }
}
