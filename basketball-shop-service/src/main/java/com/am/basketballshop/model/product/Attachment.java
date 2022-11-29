package com.am.basketballshop.model.product;

import com.am.basketballshop.model.base.BasedNanoIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "prd$attachments")
@Table(name = "ATTACHMENTS")
public class Attachment extends BasedNanoIdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "PRODUCT_MODEL_ID")
    private ProductModel productModel;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "UPLOAD_DATE", nullable = false, updatable = false)
    private LocalDate uploadDate;

    @Column(name = "IS_PREVIEW_IMAGE")
    private boolean isPreviewImage;

    @Column(name = "EXTENSION")
    private String extension;

    @Column(name = "SIZE")
    private Long size;

    @Column(name = "DOWNLOAD_LINK")
    private String downloadLink;

}
