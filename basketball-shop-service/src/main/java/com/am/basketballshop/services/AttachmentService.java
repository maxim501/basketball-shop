package com.am.basketballshop.services;

import com.am.basketballshop.api.dto.attachments.RequestAttachmentDto;
import com.am.basketballshop.api.dto.attachments.ResponseAttachmentDto;
import com.am.basketballshop.config.AttachmentConfig;
import com.am.basketballshop.converters.base.UniversalConverter;
import com.am.basketballshop.exception.NotFoundException;
import com.am.basketballshop.model.product.Attachment;
import com.am.basketballshop.model.product.ProductModel;
import com.am.basketballshop.repository.AttachmentRepository;
import com.am.basketballshop.repository.ProductModelRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttachmentService {

    private final AttachmentConfig attachmentConfig;
    private final AttachmentRepository attachmentRepository;

    private final ProductModelRepository modelRepository;

    private final UniversalConverter converter;

    public ResponseAttachmentDto createAttachment(RequestAttachmentDto attachmentDto, MultipartFile file) throws IOException {

        Optional<ProductModel> productModelById = modelRepository.findById(attachmentDto.getProductModelId());
        ProductModel productModel = productModelById.orElseThrow(() -> {
            throw new NotFoundException("Not found product model by id = " + attachmentDto.getProductModelId());
        });

        Attachment attachment = new Attachment();
        attachment.setProductModel(productModel);
        attachment.setTitle("attach_" + LocalDate.now() + "_" +
                file.getOriginalFilename().toLowerCase().replaceAll(" ", "-"));
        attachment.setUploadDate(LocalDate.now());
        attachment.setExtension(file.getContentType());
        attachment.setSize(file.getSize());
        attachment.setPreviewImage(attachmentDto.isPreviewImage());

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(attachmentConfig.getHost());
        HttpEntity entity = MultipartEntityBuilder.create()
                .addBinaryBody("source", file.getBytes(),
                        ContentType.create(attachment.getTitle() + "/png"),
                        attachment.getTitle() + ".png")
                .addTextBody("key", attachmentConfig.getApiKey())
                .build();
        httpPost.setEntity(entity);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        httpClient.close();

        String jsonString = EntityUtils.toString(httpResponse.getEntity());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonString);
        JsonNode imageNode = jsonNode.get("image");
        if (imageNode != null) {
            attachment.setDownloadLink(imageNode.get("url").asText());
        }

        Attachment saveAttachment = attachmentRepository.save(attachment);
        return converter.entityToDto(saveAttachment, ResponseAttachmentDto.class);
    }

    public ResponseAttachmentDto getAttachment(String attachmentId) {
        Optional<Attachment> attachmentById = attachmentRepository.findById(attachmentId);
        Attachment attachment = attachmentById.orElseThrow(() -> {
            throw new NotFoundException("Not found attachment by id = " + attachmentId);
        });
        return converter.entityToDto(attachment, ResponseAttachmentDto.class);
    }

}
