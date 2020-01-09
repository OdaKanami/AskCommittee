package entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Ask_member;

@Repository
public interface Ask_memberRepository extends JpaRepository<Ask_member, Integer>{

}
