package cl.martin.joaquin.camel;

import cl.martin.joaquin.services.ProductService;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Routes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:fetchProducts")
                .routeId("direct-fetchProducts")
                .tracing()
                .log(">>> ${body}")
                .bean(ProductService.class, "fetchProductsByCategory")
                .end();

        from("direct:getKids")
                .to("sql:select name, age from kids?dataSource=DataStore")
                .log(">>> ${body}")
                .end();

    }

}