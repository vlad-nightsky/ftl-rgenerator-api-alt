package {{meta.package}}.api.{{meta.resource}}.v{{meta.version}}.mappers;

import {{meta.package}}.api.{{meta.resource}}.v{{meta.version}}.response.{{meta.title}}Response;
import {{meta.package}}.domain.{{meta.resource}}.entity.{{meta.title}}Entity;

import java.util.ArrayList;

public class {{meta.title}}ResponseMapper {
    public static {{meta.title}}Response map({{meta.title}}Entity entity) {
        return {{meta.title}}Response.builder()
                .id(entity.getId())
                {{#document.fields}}
                .{{name}}(entity.get{{nameUperCase}}())
                {{/document.fields}}
                .build();
    }
}
