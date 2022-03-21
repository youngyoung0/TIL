package practice.jpa.domain

import javax.persistence.Id

data class SearchDTO(
    var name: String? = null,
    var gender : String ? = null,
    var ban : Int ? = null,
    var teamId : Long ? = null,
    var orgId : Long ? = null
)