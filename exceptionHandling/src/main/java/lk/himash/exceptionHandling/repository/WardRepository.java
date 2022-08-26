package lk.himash.exceptionHandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.himash.exceptionHandling.model.Ward;

@Repository
public interface WardRepository extends JpaRepository<Ward, String> {

}
