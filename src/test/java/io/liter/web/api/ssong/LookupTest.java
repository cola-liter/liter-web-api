package io.liter.web.api.ssong;

import io.liter.web.api.review.Review;
import io.liter.web.api.sample.SampleHandlerTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
public class LookupTest {

    private static Logger log = LoggerFactory.getLogger(SampleHandlerTest.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void lookupOperation() {
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("Follower")
                .localField("userId")
                .foreignField("followerId")
                .as("followers");

        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("userId").is("1")), lookupOperation);


        List<Review> results = mongoTemplate.aggregate(aggregation, "Review", Review.class).getMappedResults();


        log.debug("]-----] result [-----[ {}", results);


    }
}