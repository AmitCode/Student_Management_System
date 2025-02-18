package com.student.management.repository;

import com.student.management.pojo.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInfoRepository extends JpaRepository<StudentInfo,Long> {
}
