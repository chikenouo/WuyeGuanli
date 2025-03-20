package com.example.WuyeGuanli.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WuyeGuanli.dto.WhoRentalDTO;
import com.example.WuyeGuanli.entity.RentalInfo;
import com.example.WuyeGuanli.entity.WhoRental;
import com.example.WuyeGuanli.repository.RentalInfoRepository;
import com.example.WuyeGuanli.repository.WhoRentalRepository;
import com.example.WuyeGuanli.service.ifs.RentalInfoService;
import com.example.WuyeGuanli.vo.RentalInfoRes;
import com.example.WuyeGuanli.vo.WhoRentalRes;

@Service
public class RentalInfoImpl implements RentalInfoService {

	@Autowired
	private RentalInfoRepository rentalInfoRepository;

	@Autowired
	private WhoRentalRepository whoRentalRepository;

	@Override
	public RentalInfoRes addRental(RentalInfoRes rentalInfoRes) {
		RentalInfo rentalInfo = new RentalInfo();
		rentalInfo.setIdrental(rentalInfoRes.getIdrental());
		rentalInfo.setItem(rentalInfoRes.getItem());
		rentalInfo.setTotal(rentalInfoRes.getTotal());
		rentalInfo.setRemark(rentalInfoRes.getRemark());
		rentalInfoRepository.save(rentalInfo);
		return new RentalInfoRes(200, "新增成功", rentalInfoRes.getIdrental(), rentalInfoRes.getItem(),
				rentalInfoRes.getTotal(), rentalInfoRes.getRemark()); // 不是這邊返還回給前端
	}

	@Override
	public RentalInfoRes deleteByPK(int idrental) {
		rentalInfoRepository.deleteById(idrental);
		return null;
	}

	@Override
	public List<RentalInfo> getAll() {

		return rentalInfoRepository.findAll();

	}
	//

	@Override
	public WhoRentalRes addWhoRental(WhoRentalRes whoRentalRes) {
		WhoRental whoRental = new WhoRental();

		whoRental.setIdwhoRental(whoRentalRes.getIdwhoRental());
		whoRental.setRentalWhat(whoRentalRes.getRentalWhat());
		whoRental.setAccountRental(whoRentalRes.getAccountRental());
		whoRental.setReturnYorN(Boolean.TRUE.equals(whoRentalRes.isReturnYorN()));
		whoRental.setVerify(Boolean.TRUE.equals(whoRentalRes.isVerify()));
		whoRental.setChangeTime(LocalDateTime.now());
		whoRentalRepository.save(whoRental);
		return new WhoRentalRes(200, "新增成功");
	}

	@Override
	public WhoRentalRes deleteByWRPK(int idwho_rental) {
		whoRentalRepository.deleteById(idwho_rental);
		return null;
	}

	@Override
	public WhoRentalRes selectByWRPK(int idwho_rental) {
		List<WhoRentalDTO> whoRentalDTOList = whoRentalRepository.selectWhoRentalById(idwho_rental);

		if (whoRentalDTOList == null || whoRentalDTOList.isEmpty()) {
			return new WhoRentalRes(404, "找不到租借資訊");
		}

		WhoRentalDTO dto = whoRentalDTOList.get(0);

		return new WhoRentalRes(200, "查詢成功", dto.getIdwhoRental(), dto.getRentalWhat(), dto.getAccountRental(),
				dto.isReturnYorN(), dto.isVerify(), dto.getChangeTime(), dto.getTotal(), dto.getName());
	}

	@Override
	public List<WhoRentalDTO> selectAllWR() {
		// TODO Auto-generated method stub
		return whoRentalRepository.selectAllWhoRental();
	}

}
