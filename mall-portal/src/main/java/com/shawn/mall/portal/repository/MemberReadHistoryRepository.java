package com.shawn.mall.portal.repository;

import com.shawn.mall.portal.domain.MemberReadHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Member view history
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
    Page<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId, Pageable pageable);
    void deleteAllByMemberId(Long memberId);
}
