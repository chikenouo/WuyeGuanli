package com.example.WuyeGuanli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.WuyeGuanli.dto.WhoRentalDTO;
import com.example.WuyeGuanli.entity.RentalInfo;
import com.example.WuyeGuanli.service.ifs.RentalInfoService;
import com.example.WuyeGuanli.vo.RentalInfoRes;
import com.example.WuyeGuanli.vo.WhoRentalRes;

@RestController
@CrossOrigin
public class RentalInfoController {

	@Autowired
	private RentalInfoService rentalInfoService;

	@PostMapping("rental/add") // 只能單筆增加 要多筆要用List<> 或用for硬改
	public RentalInfoRes addRental(@RequestBody RentalInfoRes rentalInfoRes) {
		rentalInfoService.addRental(rentalInfoRes);
		return new RentalInfoRes(200, "新增成功", rentalInfoRes.getIdrental(), rentalInfoRes.getItem(),
				rentalInfoRes.getTotal(), rentalInfoRes.getRemark());
	}

	@DeleteMapping("rental/delete/{idrental}")
	public RentalInfoRes deleteByPK(@PathVariable("idrental") int idrental) {
		rentalInfoService.deleteByPK(idrental);
		return new RentalInfoRes(200, "刪除成功");
	}

	@GetMapping("rental/getall")
	public List<RentalInfo> getAll() {
		return rentalInfoService.getAll();
	}

	//

	@PostMapping("rental/whorental") // 對who_rental表增或改
	public WhoRentalRes addWhoRental(@RequestBody WhoRentalRes whoRentalRes) {
		rentalInfoService.addWhoRental(whoRentalRes);
		return new WhoRentalRes(200, "增或改租借檔案成功", whoRentalRes.getIdwhoRental(), whoRentalRes.getRentalWhat(),
				whoRentalRes.getAccountRental(), whoRentalRes.isReturnYorN(), whoRentalRes.isVerify(),
				whoRentalRes.getChangeTime(),0,"");
	}

	@DeleteMapping("rental/delete/whorental/{idwhorental}") // 對who_rental表id刪除
	public WhoRentalRes deleteByWRPK(@PathVariable("idwhorental") int idwho_rental) {
		rentalInfoService.deleteByWRPK(idwho_rental);
		return new WhoRentalRes(200, "刪除租借資訊成功");
	}

	@GetMapping("rental/whorentalinfo") // 連表對id查詢
	public WhoRentalRes selectByWRPK(@RequestParam("idwho_rental") int idwho_rental) {
	    WhoRentalRes result = rentalInfoService.selectByWRPK(idwho_rental);
	    if (result == null) {
	        return new WhoRentalRes(404, "找不到租借資訊");
	    }
	    return result;
	}
	@GetMapping("rental/whorentalallinfo") // 連表全查詢
	public List<WhoRentalDTO> selectAllWR() {
		return rentalInfoService.selectAllWR();
	}
}
