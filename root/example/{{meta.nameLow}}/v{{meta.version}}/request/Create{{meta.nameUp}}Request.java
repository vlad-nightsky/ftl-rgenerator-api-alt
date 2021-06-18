package {{meta.package}}.{{meta.apiPackage}}.{{meta.nameLow}}.v{{meta.version}}.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import {{meta.package}}.domain.{{meta.nameLow}}.usecases.Create{{meta.nameUp}}UseCase;

@Builder
@Getter
@Setter
@ApiModel("{{document.description}}: для запроса на создание")
@NoArgsConstructor
@AllArgsConstructor
public class Create{{meta.nameUp}}Request {

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
    @ApiModel("{{description}}: для запроса на создание")
    public static class {{name}} {
        {{#fields}}
        @ApiModelProperty("{{description}}")
        {{accessModifier}} {{type}} {{name}};
        {{/fields}}
    }
    {{/innerClases}}

    public Create{{meta.nameUp}}UseCase.InputValues toInputValues() {
        return Create{{meta.nameUp}}UseCase.InputValues
                .builder()
                {{#document.fields}}
                {{#innerClass}}
                .{{name}}(Create{{meta.nameUp}}Request.map{{type}}({{name}}))
                {{/innerClass}}
                {{^innerClass}}
                .{{name}}({{name}})
                {{/innerClass}}
                {{/document.fields}}
                .build();
    }

    {{#innerClases}}
    private static Create{{meta.nameUp}}UseCase.InputValues.{{name}} map{{name}}({{name}} {{var}}) {
        return Create{{meta.nameUp}}UseCase.InputValues.{{name}}
                .builder()
                {{#fields}}
                {{#innerClass}}
                .{{name}}(Create{{meta.nameUp}}Request.map{{type}}({{var}}.{{name}}))
                {{/innerClass}}
                {{^innerClass}}
                .{{name}}({{var}}.{{name}})
                {{/innerClass}}
                {{/fields}}
                .build();
    }
    {{/innerClases}}
}
