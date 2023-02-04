package dev.yestoday.yestoday.core.follow.infrastructure;

import dev.yestoday.yestoday.core.follow.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    public List<Follow> findByUserId(Long userId);
}