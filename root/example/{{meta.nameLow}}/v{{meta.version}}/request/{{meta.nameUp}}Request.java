package {{meta.package}}.api.{{meta.nameLow}}.v{{meta.version}}.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import {{meta.package}}.domain.{{meta.nameLow}}.usecases.Create{{meta.nameUp}}UseCase;
import {{meta.package}}.domain.{{meta.nameLow}}.usecases.Update{{meta.nameUp}}UseCase;

@Builder
@Getter
@Setter
@ApiModel("{{meta.description}}")
@NoArgsConstructor
@AllArgsConstructor
public class {{meta.nameUp}}Request {

    {{#document.fields}}
    @ApiModelProperty("{{description}}")
    {{accessModifier}} {{type}} {{name}};
    {{/document.fields}}

    public Update{{meta.nameUp}}UseCase.InputValues toUpdateInputValues(String id) {
        return Update{{meta.nameUp}}UseCase.InputValues
                .builder()
                .id(id)
                {{#document.fields}}
                .{{name}}({{name}})
                {{/document.fields}}
                .build();
    }

    public Create{{meta.nameUp}}UseCase.InputValues toCreateInputValues() {
        return Create{{meta.nameUp}}UseCase.InputValues
                .builder()
                {{#document.fields}}
                .{{name}}({{name}})
                {{/document.fields}}
                .build();
    }
}
