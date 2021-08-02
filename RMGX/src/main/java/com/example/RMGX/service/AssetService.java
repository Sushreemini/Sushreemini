package com.example.RMGX.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.RMGX.entity.Asset;
import com.example.RMGX.others.AssignmentStatus;
import com.example.RMGX.repository.AssetRepository;

@Service
public class AssetService {
	@Autowired
	AssetRepository assetRepository;

	public Asset addAsset(Asset asset) {
	 System.out.println(asset);
		assetRepository.save(asset);
		return asset;
	}


	public void assignAsset(Long assetId, String empId) {
		Asset asset=new Asset();
		Optional<Asset>  oldrecord=assetRepository.findById(assetId);
		if(oldrecord.isPresent()) {
			asset=oldrecord.get();
			System.out.println(asset);
			
		}

			
		else {
			throw new RuntimeException("Asset is not available for assetId: " + assetId);
		}
		asset.setEmployeeId(empId);
		asset.setAssignmentStatus(AssignmentStatus.Assigned);
		assetRepository.save(asset);
		
	}


	public void recoverAsset(Long assetId, String empId) {
		Asset asset=new Asset();
		Optional<Asset>  oldrecord=assetRepository.findById(assetId);
		if(oldrecord.isPresent() ) {
			
			if(!asset.getEmployeeId().equals(empId)) {
				asset=oldrecord.get();
				
			}
			
		}
		else {
			throw new RuntimeException("Given asset id is not assigned to given empId");
		}
		asset.setEmployeeId(empId);
		asset.setAssignmentStatus(AssignmentStatus.Recovered);
		assetRepository.save(asset);
	}


	public void deleteAsset(Long asstId) {

		assetRepository.deleteById(asstId);
		
	}



	



	


	
	
}
