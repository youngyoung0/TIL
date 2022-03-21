package practice.jpa.domain

import org.hibernate.annotations.BatchSize
import javax.persistence.*

@Entity
@Table(name = "Team")
class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long ? = null

    @Column(name = "team_name")
    var name : String ? = null


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    var organization : Organization ? = null

    //@BatchSize(size = 200)
    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    var members : MutableList<Member> = mutableListOf()

}