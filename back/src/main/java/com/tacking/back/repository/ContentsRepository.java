package com.tacking.back.repository;

import com.tacking.back.domain.entity.Contents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContentsRepository extends JpaRepository<Contents, String> {

    @Query(value = "select c from Contents c where c.id in " +
                    " (select cc.id.contentsId.id from CategoryContents cc where cc.id.category.id = :categoryId) ")
    List<Contents> findByCategory(String categoryId);

}
