package co.edu.ue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ue.model.Productodescuento;

public interface ProductosDescuentoJPA extends JpaRepository<Productodescuento, Integer>{
	@Query("SELECT e FROM Productodescuento e WHERE e.FK_descuento = :fK_descuento")
	List<Productodescuento> findByFK_descuento(int fK_descuento);
	
	@Query("SELECT e FROM Productodescuento e WHERE e.FK_descuento=:fK_descuento AND e.FK_producto = :fk_producto ")
	Productodescuento findProducDescuento(int fK_descuento, int fk_producto);
}
