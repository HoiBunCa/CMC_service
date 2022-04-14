package com.tima.ai.callCmc.call_CMC.model.repo;

import com.tima.ai.callCmc.call_CMC.model.entity.CmcLog;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

@Repository
public interface CmcLogRepo extends CrudRepository<CmcLog, String> {

    @Query(value="select * from log_call_cmc lcc where phone = :phone", nativeQuery = true)
    List<CmcLog> select_all(String phone);

}
