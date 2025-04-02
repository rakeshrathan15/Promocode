package com.neoteric.promocode.controller;

import com.neoteric.promocode.model.PrimaryPromotion;
import com.neoteric.promocode.service.PrimaryPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/promotions")
public class PrimaryPromotionController {

    @Autowired
    private PrimaryPromotionService promotionService;

    @GetMapping("/allPromotions")
    public List<PrimaryPromotion> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    @GetMapping("/{id}")
    public PrimaryPromotion getPromotionById(@PathVariable Long id) {
        return promotionService.getPromotionById(id);
    }

    @PostMapping("/addPromotion")
    public PrimaryPromotion addPromotion(@RequestBody PrimaryPromotion promotionDTO) {
        return promotionService.addPromotion(promotionDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePromotion(@PathVariable Long id) {
        promotionService.deletePromotion(id);
    }
}
