package com.example.WuyeGuanli.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.WuyeGuanli.dto.WhoRentalDTO;
import com.example.WuyeGuanli.entity.WhoRental;

public interface WhoRentalRepository extends JpaRepository<WhoRental, Integer> {
	// JPQL 查询
	@Query(value = "select new com.example.WuyeGuanli.dto.WhoRentalDTO(" + "wr.idwhoRental, " + "wr.rentalWhat, "
			+ "r.total, " + "wr.accountRental, " + "u.name, " + "wr.returnYorN, " + "wr.verify," + "wr.changeTime)"
			+ "from WhoRental as wr " + "join RentalInfo as r on wr.rentalWhat = r.item "
			+ "join User as u on wr.accountRental = u.identityNumber "
			+ "where wr.idwhoRental = ?1", nativeQuery = false)
	public List<WhoRentalDTO> selectWhoRentalById(int idwhoRental); // 對指定id查

	@Query(value = "select new com.example.WuyeGuanli.dto.WhoRentalDTO(" + "wr.idwhoRental, " + "wr.rentalWhat, "
			+ "r.total, " + "wr.accountRental, " + "u.name, " + "wr.returnYorN, " + "wr.verify," + "wr.changeTime)"
			+ "from WhoRental as wr " + "join RentalInfo as r on wr.rentalWhat = r.item "
			+ "join User as u on wr.accountRental = u.identityNumber "
			+ "order by wr.idwhoRental desc", nativeQuery = false)
	public List<WhoRentalDTO> selectAllWhoRental();// 全查


	@Modifying
    @Query(value = "UPDATE who_rental SET verify = CASE " 
            + "WHEN :inputAmount = (SELECT balance FROM transfer_money WHERE account = who_rental.account_rental) " 
            + "THEN true ELSE verify END " 
            + "WHERE idwho_rental = :idwho_rental", nativeQuery = true)
    public void verifyWhoRental(@Param("idwho_rental") int idwho_rental, @Param("inputAmount") int inputAmount);// 驗證更改 // 驗證更改
}
