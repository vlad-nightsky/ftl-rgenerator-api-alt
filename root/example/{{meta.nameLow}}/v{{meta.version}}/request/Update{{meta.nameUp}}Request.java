package {{meta.package}}.{{meta.apiPackage}}.{{meta.nameLow}}.v{{meta.version}}.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import {{meta.package}}.domain.{{meta.nameLow}}.usecases.Create{{meta.nameUp}}UseCase;
import {{meta.package}}.domain.{{meta.nameLow}}.usecases.Update{{meta.nameUp}}UseCase;

@Builder
@Getter
@Setter
@ApiModel("{{document.description}}: для запроса на обновление")
@NoArgsConstructor
@AllArgsConstructor
public class Update{{meta.nameUp}}Request {

    {{#document.fields}}
    @ApiModelProperty("{{description}}")
    {{accessModifier}} {{type}} {{name}};
    {{/document.fields}}


    {{#innerClases}}
    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel("{{description}}: для запроса на обновление")
    public static class {{name}} {
        {{#fields}}
        @ApiModelProperty("{{description}}")
        {{accessModifier}} {{type}} {{name}};
        {{/fields}}
    }
    {{/innerClases}}

    public Update{{meta.nameUp}}UseCase.InputValues toInputValues(String id) {
        return Update{{meta.nameUp}}UseCase.InputValues
                .builder()
                .id(id)
                {{#document.fields}}
                {{#innerClass}}
                .{{name}}(Update{{meta.nameUp}}Request.map{{type}}({{name}}))
                {{/innerClass}}
                {{^innerClass}}
                .{{name}}({{name}})
                {{/innerClass}}
                {{/document.fields}}
                .build();
    }

    {{#innerClases}}
    private static Update{{meta.nameUp}}UseCase.InputValues.{{name}} map{{name}}({{name}} {{var}}) {
        return Update{{meta.nameUp}}UseCase.InputValues.{{name}}
                .builder()
                {{#fields}}
                {{#innerClass}}
                .{{name}}(Update{{meta.nameUp}}Request.map{{type}}({{name}}))
                {{/innerClass}}
                {{^innerClass}}
                .{{name}}({{var}}.{{name}})
                {{/innerClass}}
                {{/fields}}
                .build();
    }
    {{/innerClases}}
}
