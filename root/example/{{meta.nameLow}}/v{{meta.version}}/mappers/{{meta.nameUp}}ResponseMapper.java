package {{meta.package}}.{{meta.apiPackage}}.{{meta.nameLow}}.v{{meta.version}}.mappers;

import {{meta.package}}.{{meta.apiPackage}}.{{meta.nameLow}}.v{{meta.version}}.response.{{meta.nameUp}}Response;
import {{meta.package}}.domain.{{meta.nameLow}}.entity.{{meta.nameUp}}Entity;

public class {{meta.nameUp}}ResponseMapper {
    public static {{meta.nameUp}}Response map({{meta.nameUp}}Entity entity) {
        return {{meta.nameUp}}Response.builder()
                .id(entity.getId())
                {{#document.fields}}
                {{#innerClass}}
                .{{name}}({{meta.nameUp}}ResponseMapper.map{{type}}(entity.get{{nameUperCase}}()))
                {{/innerClass}}
                {{^innerClass}}
                .{{name}}(entity.get{{nameUperCase}}())
                {{/innerClass}}
                {{/document.fields}}
                .build();
    }

    {{#innerClases}}
    private static {{meta.nameUp}}Response.{{name}} map{{name}}({{meta.nameUp}}Entity.{{name}} {{var}}) {
        return {{meta.nameUp}}Response.{{name}}
                .builder()
                {{#fields}}
                {{#innerClass}}
                .{{name}}(Update{{meta.nameUp}}Request.map{{type}}({{var}}.get{{nameUperCase}}()))
                {{/innerClass}}
                {{^innerClass}}
                .{{name}}({{var}}.get{{nameUperCase}}())
                {{/innerClass}}
                {{/fields}}
                .build();
    }
    {{/innerClases}}
}
