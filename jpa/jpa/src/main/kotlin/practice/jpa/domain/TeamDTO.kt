package practice.jpa.domain

data class TeamDTO(
    var teamId : Long ? = null,
    var teamName : String ? = null,
    var members : MutableList<MemberDTO> = mutableListOf()
)