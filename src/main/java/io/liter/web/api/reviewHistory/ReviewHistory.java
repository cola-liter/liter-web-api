package io.liter.web.api.reviewHistory;


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
public class ReviewHistory extends BaseEntity {

    @Id
    private Long id;

    private String userId;

    private String reviewId;

}
