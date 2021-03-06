package io.liter.web.api.collection;

import io.liter.web.api.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Collection extends BaseEntity {

    @Id
    private Long id;

    private String collectionId;

    private String userId;

    private String fileName;

    private String type;

    private String path;

    private String hashCode;
}
