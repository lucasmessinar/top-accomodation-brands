package com.accommodationsCompany.accommodation.brands.manager.service;

import com.accommodationsCompany.accommodation.brands.manager.model.AccommodationBrandNode;
import com.accommodationsCompany.accommodation.brands.manager.dto.TopAccommodationBrandDto;
import com.accommodationsCompany.accommodation.brands.manager.dto.AccommodationBrandDto;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AccommodationBrandsService {

  public List<TopAccommodationBrandDto> calculateKTopBrandsWithMoreAccommodations(List<AccommodationBrandDto> brands,
      int k) {
    Map<Long, AccommodationBrandNode> nodeMap = new HashMap<>();
    Map<Long, Set<Long>> pendingToProcessSubBrandsOfBrand = new HashMap<>();
    Set<Long> topLevelBrands = new HashSet<>();
    brands.forEach(brand -> {

          AccommodationBrandNode currentNode =
              buildAccommodationBrandNode(nodeMap, pendingToProcessSubBrandsOfBrand.get(brand.getBrandId()), brand);

          if (brand.getParentBrandId() == null) {
            topLevelBrands.add(brand.getBrandId());
          } else {
            if (nodeMap.containsKey(brand.getParentBrandId())) {
              AccommodationBrandNode parentBrand = nodeMap.get(brand.getParentBrandId());
              parentBrand.addSubBrand(currentNode);
            } else {
              Set<Long> subBrandsOfParent = pendingToProcessSubBrandsOfBrand.get(brand.getParentBrandId());
              if (subBrandsOfParent != null) {
                subBrandsOfParent.add(brand.getBrandId());
              } else {
                Set<Long> newSubBrandsOfParent = new HashSet<>();
                newSubBrandsOfParent.add(brand.getBrandId());
                pendingToProcessSubBrandsOfBrand.put(brand.getParentBrandId(), newSubBrandsOfParent);
              }
            }
          }
          nodeMap.put(brand.getBrandId(), currentNode);
        }
    );

    return getKTopAccommodationBrands(k, nodeMap, topLevelBrands);
  }

  private AccommodationBrandNode buildAccommodationBrandNode(Map<Long, AccommodationBrandNode> nodeMap,
      Set<Long> subBrandsOfCurrentNode, AccommodationBrandDto brand) {
    AccommodationBrandNode currentNode = new AccommodationBrandNode(brand.getBrandId(), brand.getPropsCount());
    if (subBrandsOfCurrentNode != null) {
      subBrandsOfCurrentNode.forEach(subBrand -> {
        AccommodationBrandNode currentSubBrand = nodeMap.get(subBrand);
        currentNode.addSubBrand(currentSubBrand);
      });
    }
    return currentNode;
  }

  private List<TopAccommodationBrandDto> getKTopAccommodationBrands(int k, Map<Long, AccommodationBrandNode> nodeMap,
      Set<Long> topLevelBrands) {
    final TreeSet<TopAccommodationBrandDto> sortedTopBrands =
        new TreeSet<>(Comparator.comparing(TopAccommodationBrandDto::getPropsCount).reversed());
    topLevelBrands.stream()
        .map(nodeMap::get)
        .map(topLevelBrand -> new TopAccommodationBrandDto(topLevelBrand.getBrandId(), topLevelBrand.getPropsCount()))
        .forEach(sortedTopBrands::add);
    return sortedTopBrands.stream().limit(k).collect(Collectors.toList());
  }
}
