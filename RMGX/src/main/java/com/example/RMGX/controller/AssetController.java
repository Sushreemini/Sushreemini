package com.example.RMGX.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RMGX.entity.Asset;

import com.example.RMGX.repository.AssetRepository;
import com.example.RMGX.service.AssetService;

@RestController
public class AssetController {
	@Autowired
	AssetService assetService;
	@Autowired
	AssetRepository assetRepository;
	
	@PostMapping("/asset")
	public Asset addAsset(@RequestBody Asset asset) {
		return this.assetService.addAsset(asset);
	}
	@GetMapping("/asset/name")
	public ResponseEntity<List<Asset>>getAssetByName(@RequestParam String name){
		return new ResponseEntity<List<Asset>>(assetRepository.findByName(name),HttpStatus.OK);
	}
	@PutMapping("/asset/{assetId}")
	public ResponseEntity<Asset>updateAsset(@RequestBody Asset asset){
		try {
			return new ResponseEntity<Asset>(assetRepository.save(asset),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/{assetId}/assign")
	public void assignAsset(@PathVariable Long assetId, @RequestBody String empId) {
		assetService.assignAsset(assetId, empId);
	}
	@PutMapping("/{assetId}/recover")
	public void recoverAsset(@PathVariable Long assetId, @RequestBody String empId) {
		assetService.recoverAsset(assetId, empId);
	}
	@DeleteMapping("/page/{assetId}")
	public String deleteAsset(@PathVariable Long asstId) {	
		assetService.deleteAsset(asstId);
		return "deleted succesfully";
	
	}
	}
	
	
	

