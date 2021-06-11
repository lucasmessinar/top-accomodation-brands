package com.accommodationsCompany.accommodation.brands.manager;

import java.util.ArrayList;
import java.util.List;

public class AccommodationBrandNode {
  private final Long brandId;
  private final int propsCount;
  private final List<AccommodationBrandNode> subBrands;

  public AccommodationBrandNode(Long brandId, int propsCount) {
    this.brandId = brandId;
    this.propsCount = propsCount;
    this.subBrands = new ArrayList<>();
  }

  public void addSubBrand(AccommodationBrandNode subBrandNode) {
    this.subBrands.add(subBrandNode);
  }

  public Long getBrandId() {
    return brandId;
  }

  public int getPropsCount() {
    return subBrands.stream().map(AccommodationBrandNode::getPropsCount).reduce(0, Integer::sum) + propsCount;
  }
}
