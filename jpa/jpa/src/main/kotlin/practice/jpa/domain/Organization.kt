package practice.jpa.domain

import org.hibernate.annotations.BatchSize
import javax.persistence.*

@Entity
@Table(name = "organization")
class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long ? = null

    @Column(name = "org_name")
    var name : String ? = null

    //@BatchSize(size = 100)
    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    var teams : MutableList<Team> = mutableListOf()

}