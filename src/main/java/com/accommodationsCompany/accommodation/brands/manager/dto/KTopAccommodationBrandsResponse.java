package com.accommodationsCompany.accommodation.brands.manager.dto;

import java.util.List;

public class KTopAccommodationBrandsResponse {
  private List<TopAccommodationBrandDto> topAccommodationBrands;

  public KTopAccommodationBrandsResponse() {
  }

  public KTopAccommodationBrandsResponse(List<TopAccommodationBrandDto> topAccommodationBrands) {
    this.topAccommodationBrands = topAccommodationBrands;
  }

  public List<TopAccommodationBrandDto> getTopAccommodationBrands() {
    return topAccommodationBrands;
  }

  public void setTopAccommodationBrands(List<TopAccommodationBrandDto> topAccommodationBrands) {
    this.topAccommodationBrands = topAccommodationBrands;
  }
}
