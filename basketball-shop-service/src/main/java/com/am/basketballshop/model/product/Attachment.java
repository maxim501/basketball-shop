package com.am.basketballshop.model.product;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "prd$attachments")
@Table(name = "ATTACHMENTS")
public class Attachment {

    @Id
    @Column(name = "PRODUCT_MODEL_ID")
    private String id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "UPLOAD_DATE",nullable = false, updatable = false)
    private LocalDate uploadDate;

    @Column(name = "EXTENSION")
    private String extension;

    @Column(name = "SIZE")
    private Long size;

    @Column(name = "DOWNLOAD_LINK")
    private String downloadLink;

    @OneToOne
    @MapsId
    @JoinColumn(name = "PRODUCT_MODEL_ID")
    private ProductModel productModel;
}
