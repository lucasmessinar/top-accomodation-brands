package dto;

public class TopAccommodationBrandDto {

  private Long brandId;
  private int propsCount;

  public TopAccommodationBrandDto(Long brandId, int propsCount){
    this.brandId = brandId;
    this.propsCount = propsCount;
  }

  public Long getBrandId() {
    return brandId;
  }

  public int getPropsCount() {
    return propsCount;
  }
}
