package {{meta.package}}.api.{{meta.resource}}.v{{meta.version}}.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import {{meta.package}}.domain.{{meta.resource}}.entity.{{meta.title}}Entity;
import {{meta.package}}.domain.{{meta.resource}}.usecases.Create{{meta.title}}UseCase;
import {{meta.package}}.domain.{{meta.resource}}.usecases.Update{{meta.title}}UseCase;

@Builder
@Getter
@Setter
@ApiModel("{{meta.description}}")
@NoArgsConstructor
@AllArgsConstructor
public class {{meta.title}}Request {

    {{#document.fields}}
    @ApiModelProperty("{{description}}")
    {{accessModifier}} {{type}} {{name}};
    {{/document.fields}}

    public Update{{meta.title}}UseCase.InputValues toUpdateInputValues(String id) {
        return Update{{meta.title}}UseCase.InputValues
                .builder()
                .id(id)
                {{#document.fields}}
                .{{name}}({{name}})
                {{/document.fields}}
                .build();
    }

    public Create{{meta.title}}UseCase.InputValues toCreateInputValues() {
        return Create{{meta.title}}UseCase.InputValues
                .builder()
                {{#document.fields}}
                .{{name}}({{name}})
                {{/document.fields}}
                .build();
    }
}
