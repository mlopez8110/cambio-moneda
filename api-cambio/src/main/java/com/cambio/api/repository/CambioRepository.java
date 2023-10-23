package com.cambio.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cambio.api.model.*;

@Repository
public interface CambioRepository extends JpaRepository<Cambio,Long> {
	
//	@Query(value = "SELECT * from view_ventas", nativeQuery = true)
//	List<Cambio> findAllNative();

	@Query(value = "SELECT pair.id, pair.monedaorigen, pair.monedafinal, pair.tipocambio\r\n"
			+ "FROM\r\n"
			+ "  (\r\n"
			+ "     SELECT f.id, f.monedaorigen, t.monedaorigen monedafinal, (f.tipocambio/t.tipocambio) tipocambio\r\n"
			+ "     FROM cambio f, cambio t\r\n"
			+ "     WHERE\r\n"
			+ "     f.monedafinal = t.monedafinal\r\n"
			+ "     AND f.monedafinal = 'SOL'\r\n"
			+ "  ) pair\r\n"
			+ "LEFT OUTER JOIN cambio\r\n"
			+ "ON pair.monedafinal = cambio.monedafinal\r\n"
			+ "AND pair.monedaorigen = cambio.monedaorigen where pair.monedafinal=:monedafinal and pair.monedaorigen=:monedaorigen", nativeQuery = true)
	List<Cambio> findByMonedaNative(@Param("monedafinal") String monedafinal, @Param("monedaorigen") String monedaorigen);

}
