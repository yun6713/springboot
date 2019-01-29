package com.bonc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bonc.entity.Test01;
@Repository
public interface TestJpaRepository extends JpaRepository<Test01,Long> {

}
