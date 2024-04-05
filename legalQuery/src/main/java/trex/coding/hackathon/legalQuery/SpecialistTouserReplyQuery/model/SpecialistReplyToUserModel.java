package trex.coding.hackathon.legalQuery.SpecialistTouserReplyQuery.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trex.coding.hackathon.legalQuery.userQuerytoAdmin.model.UserToAdmin_QueryModel;

@Entity
@Table(name = "specialist_reply_to_user")
@Setter
@Getter
@NoArgsConstructor
public class SpecialistReplyToUserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserToAdmin_QueryModel userToAdmin_queryModel;
    private String specialistReply;



}
