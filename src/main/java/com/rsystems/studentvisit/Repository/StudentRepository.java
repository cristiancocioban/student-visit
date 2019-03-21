package com.rsystems.studentvisit.Repository;

import com.rsystems.studentvisit.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
}
