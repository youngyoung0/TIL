package practice.jpa.domain

data class OrganizationDTO(
    var orgId : Long ? = null,
    var orgName : String ? = null,
    var teams : MutableList<TeamDTO> = mutableListOf()
)