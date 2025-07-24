package com.oracle.service;

import com.oracle.dto.AssetCoverageRatioDTO;
import com.oracle.dto.AssetDTO;
import com.oracle.entities.AssetCoverageComponent;
import com.oracle.repository.AssetCoverageRepository;
import com.oracle.repository.AssetRepository;
import com.oracle.entities.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssetCoverageServiceImpl implements AssetCoverageService {

    @Autowired
    private AssetCoverageRepository assetCoverageRepository;
    
    @Autowired
    private AssetRepository assetRepository;

    @Override
    public AssetCoverageRatioDTO calculateCoverageRatio(LocalDate reportingDate) {
        AssetCoverageComponent acc = assetCoverageRepository.findByReportingDate(reportingDate);
        if (acc == null) return null;

        return new AssetCoverageRatioDTO(
            acc.getBvta(),
            acc.getIa(),
            acc.getCl(),
            acc.getTotalDebt()
        );
    }

	@Override
	public List<AssetDTO> allAssets() {
		List<Asset> assets = assetRepository.getAssets();
		if(assets == null) return null;
		List<AssetDTO> assetDTOs =  new ArrayList<>();
		
		assets
		.stream()
		.forEach((asset)->{
			assetDTOs.add(new AssetDTO(asset.getAssetId(), asset.getAssetType(), asset.getAssetValue(), asset.getMaturityDate(), asset.getInterestRate(), asset.getDuration(), asset.getBookValue(), asset.getIsTangible(), asset.getAssetStatus(), asset.getProduct() != null ? asset.getProduct().getProdId() : null, asset.getIsRateSensitive(), asset.getStddev(), asset.getVarValue()));
		});
		
		return assetDTOs ;
	}
}
