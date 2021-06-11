package com.accommodationsCompany.accommodation.brands.manager.controller;

import com.accommodationsCompany.accommodation.brands.manager.dto.KTopAccommodationBrandsRequest;
import com.accommodationsCompany.accommodation.brands.manager.dto.KTopAccommodationBrandsResponse;
import com.accommodationsCompany.accommodation.brands.manager.dto.TopAccommodationBrandDto;
import com.accommodationsCompany.accommodation.brands.manager.service.AccommodationBrandsService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccommodationBrandsController {

  private final AccommodationBrandsService accommodationBrandsService;

  public AccommodationBrandsController(
      AccommodationBrandsService accommodationBrandsService) {
    this.accommodationBrandsService = accommodationBrandsService;
  }

  @RequestMapping("/top/find")
  ResponseEntity<KTopAccommodationBrandsResponse> postKTopAccommodationBrandsSearch(@RequestBody
      KTopAccommodationBrandsRequest kTopAccommodationBrandsRequest,
      @RequestParam Integer amount) {
    List<TopAccommodationBrandDto> result = accommodationBrandsService.calculateKTopBrandsWithMoreAccommodations(
        kTopAccommodationBrandsRequest.getAccommodationBrands(), amount);
    return ResponseEntity.ok(new KTopAccommodationBrandsResponse(result));
  }
}
