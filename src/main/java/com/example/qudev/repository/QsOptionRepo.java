package com.example.qudev.repository;

import com.example.qudev.model.question.QsOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QsOptionRepo extends JpaRepository<QsOption,Long>{

}
