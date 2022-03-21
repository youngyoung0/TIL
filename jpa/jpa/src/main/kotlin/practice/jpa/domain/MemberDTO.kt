package practice.jpa.domain

data class MemberDTO(
    var memId : Long ? = null,
    var memName : String ? = null,
    var memGender : String ? = null,
    var ban : Int ? = null
)