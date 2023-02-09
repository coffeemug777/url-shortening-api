package com.dennywibowo.urlshorteningapi.repository;

import com.dennywibowo.urlshorteningapi.model.UrlData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlDataRepository extends JpaRepository<UrlData, Long>{
}
