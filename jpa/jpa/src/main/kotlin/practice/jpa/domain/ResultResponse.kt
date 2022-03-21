package practice.jpa.domain

data class ResultResponse(
    var list : MutableList<OrganizationDTO> = mutableListOf()
)