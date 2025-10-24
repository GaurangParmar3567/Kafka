package com.example.demo.Repository;

import com.example.demo.Entities.KafkaMessages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaRepo extends JpaRepository<KafkaMessages,Integer> {

    @Query(value = "SELECT TOP (1) * FROM kafka_messages where msgkey=:key ORDER BY createDate DESC", nativeQuery = true)
    public KafkaMessages getLastMessage(@Param("key") String key);
}
