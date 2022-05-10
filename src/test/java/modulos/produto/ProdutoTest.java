package modulos.produto;


import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactort;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

@DisplayName("Teste de api rest no modulo de produto")
public class ProdutoTest {

    private String token;

    @BeforeEach
    public void setup() {
        baseURI = "http://165.227.93.41";
        // port "8080"
        basePath = "/lojinha";

        this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactort.criarUsuarioConvencional())
            .when()
                .post("/login")
            .then()
                .extract()
                    .path("data.token");
    }


    @Test
    @DisplayName("Teste de api rest no modulo de produto limite superior")
    public void testValidarLimitesProibidosvalorProduto() {

        given()
                .contentType(ContentType.JSON)
                .header("token", token)
                .body(ProdutoDataFactory.criarProdutoComunComValorIgualA(7000.01))
            .when()
                .post("/v2/produtos")
            .then()
                .assertThat()
                    .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                    .statusCode(422);
    }

    @Test
    @DisplayName("Teste de api rest no modulo de produto limite inferior")
    public void testValidarLimitesProibidosvalorInferior() {

        given()
                .contentType(ContentType.JSON)
                .header("token", token)
                .body(ProdutoDataFactory.criarProdutoComunComValorIgualA(0.00))
            .when()
                .post("/v2/produtos")
            .then()
                .assertThat()
                    .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                    .statusCode(422);
    }

}