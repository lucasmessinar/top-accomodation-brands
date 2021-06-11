package com.accommodationsCompany.accommodation.brands.manager;

import com.accommodationsCompany.accommodation.brands.manager.dto.AccommodationBrandDto;
import com.accommodationsCompany.accommodation.brands.manager.dto.KTopAccommodationBrandsRequest;
import com.accommodationsCompany.accommodation.brands.manager.dto.KTopAccommodationBrandsResponse;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccommodationBrandsApplicationIT {

  @Value("${local.management.port}")
  private Integer managementPort;

  @Autowired
  private TestRestTemplate testRestTemplate;

  private RestTemplate actuatorRestTemplate = new RestTemplate();

  @Test
  public void contextLoads() {
  }

  @Test
  public void healthCheckWorkingProperly() {
    ResponseEntity<String> result = actuatorRestTemplate.exchange(
        "http://localhost:" + managementPort + "/actuator/health",
        HttpMethod.GET,
        HttpEntity.EMPTY,
        String.class
    );
    Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    Assertions.assertEquals("{\"status\":\"UP\"}", result.getBody());
  }

  @Test
  public void testBasicCaseWithUnorderedTopLevelBrandsInList() {
    List<AccommodationBrandDto> inputDtos = new ArrayList<>();
    inputDtos.add(new AccommodationBrandDto(12L, null, 5));
    inputDtos.add(new AccommodationBrandDto(3L, 0L, 11));
    inputDtos.add(new AccommodationBrandDto(4L, null, 10));
    inputDtos.add(new AccommodationBrandDto(1L, 4L, 5));
    inputDtos.add(new AccommodationBrandDto(0L, 7L, 1));
    inputDtos.add(new AccommodationBrandDto(7L, null, 5));

    KTopAccommodationBrandsRequest request = new KTopAccommodationBrandsRequest(inputDtos);

    ResponseEntity<KTopAccommodationBrandsResponse> response = testRestTemplate.exchange("/top/find?amount={amount}", HttpMethod.POST, new HttpEntity<>(request),
        KTopAccommodationBrandsResponse.class, 2);

    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(2, response.getBody().getTopAccommodationBrands().size());
  }
}
