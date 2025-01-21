package com.challenge.forohub.repository;

import com.challenge.forohub.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends JpaRepository<Profile, Long> {
}
