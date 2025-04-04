package com.neoteric.promocode.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neoteric.promocode.entity.PrimaryPromotionEntity;
import com.neoteric.promocode.model.PrimaryPromotion;
import com.neoteric.promocode.repository.PrimaryPromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrimaryPromotionService {

    @Autowired
    private PrimaryPromotionRepository promotionRepository;

    @Autowired
    private ObjectMapper objectMapper; // Injecting ObjectMapper

    public List<PrimaryPromotion> getAllPromotions() {
        List<PrimaryPromotionEntity> promotions = promotionRepository.findAll();
        return promotions.stream()
                .map(promotion -> objectMapper.convertValue(promotion, PrimaryPromotion.class))
                .collect(Collectors.toList());
    }

    public PrimaryPromotion getPromotionById(Long id) {
        PrimaryPromotionEntity promotion = promotionRepository.findById(id).orElse(null);
        return promotion != null ? objectMapper.convertValue(promotion, PrimaryPromotion.class) : null;
    }

    public PrimaryPromotion addPromotion(PrimaryPromotion promotionDTO) {
        PrimaryPromotionEntity promotion = objectMapper.convertValue(promotionDTO, PrimaryPromotionEntity.class);
        PrimaryPromotionEntity savedPromotion = promotionRepository.save(promotion);

        return objectMapper.convertValue(savedPromotion, PrimaryPromotion.class);

    }

    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }

//    public void savedata(PromotionDTO promotionDTO) {
//        Promotion promotion = Promotion.builder()
//                .name(promotionDTO.getName())
//                .description(promotionDTO.getDescription())
//                .build();
//        promotionRepository.save(promotion);
//    }







}