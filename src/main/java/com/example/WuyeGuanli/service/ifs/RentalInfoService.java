package com.example.WuyeGuanli.service.ifs;

import java.util.List;

import com.example.WuyeGuanli.entity.RentalInfo;
import com.example.WuyeGuanli.vo.RentalInfoRes;
import com.example.WuyeGuanli.vo.WhoRentalRes;

public interface RentalInfoService {

	public RentalInfoRes addRental(RentalInfoRes rentalInfoRes) ;
	
	public RentalInfoRes deleteByPK(int idrental);
	
	public List<RentalInfo> getAll() ;
	
	//以下WhoRental
	
	public WhoRentalRes addWhoRental(WhoRentalRes whoRentalRes);
	
	public RentalInfoRes deleteByWRPK(int idwho_rental);
	
}
