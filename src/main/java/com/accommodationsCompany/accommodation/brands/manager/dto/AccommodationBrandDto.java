package com.accommodationsCompany.accommodation.brands.manager.dto;

public class AccommodationBrandDto {
  private Long brandId;
  private Long parentBrandId;
  private int propsCount;

  public AccommodationBrandDto(Long brandId, Long parentBrandId, int propsCount){
    this.brandId = brandId;
    this.parentBrandId = parentBrandId;
    this.propsCount = propsCount;
  }

  public Long getParentBrandId() {
    return parentBrandId;
  }

  public int getPropsCount() {
    return propsCount;
  }

  public Long getBrandId() {
    return brandId;
  }
}
