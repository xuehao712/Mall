package com.shawn.mall.portal.repository;

import com.shawn.mall.portal.domain.MemberBrandAttention;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Member attention repository
 */
public interface MemberBrandAttentionRepository extends MongoRepository<MemberBrandAttention,String> {
    MemberBrandAttention findByMemberIdAndBrandId(Long memberId, Long brandId);
    int deleteByMemberIdAndBrandId(Long memberId, Long brandId);
    Page<MemberBrandAttention> findByMemberId(Long memberId, Pageable pageable);
    void deleteAllByMemberId(Long memberId);
}
