package com.accommodationsCompany.accommodation.brands.manager.service;

import com.accommodationsCompany.accommodation.brands.manager.dto.AccommodationBrandDto;
import com.accommodationsCompany.accommodation.brands.manager.dto.TopAccommodationBrandDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccommodationBrandServiceTest {

  private final AccommodationBrandsService accommodationBrandsService = new AccommodationBrandsService();

  @Test
  public void testBasicCaseWithUnorderedTopLevelBrandsInList() {
    List<AccommodationBrandDto> inputDtos = new ArrayList<>();
    inputDtos.add(new AccommodationBrandDto(12L, null, 5));
    inputDtos.add(new AccommodationBrandDto(3L, 0L, 11));
    inputDtos.add(new AccommodationBrandDto(4L, null, 10));
    inputDtos.add(new AccommodationBrandDto(1L, 4L, 5));
    inputDtos.add(new AccommodationBrandDto(0L, 7L, 1));
    inputDtos.add(new AccommodationBrandDto(7L, null, 5));

    List<TopAccommodationBrandDto> kTopAccommodations =
        accommodationBrandsService.calculateKTopBrandsWithMoreAccommodations(inputDtos, 2);
    Assertions.assertEquals(2, kTopAccommodations.size());
    Assertions.assertEquals(15, kTopAccommodations.get(1).getPropsCount());
    Assertions.assertEquals(4L, kTopAccommodations.get(1).getBrandId());
    Assertions.assertEquals(17, kTopAccommodations.get(0).getPropsCount());
    Assertions.assertEquals(7L, kTopAccommodations.get(0).getBrandId());
  }

  @Test
  public void testBasicCaseWithOnlyTopLevelBrandsInList() {
    List<AccommodationBrandDto> inputDtos = new ArrayList<>();
    inputDtos.add(new AccommodationBrandDto(1L, null, 1));
    inputDtos.add(new AccommodationBrandDto(2L, null, 2));
    inputDtos.add(new AccommodationBrandDto(3L, null, 3));

    List<TopAccommodationBrandDto> kTopAccommodations =
        accommodationBrandsService.calculateKTopBrandsWithMoreAccommodations(inputDtos, 4);
    Assertions.assertEquals(3, kTopAccommodations.size());
    Assertions.assertEquals(3, kTopAccommodations.get(0).getPropsCount());
    Assertions.assertEquals(3L, kTopAccommodations.get(0).getBrandId());
    Assertions.assertEquals(2, kTopAccommodations.get(1).getPropsCount());
    Assertions.assertEquals(2L, kTopAccommodations.get(1).getBrandId());
    Assertions.assertEquals(1, kTopAccommodations.get(2).getPropsCount());
    Assertions.assertEquals(1L, kTopAccommodations.get(2).getBrandId());
  }
}
