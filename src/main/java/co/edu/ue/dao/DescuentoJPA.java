package co.edu.ue.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ue.model.Descuento;

public interface DescuentoJPA extends JpaRepository<Descuento, Integer>{
    @Query("SELECT iddescuento FROM descuento e WHERE e.codDescuento=:cod AND CURDATE() BETWEEN e.fechaInicio AND e.fechaFin;")
	boolean validarCod(String cod);
    
    @Query("SELECT e FROM descuento e WHERE e.codDescuento = :cod;")
    Descuento validarCodDesc(String cod);

    
}
