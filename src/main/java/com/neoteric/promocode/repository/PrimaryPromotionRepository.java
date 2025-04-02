package com.neoteric.promocode.repository;

import com.neoteric.promocode.entity.PrimaryPromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryPromotionRepository extends JpaRepository<PrimaryPromotionEntity, Long> {



}
