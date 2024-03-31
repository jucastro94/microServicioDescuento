package co.edu.ue.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ue.model.Descuento;

public interface DescuentoJPA extends JpaRepository<Descuento, Integer>{
	//valida si el codigo es valido
    @Query("SELECT e FROM Descuento e WHERE e.codDescuento=:cod AND e.fechaInicio <= CURRENT_DATE() AND e.fechaFin >= CURRENT_DATE()")
    Descuento validarCod(String cod);
    
    //valida si el codigo existe
    @Query("SELECT d FROM Descuento d WHERE d.codDescuento = :cod")
    Descuento validarCodDesc(String cod);

    
}
