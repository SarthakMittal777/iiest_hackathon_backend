package trex.coding.hackathon.legalQuery.userQuerytoAdmin.model;

import jakarta.persistence.*;
import lombok.*;
import trex.coding.hackathon.legalQuery.SpecialistTouserReplyQuery.model.SpecialistReplyToUserModel;


@Entity
@Table(name = "user_to_admin_query_model")
@Getter
@Setter
@NoArgsConstructor
public class UserToAdmin_QueryModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "user_id")
        private String userId;

        @Column(name = "query")
        private String query;


        private String queryId;

        @Column(name = "specialist_id", nullable = true )
        private Long specialistId;



    public UserToAdmin_QueryModel(String userId, String query,  Long specialistId, String queryId) {
            this.userId = userId;
            this.query = query;
            this.specialistId = specialistId;
            this.queryId = queryId;
        }
}
