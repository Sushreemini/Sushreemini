package com.example.RMGX.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RMGX.entity.Asset;
@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

	List<Asset> findByName(String name);

}
