package com.example.demo.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LeaveDetails;
@Repository
public interface LeaveDetailRepository extends JpaRepository<LeaveDetails, Integer>{

	List<LeaveDetails> findAllByStartdateGreaterThanEqualAndEnddateLessThanEqual(Date Startdate, Date Enddate);
	
	List<LeaveDetails> findAllByleavecategory(String leave);

}

