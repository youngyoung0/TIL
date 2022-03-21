package practice.jpa.domain

import javax.persistence.*

@Entity
@Table(name = "members")
class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long ? = null

    var name : String ? = null

    var gender : String ? = null

    var ban : Int ? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    var team : Team ? = null
}