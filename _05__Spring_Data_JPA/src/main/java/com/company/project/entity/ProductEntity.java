package com.company.project.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "entity_product")
@Table(
        name = "table_product",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_product_stock_keeping_unit",
                        columnNames = "product_stock_keeping_unit"
                )
        }
)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_product")
    @SequenceGenerator(name = "generator_product", sequenceName = "sequence_table_product", initialValue = 1, allocationSize = 1)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_stock_keeping_unit", length = 30, nullable = false, unique = false)
    private String stockKeepingUnit;

    @Column(name = "product_name", length = 30, nullable = false, unique = false)
    private String name;

    @Lob
    @Column(name = "product_description", nullable = false, unique = false)
    private String description;

    @Column(name = "product_price", nullable = false, unique = false)
    private BigDecimal price;

    @Column(name = "product_active", nullable = false, unique = false)
    private boolean active;

    @Column(name = "product_image_url", length = 30, nullable = false, unique = false)
    private String imageUrl;

    @Basic
    @CreationTimestamp
    @Column(name = "product_date_created", nullable = false, unique = false)
    private LocalDateTime dateCreate;

    @Basic
    @UpdateTimestamp
    @Column(name = "product_date_updated", nullable = false, unique = false)
    private LocalDateTime dateUpdate;

    public ProductEntity() {

    }

    public ProductEntity(String stockKeepingUnit, String name, String description, BigDecimal price, boolean active,
                         String imageUrl) {
        super();
        this.stockKeepingUnit = stockKeepingUnit;
        this.name = name;
        this.description = description;
        this.price = price;
        this.active = active;
        this.imageUrl = imageUrl;
    }

    public ProductEntity(String stockKeepingUnit, String name, String description, BigDecimal price, boolean active,
                         String imageUrl, LocalDateTime dateCreate, LocalDateTime dateUpdate) {
        super();
        this.stockKeepingUnit = stockKeepingUnit;
        this.name = name;
        this.description = description;
        this.price = price;
        this.active = active;
        this.imageUrl = imageUrl;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public ProductEntity(Long id, String stockKeepingUnit, String name, String description, BigDecimal price, boolean active,
                         String imageUrl, LocalDateTime dateCreate, LocalDateTime dateUpdate) {
        super();
        this.id = id;
        this.stockKeepingUnit = stockKeepingUnit;
        this.name = name;
        this.description = description;
        this.price = price;
        this.active = active;
        this.imageUrl = imageUrl;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockKeepingUnit() {
        return stockKeepingUnit;
    }

    public void setStockKeepingUnit(String stockKeepingUnit) {
        this.stockKeepingUnit = stockKeepingUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @Override
    public String toString() {
        return "Product -> [ id=" + id + ", stockKeepingUnit=" + stockKeepingUnit + ", name=" + name + ", description=" + description + ", price=" + price + ", active=" + active + ", imageUrl=" + imageUrl + ", dateCreate=" + dateCreate + ", dateUpdate=" + dateUpdate + " ]";
    }

}