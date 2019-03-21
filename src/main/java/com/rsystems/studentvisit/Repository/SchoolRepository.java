package com.rsystems.studentvisit.Repository;

import com.rsystems.studentvisit.Model.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends CrudRepository<School, String> {
}
