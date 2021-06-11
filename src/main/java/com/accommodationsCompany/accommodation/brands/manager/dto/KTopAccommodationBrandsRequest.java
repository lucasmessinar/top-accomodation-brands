package com.accommodationsCompany.accommodation.brands.manager.dto;

import java.util.List;

public class KTopAccommodationBrandsRequest {
  private List<AccommodationBrandDto> accommodationBrands;

  public KTopAccommodationBrandsRequest() {
  }

  public KTopAccommodationBrandsRequest(List<AccommodationBrandDto> accommodationBrands) {
    this.accommodationBrands = accommodationBrands;
  }

  public List<AccommodationBrandDto> getAccommodationBrands() {
    return accommodationBrands;
  }

  public void setAccommodationBrands(List<AccommodationBrandDto> accommodationBrands) {
    this.accommodationBrands = accommodationBrands;
  }
}
