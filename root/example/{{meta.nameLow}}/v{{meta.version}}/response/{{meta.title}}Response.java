package {{meta.package}}.api.{{meta.nameLow}}.v{{meta.version}}.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
@ApiModel("{{document.description}}")
public class {{meta.nameUp}}Response {
    
    @ApiModelProperty("Идентификатор")
    protected String id;
    {{#document.fields}}
    @ApiModelProperty("{{description}}")
    {{accessModifier}} {{type}} {{name}};
    {{/document.fields}}


    
    {{#document.innerClases}}
    @Builder
    @Getter
    @Setter
    @ApiModel("{{description}}")
    public static class {{name}} {
        {{#fields}}
        @ApiModelProperty("{{description}}")
        {{accessModifier}} {{type}} {{name}};
        {{/fields}}
    }
    {{/document.innerClases}}
    
}
