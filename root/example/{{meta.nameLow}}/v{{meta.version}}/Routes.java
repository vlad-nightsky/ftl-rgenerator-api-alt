package {{meta.package}}.api.{{meta.nameLow}}.v{{meta.version}};

import com.rcore.rest.api.commons.routes.BaseRoutes;

public class Routes {
    public static final String ROOT = BaseRoutes.API + BaseRoutes.V{{meta.version}} + "/{{meta.resource}}";
    public static final String SINGLETON = ROOT + "/{id}";
}
