package com.example.WuyeGuanli.service.ifs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.WuyeGuanli.dto.WhoRentalDTO;
import com.example.WuyeGuanli.entity.RentalInfo;
import com.example.WuyeGuanli.vo.RentalInfoRes;
import com.example.WuyeGuanli.vo.WhoRentalRes;

public interface RentalInfoService {

	public RentalInfoRes addRental(RentalInfoRes rentalInfoRes) ;
	
	public RentalInfoRes deleteByPK(int idrental);
	
	public List<RentalInfo> getAll() ;
	
	//以下WhoRental
	
	public WhoRentalRes addWhoRental(WhoRentalRes whoRentalRes);
	
	public WhoRentalRes deleteByWRPK(int idwho_rental);
	
	public WhoRentalRes selectByWRPK(int idwho_rental);//對指定id查
	
	public List<WhoRentalDTO> selectAllWR();//全查
	
	public void verifyWhoRental(int idwho_rental, int inputAmount);
	}
