package com.company.project.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.company.project.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository(value = "repository_product")
public interface ProductRepository extends JpaRepository<Product, Long> {

// Query Methods / Finder Methods...

    public abstract Optional<Product> queryById(Long id);

    List<Product> queryByName(String name);

    List<Product> queryByNameAndDescription(String name, String description);

    List<Product> queryByNameOrDescription(String name, String description);

    Optional<Product> queryDistinctByNameAndStockKeepingUnit(String name, String stockKeepingUnit);

    List<Product> queryByPriceGreaterThan(BigDecimal price);

    List<Product> queryByPriceLessThan(BigDecimal price);

    List<Product> queryByNameContaining(String name);

    List<Product> queryByNameLike(String name);

    List<Product> queryByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    List<Product> queryByDateCreateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // List<Product> queryByCountryIn(List<String> countries);
    List<Product> queryByNameIn(List<String> names);

    List<Product> queryFirst5ById(Long id);

    List<Product> queryTop5ById(Long id);

    List<Product> queryTop10ByOrderByIdAsc();

    List<Product> queryTop10ByOrderByIdDesc();

// JPQL: @Query Annotation

    // 1) JPQL: Index Parameters
    @Query("SELECT p FROM entity_product p WHERE p.name = ?1 AND p.price = ?2")
    Optional<Product> jpqlIndexParameters(String name, BigDecimal price);

    // 2) JPQL: Named Parameters
    @Query("SELECT p FROM entity_product p WHERE p.name = :name AND p.price = :price")
    Optional<Product> jpqlNamedParameters(@Param("name") String name, @Param("price") BigDecimal price);

// Native SQL: @Query Annotation

    // 1) Native SQL: Index Parameters
    @Query(value = "SELECT * FROM ecommerce.table_product WHERE product_name = ?1 AND product_price = ?2 ;", nativeQuery = true)
    Optional<Product> nativeSQLIndexParameters1(String name, BigDecimal price);

    @Query(value = "SELECT * FROM table_product WHERE product_name = ?1 AND product_price = ?2 ;", nativeQuery = true)
    Optional<Product> nativeSQLIndexParameters2(String name, BigDecimal price);

    // 2) Native SQL: Named Parameters
    @Query(value = "SELECT * FROM ecommerce.table_product WHERE product_name = :product_name AND product_price = :product_price ;", nativeQuery = true)
    Optional<Product> nativeSQLNamedParameters1(@Param("product_name") String name, @Param("product_price") BigDecimal price);

    @Query(value = "SELECT * FROM table_product WHERE product_name = :product_name AND product_price = :product_price ;", nativeQuery = true)
    Optional<Product> nativeSQLNamedParameters2(@Param("product_name") String name, @Param("product_price") BigDecimal price);

    @Query(value = "SELECT * FROM ecommerce.table_product WHERE product_name = :name AND product_price = :price ;", nativeQuery = true)
    Optional<Product> nativeSQLNamedParameters3(@Param("name") String name, @Param("price") BigDecimal price);

    @Query(value = "SELECT * FROM table_product WHERE product_name = :name AND product_price = :price ;", nativeQuery = true)
    Optional<Product> nativeSQLNamedParameters4(@Param("name") String name, @Param("price") BigDecimal price);

// JPQL: @NamedQuery Annotation & @NamedQueries Annotation

    List<Product> findByPriceAsc1();

    List<Product> findByPriceDesc1();

// Native SQL: @NamedNativeQuery Annotation & @NamedNativeQueries Annotation

    @Query(nativeQuery = true)
    List<Product> findByPriceAsc2();

    @Query(nativeQuery = true)
    List<Product> findByPriceDesc2();

}