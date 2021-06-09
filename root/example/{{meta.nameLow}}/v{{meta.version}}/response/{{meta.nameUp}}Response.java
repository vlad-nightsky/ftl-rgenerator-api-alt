package {{meta.package}}.{{meta.apiPackage}}.{{meta.nameLow}}.v{{meta.version}}.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@ApiModel("{{document.description}}: общая модель ответа")
public class {{meta.nameUp}}Response {
    
    @ApiModelProperty("Идентификатор")
    protected String id;
    {{#document.fields}}
    @ApiModelProperty("{{description}}")
    {{accessModifier}} {{type}} {{name}};
    {{/document.fields}}


    
    {{#innerClases}}
    @Builder
    @Getter
    @Setter
    @ApiModel("{{description}}}: общая модель")
    public static class {{name}} {
        {{#fields}}
        @ApiModelProperty("{{description}}")
        {{accessModifier}} {{type}} {{name}};
        {{/fields}}
    }
    {{/innerClases}}
    
}
