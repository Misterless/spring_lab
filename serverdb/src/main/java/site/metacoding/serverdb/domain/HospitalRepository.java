package site.metacoding.serverdb.domain;


import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public class HospitalRepository extends JpaRepository<Hospital, Integer>{
    
}
